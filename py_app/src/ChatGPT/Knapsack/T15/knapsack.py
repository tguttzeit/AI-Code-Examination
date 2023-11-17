class Knapsack:
    def __init__(self):
        self.memoization_table = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Initialize a table to store the maximum values for each subproblem
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                # Check if the current item can be included
                if weights[i - 1] <= w:
                    # Calculate the maximum value by either including or excluding the current item
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    # If the current item's weight is greater than the current capacity, skip it
                    dp[i][w] = dp[i - 1][w]

        # The maximum value will be at the bottom-right corner of the table
        return dp[n][capacity]
