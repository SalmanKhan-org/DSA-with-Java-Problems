package DSA_programs.DevideAndConquerAlgo;

public class MaxAndMinEle {
    //Time complexity = O(N);
    //Space complexity = O(logN) for stack calls 
    static class Pair{
        int min;
        int max;
    }
    public static Pair getMinMax(int[] arr, int i, int j){
        Pair minmax = new Pair();
        Pair minMaxLeft =  new Pair();
        Pair minMaxRight = new Pair();

        //1.Small problem
        //if there is only one element in the Array
        if(i==j){
            minmax.min = arr[i];
            minmax.max = arr[j];
        }
        //two element in the array is also a small problem because there answer is known
        if(i==j-1){
            if(arr[i]>arr[j]){
                minmax.max = arr[i];
                minmax.min = arr[j];
            }else{
                minmax.min = arr[i];
                minmax.max=arr[j];
            }
        }else{
            //2.Divide the bigger problem into subproblems
            int m = i+(j-i)/2;
            //3.conquering the smaller problems to solve the bigger  problem
            //minMaxLeft=min(left), max(right)
            //T(n) = T(n/2)
            minMaxLeft = getMinMax(arr, i, m);
            //minMaxRight = min(right), max(right)
            //T(n) = T(n/2)
            minMaxRight = getMinMax(arr, m+1, j);

            //3.Combine the smaller subproblems to get the desired result
            //compared the   max and min values of the left and right subArray 
            //T(n) = C      
            if(minMaxLeft.min<minMaxRight.min){
                minmax.min = minMaxLeft.min;
            }else{
                minmax.min = minMaxRight.min;
            }
            if(minMaxLeft.max > minMaxRight.max){
                minmax.max = minMaxLeft.max;
            }else{
                minmax.max = minMaxRight.max;
            }
        }
        return minmax;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,15,12,9,7,30,45};
        int n = arr.length;
        Pair minmax=getMinMax(arr,0,n-1); 
        System.out.println("The minimum element  in the Given  array is:"+minmax.min);
        System.out.println("The maximum element in the Array is:"+minmax.max);
    }
}
