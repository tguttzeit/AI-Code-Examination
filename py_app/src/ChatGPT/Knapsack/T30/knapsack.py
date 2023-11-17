class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        # Create a table to store the maximum value for each subproblem
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        # Fill the table using bottom-up dynamic programming
        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                # If the current item's weight is less than or equal to the current capacity
                if weights[i - 1] <= w:
                    # Decide whether to include the current item or not
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    # If the current item's weight is greater than the current capacity,
                    # we can't include it in the knapsack
                    dp[i][w] = dp[i - 1][w]

        # The last cell of the table contains the maximum value
        return dp[n][capacity]
