package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        ArrayList<Integer> nums=new ArrayList<>();
        Random random_index=new Random();
        //Enter the numbers and to End the input Enter "E/End"
        System.out.println("Enter the numbers and to End the input Enter 'E/End' ");
        while (scan.hasNextInt()){
            nums.add(scan.nextInt());
        }
        System.out.println("List is : "+nums);

        int index=random_index.nextInt(nums.size());
        System.out.println("Randomly generated index is : "+index);
        System.out.println("Data value at given index is : "+nums.get(index));
    }



}
