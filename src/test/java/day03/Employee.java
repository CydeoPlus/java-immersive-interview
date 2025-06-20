package day03;

import java.util.*;

public class Employee implements Comparable<Employee> {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override  //3 - 1 -> 2
    public int compareTo(Employee other) {
        //return this.id - other.id;
        //return this.name.length() - other.name.length();
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class Main {

    static String word;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice"));
        employees.add(new Employee(1, "Bob"));
        employees.add(new Employee(2, "Charlie"));

        System.out.println(employees);
        Collections.sort(employees); // Sort by id (Comparable)
        System.out.println(employees);

        //Collections.sort(employees, (e1,e2) -> e1.name.length()-e2.name.length());
        System.gc();//suggesting JVM to call Garbage Collector, but no guarantee

        //LinkedList<Employee> ll = (LinkedList)employees;
        //System.out.println("ll = " + ll);
        //classCastException

        //System.out.println(word.length()); //NullPointerException

        Map<Employee, Double> map = new TreeMap<>();
        map.put(new Employee(3, "Alice"), 85000.0);
        map.put(new Employee(1, "Bob"), 102000.0);
        map.put(new Employee(2, "Charlie"), 77000.0);

        System.out.println("map = " + map);
    }

    //Comparator needs another class to be implemented
    class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.name.compareTo(e2.name);
        }
    }

    class IDComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.id - e2.id;
        }
    }

}
