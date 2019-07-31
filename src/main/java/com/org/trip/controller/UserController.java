package com.org.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.trip.auth.SNSLogin;
import com.org.trip.auth.SnsValue;
import com.org.trip.service.UserService;
import com.org.trip.util.InsertPic;
import com.org.trip.vo.UserVO;

@RestController
@CrossOrigin("*")
public class UserController {
	@Resource
	private UserService us;
	@Resource
	private SnsValue naverSns;
	@Resource
	private SnsValue googleSns;
	@Resource
	private GoogleConnectionFactory googleConnectionFactory;
	@Resource
	private OAuth2Parameters googleOAuth2Parameters;
	
	@GetMapping("/users")
	public List<UserVO> getUserList(){
		return us.getUserList();
	}
	
	@RequestMapping(value="/auth/{service}/callback", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView snsLoginCallback(@RequestParam String code,@PathVariable String service) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirectToFront");
		SnsValue sns = null;
		if(StringUtils.equals("naver", service))
			sns = naverSns;
		else if(StringUtils.equals("google", service))
			sns = googleSns;
		SNSLogin snslogin = new SNSLogin(sns);
		UserVO snsUser = snslogin.getUserProfile(code);
		UserVO pUser = us.getUserBySns(snsUser);
		if(pUser!=null) {
			snsUser.setUserNum(pUser.getUserNum());
			snsUser.setUserNick(pUser.getUserNick());
			snsUser.setUserLevel(pUser.getUserLevel());
		}
		ObjectMapper om = new ObjectMapper();
		mv.addObject("snsUser",om.writeValueAsString(snsUser));
		return mv;
	} 
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public Map<String,String> SnsLogin() {
		Map<String,String> urlMap = new HashMap<String,String>();
		SNSLogin snsLogin = new SNSLogin(naverSns);
		urlMap.put("naver_url", snsLogin.getNaverAuthURL());
				
		/* 구글code 발행을 위한 URL 생성 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String urlStr = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		urlMap.put("google_url", urlStr);
		return urlMap;
	}
	@PostMapping("/login")
	public UserVO getLogin(@RequestBody UserVO user) {
		UserVO rUser = us.getLogin(user);
		return rUser;
	}
	@PostMapping("/user")
	public Integer insertUser(@RequestBody UserVO user) {
		System.out.println(user);
		return us.insertUser(user);
	}
	@PostMapping("/userDelete")
	   public Integer userDelete(@RequestBody UserVO user) {
	      return us.deleteUser(user);
	   }	   
	@PostMapping("/users")
	   public Integer userUpdate(@ModelAttribute UserVO user) {
	    return us.updateUser(user);
	   }

	@PostMapping("/userCheck")
	public UserVO getUserByNick(@RequestBody UserVO user) {
		return us.getUserByNick(user);
	}
	@GetMapping("/user/{userNum}")
	public UserVO getUser1(@PathVariable Integer userNum) {
		UserVO pUser = us.getUser(userNum);
		pUser.setUserPwd(null);
		pUser.setUserBirth(pUser.getUserBirth().substring(0,10));
		return pUser; 
	}
	@GetMapping("user")
	public UserVO getUser(@RequestParam(value="userNum")Integer userNum) {
		return us.getUser(userNum);
	}
}
