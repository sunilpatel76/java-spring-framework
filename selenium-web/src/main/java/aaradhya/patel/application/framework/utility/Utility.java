package aaradhya.patel.application.framework.utility;


import java.util.*;

public abstract class Utility {
    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getRandomString(int sLength){
        StringBuilder rndString = new StringBuilder();
        for (int i =0; i< sLength; i++){
            int rndNum = getRandomNumber();
            char ch = CHARACTERS.charAt(rndNum);
            rndString.append(ch);
        }
        return rndString.toString().toLowerCase();
    }

    private static int getRandomNumber(){
        Random random = new Random();
        int randomInt = random.nextInt(CHARACTERS.length());
        return ((randomInt -1) == -1) ? randomInt : randomInt-1;
    }

    public static String generateEmailAddress(){//2019102795700@dummy.com->cabj
        return getRandomString(5)+ "." + getRandomString(5) + "@dummy.com";
    }

}
