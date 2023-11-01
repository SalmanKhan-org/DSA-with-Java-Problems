package DSA_programs.LaunchRecursion;

public class recursiveBinarySearch {
    public static int binarySearch(int[] arr,int low, int high,int target){
        int mid= -1;
        while(low <= high){
            mid = low +(high-low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                return binarySearch(arr, mid+1, high, target);
            }else{
                return binarySearch(arr, low, mid-1, target);
            }
        }
        return mid;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int target = 4;
        int result = binarySearch(arr,0,arr.length-1,target);
        if(result == -1){
            System.out.println("the  element "+target+" is not present in the Array:");
        }else{
            System.out.println("The element "+target+" is found at index :"+result);
        }
    }
}
