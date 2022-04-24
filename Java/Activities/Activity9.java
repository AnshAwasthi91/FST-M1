package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Pineapple");
        myList.add("Banana");
        myList.add("Grapes");
        myList.add("Mango");
        myList.add("Papaya");

        System.out.println("Print All the List items:");
        for(String item:myList){
            System.out.println(item);
        }

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Orange is in list: " + myList.contains("Orange"));
        System.out.println("Size of ArrayList: " + myList.size());

        String removedFruit=myList.remove(3);
        System.out.println("Fruit item removed from list is : "+removedFruit);
        System.out.println("New Size of list: " + myList.size());

    }
}
