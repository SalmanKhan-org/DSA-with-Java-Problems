package DSA_programs.IntroTo_1DArrays;

import java.util.Arrays;

public class sort0s1s2s_2DNF {
    public static void main(String[] args) {
                int arr[] = {0,1,1,0,2,1,0,2,1};
                int low=0,mid=0,hi=arr.length-1,temp=0;
                while(mid<=hi){
                    switch(arr[mid]){
                        case 0:
                             temp = arr[mid];
                             arr[mid] = arr[low];
                             arr[low] = temp;
                             mid++;low++;
                             break;
                        case 1:
                             mid++;
                             break;
                        case 2:
                            temp = arr[mid];
                            arr[mid] = arr[hi];
                            arr[hi] = temp;
                            hi--;
                            break;
                    }
                }
                System.out.println("The array after sorting 0s,1s and 2s:"+Arrays.toString(arr)+" ");
            }
}
