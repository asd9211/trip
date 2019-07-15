package com.org.trip.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.org.trip.vo.UserVO;

@Component
public class JWTGenerator {

	private static final String TOKEN_KEY = "aventador";
	
	public String generateJWT(UserVO user) throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
		Date issuDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date expireDate = calendar.getTime();
		return JWT.create().withIssuer(user.getUserId()).withIssuedAt(issuDate).withExpiresAt(expireDate).sign(Algorithm.HMAC256(TOKEN_KEY));
	}
	public void checkJWT(String tokken,UserVO user) throws IllegalArgumentException, UnsupportedEncodingException {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_KEY)).withIssuer(user.getUserId()).build();
		DecodedJWT decode = verifier.verify(TOKEN_KEY);
	}
}
