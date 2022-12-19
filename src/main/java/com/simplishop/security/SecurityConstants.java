package com.simplishop.security;

//CREATING CONSTANTS IN A SEPARATE FILE SO THEY CAN BE "CHANGED" FURTHER ALONG
//HAVING A CENTRALISED PLACE TO CHANGE THESE
//REFERENCED IN JWT GENERATOR
public class SecurityConstants {

    // ms to expire in 1000 * 60 * 60 * 24 ms = 1 day
    //
    public static final long JWT_EXPIRATION = 1000*60*60*24;
    public static final String JWT_SECRET = "JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2JzAPk7jKJmYRuhYTFiS2";
}