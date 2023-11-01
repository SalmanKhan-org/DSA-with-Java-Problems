package DSA_programs.LaunchBackTracking;

public class permutationsOfString {
    //time complexity =O(n*n!);
    //space complexity = O(n)
    public static void swap(int[] ar, int i, int fi){
        int temp = ar[i];
        ar[i] = ar[fi];
        ar[fi] = temp;
    }
    public static void findP(int[] ar, int fi){
        if(fi== ar.length){
            for(int i=0;i<ar.length;i++){
                System.out.print(ar[i]+",");
            }
            System.out.println();
            return;
        }else{
            for(int i=fi;i<ar.length;i++){
               swap(ar,i,fi);
                findP(ar, fi+1);
               swap(ar,i,fi);
            }
        }

    }
    public static void main(String[] args) {
        int  []arr = {1,2,3};
        findP(arr, 0);
    }
}
