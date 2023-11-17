class Knapsack:
    def bottom_up(self, capacity, weights, values):
        """
        :type capacity: int
        :type weights: List[int]
        :type values: List[int]
        :rtype: int
        """
        # Your code here
        dp = [[0 for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                if j < weights[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j])
        return dp[len(weights)][capacity]
