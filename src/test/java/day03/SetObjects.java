package day03;

import java.util.*;

public class SetObjects {
    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>(); // random order
        set1.add(null);
        set1.add("hello world");
        set1.add("5.0");
        set1.add("#zebra");
        set1.add("hello world");
        set1.add("Java");
        System.out.println(set1);
        //System.out.println(set1.get(0)); no indexing

        System.out.println("------------------------------------");

        Set<String> set2 = new LinkedHashSet<>(); // maintains insertion order
        set2.add(null);
        set2.add("hello world");
        set2.add("5.0");
        set2.add("#zebra");
        set2.add("hello world");
        set2.add("Java");
        System.out.println(set2);

        System.out.println("------------------------------------");

        Set<String> set3 = new TreeSet<>(); // maintains natural order (sorted) -> String types: lexicographically (ascii order)
        // Q: How does it handle when they are the same first character? It compares the 2nd and 3rd, and so on until it can determine which goes first
        // set3.add(null); // null is not allowed in TreeSet
        set3.add("hello world");
        set3.add("5.0");
        set3.add("#zebra");
        set3.add("hello world");
        set3.add("Java");
        System.out.println(set3);

//        set3.get(0); no indexes in Set type so no get method
        Set<Integer> set4 = new TreeSet<>();
        set4.add(44);
        set4.add(22);
        set4.add(100);
        set4.add(100);
        set4.add(3);
        System.out.println("set4 = " + set4);

        System.out.println("-------FOR EACH LOOP--------");
        for(int each : set4) {
            System.out.println("each = " + each);
        }

        System.out.println("--------FOREACH METHOD------------");
        set4.forEach(each -> System.out.println("each = " + each));

        System.out.println("-------ITERATOR-----------");
        Iterator<Integer> it = set4.iterator();
        while (it.hasNext()) {
            System.out.println("each = " + it.next());
        }
    }
}