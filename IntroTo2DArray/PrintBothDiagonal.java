package DSA_programs.IntroTo2DArray;

public class PrintBothDiagonal {
    private static void printDiagonals(int[][] arr){
        int m=arr.length;
        System.out.println("The element of both the diagonals are as follows:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i][i]+"\t");
            if(i != m-i-1){
              System.out.print(arr[i][m-i-1]+" ");
        }
        }
    }
    public static void main(String[] args) {
       int[][] m={{1,2,3},
                        {4,5,6},
                        {7,8,9}};
       printDiagonals(m);
    }
}
