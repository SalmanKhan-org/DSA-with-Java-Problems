package DSA_programs.LaunchHashmap;

import java.util.HashMap;

public class duplicateNum {
    //Time complexity =O(n);
    //space Complexity = O(N)
    private static boolean duplicateNumber(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                //map.put(arr[i],map.get(arr[i])+1);
                return true;
            }else{
                map.put(arr[i],1);
            }
        }
        // for(int i=0;i<arr.length;i++){
        //     if(map.get(arr[i])>1){
        //         return true;
        //     }
        // }
        return false;
    } 
    public static void main(String[] args) {
        int[] arr ={3,2,4,2,5};
        boolean flag = duplicateNumber(arr);
        System.out.println(flag);
    }
}
