package day03;

import java.util.*;

public class ListObjects {
    public static void main(String[] args) {

        //        List<Character> list = new List<>(); List cannot be instantiated

        List<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add(null);
        list1.add('c');
        list1.add('c');
        list1.add('d');
        System.out.println(list1);

        List<String> strings = new ArrayList<>();
        strings.add("hello");

        System.out.println("------------------------------------");

        List<Character> list2 = new LinkedList<>();
        list2.add('a');
        list2.add('b');
        list2.add(null);
        list2.add('c');
        list2.add('c');
        list2.add('d');
        System.out.println(list2);

        System.out.println("------------------------------------");

        List<Character> list3 = new Vector<>();
        list3.add('a');
        list3.add('b');
        list3.add(null);
        list3.add('c');
        list3.add('c');
        list3.add('d');
        System.out.println(list3);
        list3.remove(Character.valueOf('c'));

        System.out.println("------------------------------------");

        Stack<String> stack = new Stack<>(); // LIFO
        //      Why not List Reference?
        //        ((List)stack).push(); The List reference does not have access to the push method
        stack.push("a");
        System.out.println(stack.add("b"));//returns true or false
        System.out.println(stack.push("c")); //returns same value c
        System.out.println(stack);

        System.out.println("At the top " + stack.peek()); // checks what's at the top of the stack
        stack.pop(); // removes the element at the top of the stack and returns it
        System.out.println("At the top now " + stack.peek());
        System.out.println(stack);

        System.out.println(stack.pop() + " was removed from the stack");
        System.out.println(stack);

        // I can use the methods from List , but for stack I want to use the function of LIFO
        System.out.println(stack.get(0));
        stack.add("h");
        System.out.println(stack);

        //Thread safe/Synchronized use of collections
        List<String> myList = Collections.synchronizedList(new ArrayList<>());
        myList.add("Hello");
        myList.add("SDET");
        System.out.println("myList = " + myList);

    }
}
