package com.taxtechnicaltestdemo.domainobject;



public class AppEnv {

    private static final String Prod = "www.taxtechnical.ird.govt.nz/" ;
    private static final String Test = "taxtechnical.test.ird.govt.nz/" ;

    public static String getProdUrl(){
        return "https://" + Prod;
    }

    public static String getTestUrl() {
        return "https://" + Test;
    }

}
