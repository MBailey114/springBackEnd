package com.simplishop.security;

//CREATING CONSTANTS IN A SEPARATE FILE SO THEY CAN BE "CHANGED" FURTHER ALONG
//HAVING A CENTRALISED PLACE TO CHANGE THESE
//REFERENCED IN JWT GENERATOR
public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;
    public static final String JWT_SECRET = "secret";
}
