class Knapsack:
    def bottom_up(self, capacity, weights, values):
        # YOUR CODE HERE
        # raise NotImplementedError()
        rows = len(weights)
        cols = capacity + 1
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if weights[i] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(values[i] + dp[i-1][j-weights[i]], dp[i-1][j])
        return dp[rows-1][cols-1]
