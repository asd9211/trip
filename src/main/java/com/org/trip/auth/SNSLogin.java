package com.org.trip.auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.org.trip.vo.UserVO;

public class SNSLogin {

	private OAuth20Service oauthService;
	private SnsValue sns;
	
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId()).apiSecret(sns.getClientSecret()).callback(sns.getRedirectUrl()).scope("profile").build(sns.getApi20Instance());
		this.sns = sns;
	}

	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}

	public UserVO getUserProfile(String code) throws IOException, InterruptedException, ExecutionException {
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
		OAuthRequest request = new OAuthRequest(Verb.GET, this.sns.getProfileUrl());
		
		oauthService.signRequest(accessToken, request);
		Response response = oauthService.execute(request);
		return parseJson(response.getBody());
	}
	public UserVO parseJson(String body) throws IOException {
		UserVO user = new UserVO();		
		ObjectMapper mapper = new ObjectMapper();		
		
		if(this.sns.isGoogle()) {	
			JsonNode rootNode = mapper.readTree(body);
			user.setGoogleId(rootNode.get("id").asText());
			Iterator<JsonNode> iterEmails = rootNode.path("emails").elements();
			while(iterEmails.hasNext()) {
				JsonNode emailNode = iterEmails.next();
				String type = emailNode.get("type").asText();
				if(StringUtils.equals(type, "account")) {
					user.setGoogleEmail(emailNode.get("value").asText());
					break;
				}
			}
		} else if(this.sns.isNaver()){
			Map<String,Object> rMap = mapper.readValue(body.toString(),Map.class);
			user.setNaverId(((Map)rMap.get("response")).get("id").toString());
			user.setNaverEmail(((Map)rMap.get("response")).get("email").toString());	
		}
		return user;
	}
}
