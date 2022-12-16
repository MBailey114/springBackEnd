package com.simplishop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;



@Component
public class JWTGenerator {
    public String generateToken(Authentication authentication) {
        String emailAddress = authentication.getEmailAddress();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

//         BUILDER MAKES TOKENS SO WE DON'T HAVE TO WORRY ABOUT IMPLEMENTATION
        String token = Jwts.builder()
                .setSubject(emailAddress)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .compact();
        return token;
    }
    public String getEmailFromJWT(String token) {
//        GET ALL CLAIMS FROM TOKENS
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return ((Claims) claims).getSubject();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWR was expired or incorrect");
        }
    }
}
