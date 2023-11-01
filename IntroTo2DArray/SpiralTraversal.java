package DSA_programs.IntroTo2DArray;

public class SpiralTraversal {
    private static void spiralTraverse(int[][] arr){
        System.out.println("The element after spirally traversing:");
        int up = 0, down = arr.length-1, left = 0, right = arr[0].length-1;
        while(up<=down && left<= right){
            for(int i=left;i<=right;i++){
                System.out.print(arr[up][i]+" ");
            }
            up++;
            for(int i=up;i<=down;i++){
                System.out.print(arr[i][right]+" ");
            }
            right--;
            if(up<=down){
                for(int i=right;i>=left;i--){
                    System.out.print(arr[down][i]+" ");
                }
                down--;
            }
            if(left<=right){
                for(int i=down;i>=up;i--){
                    System.out.print(arr[i][left]+" ");
                }
                left++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] m={{1,2,4,5},{5,6,7,8},{1,2,3,4}};
        spiralTraverse(m);
    }
}
