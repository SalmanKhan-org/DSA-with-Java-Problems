package DSA_programs.DevideAndConquerAlgo;

public class peakElement {
    //Time complexity =O(logN)
    //Auxilary Space= O(1)
    private static int binarySearch(int[] A,int l, int h){
        if(l>h) return -1;
        int mid= l+(h-l)/2;
        if(A[mid]>=A[mid-1]&&A[mid]>=A[mid+1])
            return mid;
        else if(A[mid]>=A[mid-1])
            return binarySearch(A, mid+1, h);
        else 
            return binarySearch(A, l, mid-1);    
    }
    private static int findPeakElement(int[] A,int n){
        int l=0,h=n-1;
        //if our starting element is greater than the next element then it's also a peak element
        //T(n) =O(1)
        if(A[l]>A[l+1]) return l;
        //if our last greater than from second last then it's also a peak element
        //T(n) = O(1)
        if(A[h]>A[h-1]) return h;

        //if both the conditions are false then then search the element using binary search
        //T(n)=T(n/2)
        return binarySearch(A,l,h);
    }
    public static void main(String[] args) {
        int[] A={1,2,3,8,4,5};
        System.out.println("The peak element is found at the index:"+findPeakElement(A, A.length));
    }
}
