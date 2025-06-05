package day04;

import java.util.*;

public class StringFrequency {

    public static void main(String[] args) {
        System.out.println(encode1("aaabbcaaddb"));

        System.out.println(encode2("aaabbcaaddbbb"));
    }

    //"aaabbcaadd" -> a5b2c1d2
    //"aaabbcaaddbbb" -> a3b2c1a2d2b3

    //decode -> a3b2c1a2d2b3 -> aaabbcaaddbbb

    public static String encode1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        String result = "";
        for(char key : map.keySet()) {
            result += key+""+map.get(key);
        }
        return result;
    }
    //"aaabbcaaddbbb" -> a3b2c1a2d2b3
    public static String encode2(String str) {
        String result = "";
        char current = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (current == str.charAt(i)) {
                count++;
            } else {
                result += current +""+count;
                count = 1;
                current = str.charAt(i);
            }
        }
        return result + current +""+count;
    }



}
