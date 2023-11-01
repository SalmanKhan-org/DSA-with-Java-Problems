package DSA_programs.IntroTo_1DArrays;

public class minAndMaxElement {
    // Time complexity = O(n)
//space complexity = O(1)
    static int maxElement(int arr[], int n){
        int max = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    static int minElement(int arr[], int n){
        int min = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[] = {3,5,7,73,9,2};
        int n = arr.length;
        int min = minElement(arr,n); 
        int max  = maxElement(arr,n);
        System.out.println("The minimum element in the array:"+min);
        System.out.println("The maximum element in the array:"+max);
    }
}
