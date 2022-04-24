package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(1, "Navy Blue");
        hash_map.put(2, "Turquoise");
        hash_map.put(3, "Green");
        hash_map.put(4, "Jet Black");
        hash_map.put(5, "Magenta");

        System.out.println("The Original map: " + hash_map);

        hash_map.remove(2);
        System.out.println("After removing White: " + hash_map);

        if(hash_map.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }

        System.out.println("Number of pairs in the Map is: " + hash_map.size());
    }
}
