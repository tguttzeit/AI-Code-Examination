class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Create a table to store the maximum value for each subproblem
        dp = [[0] * (capacity + 1) for _ in range(n + 1)]

        # Build the table using bottom-up dynamic programming
        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    # If the current item's weight can be included, compare the value of including it
                    # with the value of not including it
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    # If the current item's weight is greater than the current capacity, skip it
                    dp[i][w] = dp[i - 1][w]

        # The maximum value is stored in the bottom-right cell of the table
        return dp[n][capacity]
