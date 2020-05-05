//https://atcoder.jp/contests/dp/tasks/dp_d
import java.util.Scanner;
class Main
{
    static long knapsack(int weight[],int val[],int w,int n)
    {
        int i,j;
        long [][] dp=new long[n+1][w+1];
        for(i=0;i<=n;i++)
            for(j=0;j<=w;j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(weight[i-1]<=j)
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        return dp[n][w];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n,w,i;
        n=sc.nextInt();
        w=sc.nextInt();
        int weight[]=new int[n];
        int val[]=new int[n];
        for(i=0;i<n;i++)
        {
            weight[i]=sc.nextInt();
            val[i]=sc.nextInt();
        }
        //Comments
        long ans=knapsack(weight,val,w,n);
        System.out.println(ans);
        sc.close();
    }
}
