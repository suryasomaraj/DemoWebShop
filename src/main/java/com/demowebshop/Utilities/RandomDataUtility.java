package com.demowebshop.Utilities;

import java.util.Random;

public class RandomDataUtility {
    public static String random(){
        Random rg=new Random();
        int randomInt=rg.nextInt(100);
        String email="suryasomaraj"+randomInt+"@gmail.com";
        return email;
    }
}
