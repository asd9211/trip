package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.org.trip.auth.SNSLogin;
import com.org.trip.auth.SnsValue;
import com.org.trip.service.UserService;
import com.org.trip.vo.UserVO;

@RestController
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
	public ModelAndView snsLoginCallback(Model m, @RequestParam String code,@PathVariable String service) throws Exception{
		SnsValue sns = null;
		if(StringUtils.equals("naver", service))
			sns = naverSns;
		else if(StringUtils.equals("google", service))
			sns = googleSns;
		SNSLogin snslogin = new SNSLogin(sns);
		UserVO snsUser = snslogin.getUserProfile(code);
		System.out.println(snsUser);
		m.addAttribute("result",snsUser);
		ModelAndView mav = new ModelAndView("/loginResult");
		return mav;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView SnsLogin(Model m) {
		SNSLogin snsLogin = new SNSLogin(naverSns);
		m.addAttribute("naver_url", snsLogin.getNaverAuthURL());
				
		/* 구글code 발행을 위한 URL 생성 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		m.addAttribute("google_url", url);
		ModelAndView mav = new ModelAndView("/login");
		return mav;
	}
	@PostMapping("/login")
	public UserVO getLogin(@RequestBody UserVO user) {		
		return us.getLogin(user);
	}
	@PostMapping("/user")
	public Integer insertUser(@RequestBody UserVO user) {
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
