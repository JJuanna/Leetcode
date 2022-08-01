package DynamicProgramming;

public class easy {
    // 斐波那契
    public int fib(int n) {
        // 1.dp[i]表示第i个斐波那契数
        // 2.递推公式 dp[i] = dp[i-1] + dp[i-2]
        // 3.dp数组初始化，dp[0]=0, dp[1]=1
        // 4.遍历顺序i->2~n
        // 5.打印dp数组
        if (n == 0 || n == 1) return n;
//        int[] dp = new int[n+1];
//        dp[0]=0;
//        dp[1]=1;
//        for(int i=2; i<=n; i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        return dp[n];
        // 优化：返回只需要dp[n],因此没有必要存储一整个数组，只需要迭代存储当前值的前两个数字即可
        // O(n),O(1)
        int dp0 = 0, dp1 = 1, dp = dp0 + dp1;
        for (int i = 2; i <= n; i++) {
            dp = dp0 + dp1;
            dp0 = dp1;
            dp1 = dp;
        }
        return dp;
    }

    // 爬楼梯
    public int climbStairs(int n) {
        // 1.dp[i]表示到第i个台阶有多少种走法
        // 2.递推公式 dp[i] = dp[i-1] + dp[i-2]
        // 3.dp数组初始化，dp[0]=0, dp[1]=1
        // 4.遍历顺序i->2~n
        // 5.打印dp数组
        if (n == 1 || n == 2) return n;
        int dp1 = 1, dp2 = 2, dp = dp1 + dp2;
        for (int i = 3; i <= n; i++) {
            dp = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }


    // 使用最小花费爬楼梯:给定一个数组cost，cost[i]表示从楼梯第i个台阶爬上去所需要的费用，
    // 支付该费用，可以选择向上爬一个或两个台阶，可以选择从下标为0或1的台阶开始
    public int minCostClimbingStairs(int[] cost) {
        // 1.dp[i]表示爬到楼梯i为止支付的最低费用
        // 2.递推公式dp[i]=min(dp[i-1]+cost[i](从i-1走一步过来),dp[i-2]+cost[i](从i-2走两步过来))
        // 另一个递推公式dp[i]=min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]),dp0 = 0, dp1=0
        // 3.dp数组初始化，dp0=cost[0],dp1=cost[1]
        // 4.遍历顺序i->2~n
        // 5.距离推到dp数组
        int n = cost.length;
        int dp0 = cost[0], dp1 = cost[1], dp = 0;
        for (int i = 2; i <= n; i++) {
            dp = Math.min(dp1, dp0) + cost[i];
            dp0 = dp1;
            dp1 = dp;
        }
        return Math.min(dp0, dp1);
    }

    // 不同路径
    // 给定一个m行n列的矩阵，机器人每次只能向右或向下移动一格，求总共有多少条不同的路径
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        return dp[m - 1][n - 1];
    }

    // 不同路径II
    // 格子中有障碍物的情况
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 解决方案：还是基于上面的方案来，但是需要添加检查环节，检查右下角是否有障碍物，如果有，路径数为0
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    // 检查有障碍物和路不通的情况
                    if (obstacleGrid[i][j] == 1 || (i != 0 && dp[i - 1][j] == 0) || (j != 0 && dp[i][j - 1] == 0)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (obstacleGrid[i][j] == 1 || (dp[i - 1][j] == 0 && dp[i][j - 1] == 0)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        return dp[m - 1][n - 1];
    }

    // 整数拆分
    // 将整数拆分为k个正整数的和（k>=2）,并使这些整数的乘积最大化
    // 动态规划法
    // 数学法
    public int integerBreak(int n) {
        // dp[i]表示n的最大乘积
        // 递推公式：两种情况，一种是将i分为j和i-j，i-j不拆分，乘积=j*(i-j)
        // 另一种是i-j继续拆分，乘积=j*dp[i-j]，需要遍历所有的j的情况，dp[i] = max(1<=j<i){max{j*(i-j), j*dp[i-j]}}
        // dp数组初始化dp[0]=0, dp[1]=0, dp[2]=1
        // 时间复杂度O(n^2),空间复杂度O(n)
//        int[] dp = new int[n + 1];
//        dp[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            int tmp = 0;
//            for (int j = 1; j < i; j++) {
//                tmp = Math.max(j * (i - j), Math.max(tmp, j * dp[i - j]));
//            }
//            dp[i] = tmp;
//        }
//        return dp[n];
        // 整数拆分的数学方法，推导
        // 推导下来，绳子长度分为每段3，如果剩1，和前一段3一起拆成2*2，如果剩2，直接相乘
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }


    // 不同的二叉搜索树
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


}
