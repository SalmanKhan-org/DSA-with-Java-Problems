package DSA_programs.DevideAndConquerAlgo;

public class searchInRotatedSortArray {
    //Time complexity=O(logN) because we are using binary Search and time complexity of binary Search is logN
    //space complexity=O(1)
    private static int binarySearch(int[] A, int l, int h, int key){
        if(l>h) return -1;
            int m=l+(h-l)/2;
            if(A[m]==key){
                return m;
            }else if(A[m]<key){
                return binarySearch(A,m+1,h,key);
            }else{
                return binarySearch(A, l, m-1, key);
            }
    }
    private static int findPivot(int[] A, int l , int h){
        //if your low pointer goes out of the get does not get pivot element
        if(l>h) return -1;
        int m= l+(h-l)/2;
        if(m>h&&A[m]>A[m+1])
            return m;
        if(m>l&&A[m]<A[m-1])
           return m-1;
        if(A[l]>=A[m])
           return findPivot(A, l, m-1);
        else
           return findPivot(A, m+1, h);      
    }
    private static int findElement(int[] A, int l, int h, int key){
        //1.find pivot  element from where you have to decide whether your element is in the right SubArray or leftSubArray
        int m =  findPivot(A,l,h);
        //if our array is completely sorted
        if(m==-1)
            return binarySearch(A,l,h,key);
        if(A[m]==key)
            return m;
        if(A[l]<=key)
            return binarySearch(A,l,m-1,key);
        else
           return binarySearch(A,m+1,h,key);            
    }
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10,1,2,3};
        int key=5;
        System.out.println("The "+key+" is found at the index:"+findElement(arr, 0,arr.length-1, key));
    }
}
