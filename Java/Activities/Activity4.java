package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,10,12,1,5,6};
        System.out.println("Array before Sorting: "+ Arrays.toString(nums));
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            int key = nums[j];
            int i = j-1;
            while ( (i > -1) && ( nums [i] > key ) ) {
                nums [i+1] = nums [i];
                i--;
            }
            nums[i+1] = key;
        }
        System.out.println("Array after Sorting: "+ Arrays.toString(nums));
    }
}
