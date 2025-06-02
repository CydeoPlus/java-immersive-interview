package day01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class T01_StringReverse {
    //Using StringBuilder
    public static String reverseString(String str) {
        StringBuilder stb = new StringBuilder(str);
        return stb.reverse().toString();
    }

    public static String reverseStr(String str) {
        //String reversed = "";
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            //reversed += str.charAt(i);
            reversed.append(str.charAt(i));
        }
        return  reversed.toString();
    }

    //unit test
    @Test
    public void testReverseString() {
        assertEquals("avaj", reverseString("java"));
        assertEquals("cba", reverseString("abc"));
        assertEquals("y", reverseString("y"));
    }

    @Test
    public void testReverseStr() {
        assertEquals("avaj", reverseStr("java"));
        assertEquals("cba", reverseStr("abc"));
        assertEquals("y", reverseStr("y"));
    }
}
