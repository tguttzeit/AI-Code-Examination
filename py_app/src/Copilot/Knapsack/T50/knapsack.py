class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        dp = [[0 for i in range(capacity + 1)] for j in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, capacity + 1):
                if weights[i - 1] <= j:
                    dp[i][j] = max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j])
                else:
                    dp[i][j] = dp[i - 1][j]
        return dp[n][capacity]


