package DSA_programs.LaunchRecursion;

public class maxVlaueInArray {
    //public static int maxEle = 0;
    public static void maxValue(int i, int[] arr,int maxEle){
        if(i == arr.length-1){
            System.out.println(maxEle);
            return;
        }
        //int maxEle = arr[i];
        if(maxEle < arr[i+1]){
            maxEle = arr[i+1];
        }
        maxValue(i+1, arr,maxEle);
    }
    public static void main(String[] args) {
        int[] arr = {13,1,-5,22,5};
        maxValue(0, arr,arr[0]);
    }
}
