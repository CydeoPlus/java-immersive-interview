package day04;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");

        // Traditional approach
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 3) {
                filteredNames.add(name.toUpperCase());
            }
        }
        System.out.println("filteredNames = " + filteredNames);

// Using streams
        List<String> streamedNames = names.stream() //1) Source of stream
                .filter(name -> name.length() > 3)    // 2) Intermediate operation
                .map(String::toUpperCase)             // 2) Intermediate operation
                .toList();        // 3) Return value/Terminal operation

        System.out.println("streamedNames = " + streamedNames);

        //Stream names -> convert/map to uppercase -> print out
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        names.stream().map(each -> each.toUpperCase()).forEach(each -> System.out.println(each));

        // Lambda with multiple operations
        names.stream()
                .map(name -> {
                    String upper = name.toUpperCase();
                    return upper + " - " + upper.length();
                })
                .forEach(System.out::println);

        // Lambda capturing variable
        String prefix = "Name: ";
        names.stream()
                .map(name -> prefix + name.toUpperCase())
                .forEach(System.out::println);

        System.out.println("-----------FILTER----------");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //1) filter even numbers and print out
        nums.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));

        //2) filter odd numbers and store into new list
        List<Integer> odds = nums.stream().filter(n -> n % 2 != 0).toList();
        System.out.println("odds = " + odds);

        System.out.println("-----------MAP------------");
        //double each number then store into new list
        List<Integer> doubled = nums.stream().map(n -> n * 2).toList();
        System.out.println("doubled = " + doubled);

        List<String> states = List.of("VA", "MD", "CA", "NY", "FL", "IL");

        for(String st: states) {
            if (st.endsWith("A")) {
                System.out.println(st);
            }
        }

        //Goto each state -> filter states ending with "A" -> convert to lowercase -> return as new list
        List<String> newL = states.stream().filter(st -> st.endsWith("A")) //VA, CA
                .map(String::toLowerCase)  //va, ca
                .toList();
        System.out.println("newL = " + newL);

        System.out.println("-----------DISTINCT---------");
        List<Integer> numbers = new ArrayList<>(List.of(10,10,20,30,20,30,1,1,0,2));

        List<Integer> unique = numbers.stream().distinct().toList();
        
        System.out.println("numbers = " + numbers);
        System.out.println("unique = " + unique);

        System.out.println("-----------SORTED---------");
        List<Integer> uniqueAndSorted = numbers.stream().distinct().sorted().toList();
        System.out.println("uniqueAndSorted = " + uniqueAndSorted)  ;

        System.out.println("------------TOMAP-----------");
        List<String> namesList = Arrays.asList("John", "Alice", "Bob", "Charlie", "Joe", "Kai");
        
        //Filter names with max 3 chars -> return as map (Name, count)
        Map<String, Integer> namesMap = namesList.stream().filter(name -> name.length() <= 3)
                .collect(Collectors.toMap(name -> name.toUpperCase(), name -> name.length()));

        System.out.println("namesMap = " + namesMap);

        Map<String, Integer> namesMap2 = new HashMap<>();
        for(String name : namesList) {
            if (name.length() <= 3) {
                namesMap2.put(name.toUpperCase(), name.length());
            }
        }
        System.out.println("namesMap2 = " + namesMap2);

        System.out.println("---------MATCH OPERATIONS----------");
        //check if names are at least 3 chars
        boolean allTrue = true;
        for(String name : namesList) {
            if (name.length() < 3) {
                allTrue = false;
                break;
            }
        }
        System.out.println("allTrue = " + allTrue);

        boolean allMatch = namesList.stream().allMatch(name -> name.length() >= 3);

        System.out.println("allMatch = " + allMatch);

        System.out.println("--------ANYMATCH--------");
        List<Integer> someNums = Arrays.asList(200,400,1,20,33,74,98,-2, 8);
        //check if there is at least 1 negative number
        System.out.println(someNums.stream().anyMatch(num -> num < 0));
    }
}
