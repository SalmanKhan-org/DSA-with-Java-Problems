package DSA_programs.IntroTo_1DArrays;

public class peakElement {
    //Approach-1

//Time complexity = O(n)
//Space complexity = O(1)
    static int peakElement(int arr[],int n){
        if(n==1)
        return 0;
        if(arr[0]>=arr[1])
        return 0;
        if(arr[n-1]>=arr[n-2])
        return n-1;

        for(int i=1;i<n-1;i++){
            if(arr[i]>=arr[i-1]&&arr[i]>=arr[i+1]){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int arr[] = {4,3,2,5,4};
        int n = arr.length;
        int index = peakElement(arr,n);
        System.out.println("The peak element is "+arr[index]+" and index is:"+index);
    }
}
