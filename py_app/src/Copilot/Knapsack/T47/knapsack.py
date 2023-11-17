class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(values)
        dp = [[0 for _ in range(capacity+1)] for _ in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, capacity+1):
                if j >= weights[i-1]:
                    dp[i][j] = max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]])
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[n][capacity]
