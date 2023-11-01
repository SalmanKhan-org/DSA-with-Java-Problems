package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int day;
    int cost;
    Pair(int  day,int cost){
        this.day=day;
        this.cost=cost;
    }
}
public class minCostToTravel {
    public static int minCost(int n,int[] days,int[] cost,int index){
		//base case
		//if your index is goes out of the fiven days
		if(index>=n){
			return 0;
		}
		//1-Day pass
		int pass1=cost[0]+minCost(n,days,cost,index+1);
		//7-Day pass
		//we call  travel upto consecutive 7 days with 7day pass
		int i;
		for( i=index;i<n&&days[i]<days[index]+7;i++){}

		int pass2=cost[1]+minCost(n,days,cost,i);
		//30 day pass
		//we call  travel upto consecutive 30 days with 30ay pass
		for( i=index;i<n&&days[i]<days[index]+30;i++){}
		int pass3=cost[2]+minCost(n,days,cost,i);

		return Math.min(pass1,Math.min(pass2,pass3));
	}
	public static int minCostMemo(int n,int[] days,int[] cost,int index,int[] travelDays,int[] dp){
		//base case
		if(index>365){
			return 0;
		}
		if(dp[index]!=-1){
			return  dp[index];
		}
		if(travelDays[index]==0){
			return minCostMemo(n,days,cost,index+1,travelDays,dp);
		}else{
			dp[index]=Math.min(minCostMemo(n,days,cost,index+1,travelDays,dp)+cost[0],
			Math.min(minCostMemo(n,days,cost,index+7,travelDays,dp)+cost[1],
			minCostMemo(n,days,cost,index+30,travelDays,dp)+cost[2]));
		}
		return dp[index];
	}

	//using tabulation method
	public static int minCostTab(int n,int[] days,int[] cost){
		int[] dp=new int[n+1];
		
		//Analyze the  base case
		dp[n]=0;

		//for rest of the recursive  calls
		for(int j=n-1;j>=0;j--){
			int pass1=cost[0]+dp[j+1];
		    //7-Day pass
		    //we call  travel upto consecutive 7 days with 7day pass
		    int i;
		    for( i=j;i<n&&days[i]<days[j]+7;i++){}

		    int pass2=cost[1]+dp[i];
		    //30 day pass
		    //we call  travel upto consecutive 30 days with 30ay pass
		    for( i=j;i<n&&days[i]<days[j]+30;i++){}
		    int pass3=cost[2]+dp[i];

		    dp[j]=Math.min(pass1,Math.min(pass2,pass3));
		}
		return dp[0];
	}
	public static int minimumCoins(int n, int[] days, int[] cost) {
	
			//return minCost(n,days,cost,0);
			int[] dp=new int[366];
			Arrays.fill(dp,-1);	
			int[] travelDays=new int[366];	
			for(int day:days){
				travelDays[day]=1;
			}
			//return minCostMemo(n,days,cost,0,travelDays,dp);

			return minCostTab(n,days,cost);
	}
    public static int solveSpaceOptimize(int[] days,int[] cost){
        //create a month queue which will hold only the 30 days with  their curresponding cost
        Queue<Pair> month=new LinkedList<>();
        //create a week queue which hold only the 7 days with their cost 
        Queue<Pair> week =new LinkedList<>();
        //process the days Array
        int ans=0;
        for(int day:days){
            //delete the old day from  the month queue
            while(!month.isEmpty()&&month.peek().day+30<=day){
                month.poll();
            }
            //delete the old day from the  week queue
            while(!week.isEmpty()&&week.peek().day+7<=day){
                week.poll();
            }
            //add the  current day with current minimum cost + 7
            week.add(new Pair(day, ans+cost[1]));
            //add the  current day with current minimum cost + 15 for  30 day pass
            month.add(new Pair(day, ans+cost[2]));
            //update  the  ans by taking  min of the one day pass and 7 day and 30day pass
            ans=Math.min(ans+cost[0],Math.min(week.peek().cost,month.peek().cost));
        }
        return  ans;
    }
    public  int mincostTickets1(int[] days, int[] costs) {
        return solveSpaceOptimize(days, costs);
    }
    public static void main(String[] args) {
        int[] days={2,5};
        int[]   cost={2,7,15};
        int n=days.length;
        System.out.println(minimumCoins(n, days, cost));
        System.out.println(new  minCostToTravel().mincostTickets1(days, cost));
    }
}
