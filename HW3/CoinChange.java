//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class CoinChange {
	public static int helper(int[] denomination, int target, int n, int[][] dp) {
		if (target == 0)
			return 0;
		if (n == -1)
			return Integer.MAX_VALUE;

		if (dp[n][target] != -1)
			return dp[n][target];

		int take = Integer.MAX_VALUE;
		if (denomination[n] <= target) {
			take = 1 + helper(denomination, target - denomination[n], n, dp);
		}
		int dont = helper(denomination, target, n - 1, dp);

		return dp[n][target] = Math.min(take, dont);
	}

	public static int NumberofCoins(int[] denomination, int value) {
		// Write your code here to find out minimum number of coins required to provide
		// the change for given value.
		// This method will have a denomination array and an int which specifies the
		// value as inputs(Please see testcase file)
		// This method should return the number of coins
		int n = denomination.length;
		int[][] dp = new int[n][value + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < value + 1; j++)
				dp[i][j] = -1;
		}

		return CoinChange.helper(denomination, value, n - 1, dp);
	}
}
