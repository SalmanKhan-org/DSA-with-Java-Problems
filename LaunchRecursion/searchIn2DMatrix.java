package DSA_programs.LaunchRecursion;

public class searchIn2DMatrix {
    //Time complexity = O(logN)
    //Space complexity = O(N)
    public static int search(int low, int high,int target,int[][] arr){
        int midIdx = -1;
        while(low <= high){
            //Find mid Index
            midIdx = low+(high-low)/2;
            //Finding the middle element
            int midEle = arr[midIdx/arr[0].length][midIdx%arr[0].length];
            //Check if middle element is equal to target is not
            if(midEle == target){
                return midIdx;
            //if middle element is greater than target element then decrease the search space by changing the
            //value of high pointer as mid-1
            }else if(midEle > target){
                return search(low, midIdx-1, target, arr);
            }else{
            // if target element is greater than the middle element then decrease the search space by changing
            //the value of low pointer as mid+1;
                return search(midIdx+1, high, target, arr);
            }
        }
        return midIdx;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int m = arr.length;
        int n = arr[0].length;
        int target = 10;
        int result = search(0, m*n-1,target, arr);
        if(result==-1){
            System.out.println("The element is not present in the array:");
        }else{
            System.out.println("The "+target+" found at row index "+result/n+" and at Column index "+result%n);
        }
    }
}
