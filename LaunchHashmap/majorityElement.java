package DSA_programs.LaunchHashmap;

import java.util.HashMap;

public class majorityElement {
    public static int majorityEle(int[] arr,int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        // for(int i=0;i<arr.length;i++){
        //     if(map.get(arr[i])>n/2){
        //         return arr[i];
        //     }
        // }
        for(int Key:map.keySet()){
            if(map.get(Key)>arr.length/2){
                return Key;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr= {2,2,1,1,1,2,2};
        int n=7;
        System.out.println(majorityEle(arr,n));
    }
}
