package DSA_programs.IntroToDP_dynamicProgramming;

public class HouseRobberyAlarmSystem {
    //Approach-1 by  using the Tabulation method
    public static int maxMoney(int[] arr,int n){
        int prev1=0;
        int prev2=arr[0];
        for(int i=1;i<n;i++){
           int incl=prev1+arr[i];
           int excl=prev2;
           
           int ans=Math.max(incl,excl);
           prev1=prev2;
           prev2=ans;
        }
        return prev2;
    }
    public  static  int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return  nums[0];
        }
        int[] nums1=new  int[n];
        int[] nums2=new  int[n];
        //for loop to avoid the first and last houses bcoz they are adjacent
        for(int i=0;i<n;i++){
            if(i!=n-1){
                nums1[i]=nums[i];
            }
            if(i!=0){
                nums2[i]=nums[i];
            }
        }
        //call  for Array without last house
        int money1=maxMoney(nums1,nums1.length);
        //call for Array without first house
        int money2=maxMoney(nums2,nums2.length);

        return Math.max(money1,money2);
    }
    public static void main(String[] args) {
        int[] money={2,3,2};
        System.out.println(rob(money));
    }
}
