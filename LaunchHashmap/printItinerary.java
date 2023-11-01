package DSA_programs.LaunchHashmap;

import java.util.HashMap;
import java.util.Map;

public class printItinerary {
    public static String getStart(HashMap<String,String> tick){
        HashMap<String,String> revMap = new HashMap<>();
        //Add all the data of the ticket map in the revMap in the reverse order to find the Stating point
        // for(String key:tick.keySet()){
        //     revMap.put(tick.get(key),key);
        // }
        for(Map.Entry<String,String> set :tick.entrySet()){
            revMap.put(set.getValue(),set.getKey());
        }
        //Find the Start point
        for(String key:tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;

    }
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("Chennai","bangaluru");
        map.put("Mumbai","Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi","Goa");

        String start = getStart(map);
        //print the itinerary
        while(map.containsKey(start)){
            System.out.print(start+"->");
            start = map.get(start);
        }
        System.out.println("bangaluru");
    }
}
