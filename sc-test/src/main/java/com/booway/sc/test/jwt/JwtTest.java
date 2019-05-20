package com.booway.sc.test.jwt;

import java.util.Map;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.HashMap;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@SuppressWarnings("all")
public class JwtTest
{
	/** 秘钥 */
	private String key = "feabtrsrhytjtujkyuk";
	
	@Test
	public void testGenToken()
	{
		Map<String, Object> params = new HashMap<>();
		params.put("id", "aaaa");
		params.put("user", "张三");
		String rs = Jwts.builder()
			.setSubject("user info")
			.setClaims(params)
			.signWith(SignatureAlgorithm.HS512, key.getBytes(Charset.forName("utf-8")))
			.compact();
		System.out.println(rs);
	}
	@Test
	public void parseToken()
	{
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJpZCI6ImFhYWEiLCJ1c2VyIjoi5byg5LiJIn0._W1u3n9xpPWEtJDU2CSQ7z1g2SURpK00zxmnj1mCVP6my70-mFfb6OKStVdCmh7RuuHuP7-PneYDGtO_i5vJkQ";
		Map<String, Object> params = (Map<String, Object>) Jwts.parser()
			.setSigningKey(key.getBytes(Charset.forName("utf-8")))
			.parse(token)
			.getBody();
		System.out.println(params);
	}
}
