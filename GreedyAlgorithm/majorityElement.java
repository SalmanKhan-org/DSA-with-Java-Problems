package DSA_programs.GreedyAlgorithm;

public class majorityElement {
    public static int majorityEle(int[] a,int size){
        int majoEle=0;
        int count=1;
        for(int i=1;i<size;i++){
            if(a[i]==a[majoEle]){
                count++;
            }else{
                count--;
                if(count==0){
                    majoEle=i;
                    count=1;
                }
            }
        }
        //check wether arr[majoEle] is majority or not
        count=0;
        for(int i=0;i<size;i++){
            if(a[i]==a[majoEle]){
                count++;
            }
        }
        if(count>size/2) return a[majoEle];
        
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,13,1};
        System.out.println("The majority Element in the given array is:"+majorityEle(arr,arr.length));
    }
}
