package util;

import java.util.HashMap;

public class Utils {
    public static String[] structure(String sneaker) {
        sneaker = sneaker.replace("{", "").replace("}", "");
        String[] arrOfStr = sneaker.split("=");

//        for (String a : arrOfStr)
//            System.out.println(a);
        return arrOfStr;
    }
}
