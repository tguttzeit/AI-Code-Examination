class Knapsack:
    def bottom_up(self, capacity, weights, values):
        num_items = len(weights)
        dp = [[0 for _ in range(capacity + 1)] for _ in range(num_items + 1)]
        for i in range(1, num_items + 1):
            for j in range(1, capacity + 1):
                if weights[i - 1] <= j:
                    dp[i][j] = max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]])
                else:
                    dp[i][j] = dp[i - 1][j]
        return dp[num_items][capacity]
