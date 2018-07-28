package de.reuters.bc.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {


    public static String machAmAnfangDesWortesGrosseBuchstaben(String userString) {


        if(userString == null || userString.trim().equals("")){
            return userString;
        }

        String[] splittedString = userString.split(" ");

        List<String> userStringList = new ArrayList<>();

        StringBuilder newUserString = new StringBuilder();

        for (String string : splittedString) {

            String ersteBuchstabe = string.substring(0, 1).toUpperCase();

            String stringOhneErsteBuchstabe = string.substring(1);

            String stringMitGrosserBuchstabe = ersteBuchstabe + stringOhneErsteBuchstabe;
            userStringList.add(stringMitGrosserBuchstabe);
        }


        for (String string : userStringList) {

            newUserString.append(string).append(" ");
        }


        return newUserString.toString().trim();


    }
}
