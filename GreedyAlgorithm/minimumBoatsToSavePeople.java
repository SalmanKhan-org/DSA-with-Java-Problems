package DSA_programs.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class minimumBoatsToSavePeople {
    public static int minimumBoats(ArrayList<Integer> arr, int l) {
        Collections.sort(arr);
		int light =0,heavy=arr.size()-1;
		int boatCount=0;
		while(light<=heavy){
			if(arr.get(light)+arr.get(heavy)<=l){
				light++;
				heavy--;
			}else{
				heavy--;
			}
			boatCount++;
		}
		return boatCount;
	}
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(7);
        arr.add(8);
        arr.add(5);
          System.out.println("The minimum required to save the given number of peoples:"+minimumBoats(arr, 8));
    }
}
