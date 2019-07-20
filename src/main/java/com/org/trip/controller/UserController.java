package com.org.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.trip.auth.SNSLogin;
import com.org.trip.auth.SnsValue;
import com.org.trip.service.UserService;
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
	public @ResponseBody List<UserVO> getUserList(){
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
	public UserVO getLogin(@RequestBody UserVO user,HttpSession session) {
		UserVO rUser = us.getLogin(user);
		if(rUser!=null) {
			session.setAttribute("userVO", rUser);
		}
		return rUser;
	}
	@PostMapping("/user")
	public Integer insertUser(@RequestBody UserVO user) {
		System.out.println(user);
		return us.insertUser(user);
	}
	@DeleteMapping("/user")
	   public Integer userDelete(@RequestBody UserVO user) {
	      return us.deleteUser(user);
	   }	   
	@PutMapping("/user")
	   public Integer userUpdate(@RequestBody UserVO user) {
	      return us.updateUser(user);
	   }	
}
