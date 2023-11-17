class Knapsack:
    def bottom_up(self, capacity, weights, values):
        # initialize a 2D list with 0s
        dp = [[0 for i in range(capacity + 1)] for i in range(len(weights) + 1)]
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                # if the weight of the current item is greater than the capacity, we cannot include this item
                if weights[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                # otherwise, we can choose to include or exclude this item
                else:
                    dp[i][j] = max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]])
        return dp[len(weights)][capacity]
