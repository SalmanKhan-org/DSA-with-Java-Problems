package DSA_programs.IntroTo_1DArrays;

public class subArrayWithSum {
    static void subArray(int arr[] ,int n, int sum){
                int left = 0,currentSum = 0;
                for(int i=0;i<n;i++){
                    currentSum +=arr[i];
                    if(currentSum == sum){
                        System.out.println("The subarray is found at "+left+" and "+i);
                    }
                    while(currentSum >sum){
                        currentSum -=arr[left];
                        left++;
                    }
                }    
            }
            public static void main(String[] args) {
                int arr[] = {1,2,5,8,3,4};
                int n = arr.length;
                int sum = 15;
                subArray(arr,n,sum);
               
            }
}
