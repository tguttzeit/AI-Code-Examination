class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        # Create a table to store the maximum values for each subproblem
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        # Fill the table using a bottom-up approach
        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif weights[i - 1] <= w:
                    dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
                else:
                    dp[i][w] = dp[i - 1][w]

        # The maximum value is stored in the bottom-right cell of the table
        return dp[n][capacity]
