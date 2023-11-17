class Knapsack:
    def bottom_up(self, capacity, weights, values):
        """Return the maximum value of a 0-1 knapsack problem with given capacity,
        weights and values.
        >>> Knapsack().bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50])
        90
        >>> Knapsack().bottom_up(50, [10, 20, 30], [60, 100, 120])
        220
        >>> Knapsack().bottom_up(50, [10, 20, 30, 40, 50], [60, 100, 120, 200, 250])
        250
        """
        # YOUR CODE HERE
        # raise NotImplementedError()
        length = len(weights)
        dp = [[0 for _ in range(capacity + 1)] for _ in range(length + 1)]
        for i in range(1, length + 1):
            for j in range(1, capacity + 1):
                if j >= weights[i - 1]:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1])
                else:
                    dp[i][j] = dp[i - 1][j]
        return dp[-1][-1]
