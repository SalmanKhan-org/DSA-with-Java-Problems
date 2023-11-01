package DSA_programs.DevideAndConquerAlgo;

public class medianOfTwoSortedArrays {
    private static double median(int[] A1,int[] A2,int m,int n){
        //first make sure that binary search happen on small array
        if(m>n) return median(A2, A1, n, m);

        int low=0,high=m;
        int medianPas=((m+n)+1)/2;
        while(low<=high){
            int cut1=(low+high)/2;
            int cut2=medianPas-cut1;

            int l1=(cut1==0)?Integer.MIN_VALUE:A1[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:A2[cut2-1];
            int r1=(cut1==m)?Integer.MAX_VALUE:A1[cut1];
            int r2=(cut2==m)?Integer.MAX_VALUE:A2[cut2];

            if(l1<=r2&&l2<=r1){
                if((m+n)%2!=0){
                    return Math.max(l1,l2);
                }else{
                    return Math.max(l1, l2)+Math.min(r1, r2)/2;
                }
            }else if(l1>r2) high = cut1-1;
            else{
                low = cut1+1;
            }
        }
        return 0.0;

    }
    public static void main(String[] args) {
        int[] arr1={1,12,15,26,38};
        int[] arr2={2,13,17,30,45};
        System.out.println("The median of  two sorted Arrays:"+median(arr1,arr2,arr1.length,arr2.length));
    }
}
