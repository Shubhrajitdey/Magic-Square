import java.util.*;
public class CheckMagicSquare {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }
        String result = checkMagicSquare(n, grid);
        System.out.println(result);
    }
    static int checkMagicSum(int n){
        int sum=0;
        for(int i=1;i<=n*n;i++){
            sum = sum + i; 
        }
        //System.out.println("sum "+(sum/n));
        return sum/n;
    }
    static boolean checkMagicRowCol(int n,int[][] grid,int magicSum){
        int csum =0;
        int rsum =0;
        boolean res = false;
        for(int i=0;i<n;i++){
            csum =0;
            rsum =0;
            for(int j=0;j<n;j++){
                csum = csum + grid[i][j];
                rsum = rsum + grid[j][i];
            }
            if(csum == magicSum && rsum == magicSum){
                res=true;
            }else{
                res = false;
                break;
            }
        }
        //System.out.println("row "+res);
        return res;
    }
    static boolean checkMagicDia(int n,int[][] grid,int magicSum){
        int psum =0;
        int ssum =0;
        boolean res = false;
        for(int i=0;i<n;i++){
            psum = psum + grid[i][i];
            ssum = ssum + grid[i][n-1-i];
        }
        if(psum==magicSum && ssum == magicSum){
            res=true;
        }
        //System.out.println("diago "+res);
        return res;
    }
    // TODO: Implement this method
    static String checkMagicSquare(int n, int[][] grid) {
        String finalResult ="No";
        int magicSum = checkMagicSum(n);
        boolean checkResultDia =  checkMagicDia(n,grid,magicSum);
        if(checkResultDia == true){
            boolean checkResultRowCol =  checkMagicRowCol(n,grid,magicSum);
            if(checkResultRowCol == true ){
                finalResult = "Yes";
            }
        }
        //System.out.println("final "+finalResult);
        return finalResult;
    }
} 