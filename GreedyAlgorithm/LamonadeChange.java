package DSA_programs.GreedyAlgorithm;

public class LamonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five_count=0,ten_Count=0,twenty_Count=0;
        for(int i=0;i<bills.length;i++){
            //if the current element is five  then increase  the   count of five
            if(bills[i]==5){
                five_count++;
            }else if(bills[i]==10){//if current element is 10 then first have you any 5 doller  for return if not return false;
                if(five_count==0) return false;
                five_count--;
                ten_Count++;
            }else if(bills[i]==20){
                if(ten_Count>0&&five_count>0) {
                five_count--;
                ten_Count--;
                twenty_Count++;
                }else if(five_count>=3){
                   five_count-=3;
                }else return false;
            }
        }  
        return true;
    }
    public static void main(String[] args) {
        int[] arr= {5,5,10,10,20};
        System.out.println(lemonadeChange(arr));
    }
}
