package com.simplishop.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;


@Component
public class JWTGenerator {
    public String generateToken(Authentication authentication) {
        String emailAddress = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

//         BUILDER MAKES TOKENS SO WE DON'T HAVE TO WORRY ABOUT IMPLEMENTATION
        Algorithm algorithm = Algorithm.HMAC512(SecurityConstants.JWT_SECRET); // TODO Change the secret
        JWTCreator.Builder jwtBuilder = JWT.create();
        String token = jwtBuilder
                .withSubject(emailAddress)
                .withIssuedAt(new Date())
                .withExpiresAt(expiryDate)
                .sign(algorithm);
//                .setSubject(emailAddress)
//                .setIssuedAt(new Date())
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS256, SecurityConstants.JWT_SECRET) // HS512 original
//                .compact();
        return token;
    }
    public String getEmailFromJWT(String token) {

        // THis is the encoded jwt
        JWT jwt = new JWT();

        // Decode the jwt
        DecodedJWT decodedJWT = jwt.decodeJwt(token);

        // Get all claims
        return decodedJWT.getSubject();

//        GET ALL CLAIMS FROM TOKENS
//        Claims claims = Jwts.parser()
//                .setSigningKey(SecurityConstants.JWT_SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//        return ((Claims) claims).getSubject();
    }

    public boolean validateToken(String token) {
        DecodedJWT decodedJWT;
        try{
            Algorithm algorithm = Algorithm.HMAC512(SecurityConstants.JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build();

            decodedJWT = verifier.verify(token);
            Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWR was expired or incorrect");
        }
    }
}
