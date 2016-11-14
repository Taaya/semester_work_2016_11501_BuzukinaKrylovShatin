package ru.myproject.helpers;

/**
 * Created by taa on 13.11.16.
 */
public class CookieTokenizer {

    public String getCookieHash(String cookie){
        MD5 md5 = new MD5();
        String hash = md5.getHash(cookie);
        String randomString = CookieTokenizer.stringGenerator();
        String token = hash + randomString;
        return token;
    }

    public static String stringGenerator(){
        String symbols = "zxcvbnmjhgfdaitwql";
        StringBuilder randString = new StringBuilder();
        for(int i=0;i<10;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));

        return randString.toString();
    }
}
