package activities;

import java.util.HashSet;

public class Activity10 {

    public static void main(String[] args) {
        HashSet<String> mySet = new HashSet<>();
        mySet.add("Anna");
        mySet.add("Joe");
        mySet.add("Mike");
        mySet.add("Krish");
        mySet.add("Phantom");
        mySet.add("Lina");
        System.out.println("Initial set : "+mySet);
        System.out.println("Size of set is : "+mySet.size());
        System.out.println("Removing Krish from set : "+mySet.remove("Krish"));
        System.out.println("Removing Jacob from set : "+mySet.remove("Jacob"));
        System.out.println("Check if Mike exists in set or not ? : "+mySet.contains("Mike"));
        System.out.println("Updated set : "+mySet);
        System.out.println("Updated set size : "+mySet.size());


    }
}
