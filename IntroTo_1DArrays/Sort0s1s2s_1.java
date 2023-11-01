package DSA_programs.IntroTo_1DArrays;
import java.util.*;
public class Sort0s1s2s_1 {
    public static void main(String[] args) {
                int arr[] = {0,1,2,1,1,2,0,1,0,2};
                int n = arr.length,cnt0=0,cnt1=0,cnt2=0;
                for(int i=0;i<n;i++){
                    switch (arr[i]) {
                        case 0:
                            cnt0++;
                            break;
                        case 1:
                            cnt1++;
                            break;
                        case 2:
                            cnt2++;
                            break;
                    }
                }
                int j=0;
                for(int i=0;i<cnt0;i++){
                    arr[j++] = 0;
                }
                for(int i=0;i<cnt1;i++){
                    arr[j++] = 1;
                }
                for(int i=0;i<cnt2;i++){
                    arr[j++] = 2;
                }
                System.out.println("The array after sorting 1s,2s and 0s:"+Arrays.toString(arr));
            }
}
