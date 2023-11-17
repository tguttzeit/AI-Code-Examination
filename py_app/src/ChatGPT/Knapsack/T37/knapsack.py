class Knapsack:
    def __init__(self):
        self.cache = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        # Initialize a table to store the maximum values for different subproblems
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        # Build the table using bottom-up dynamic programming
        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    # If the current item can fit in the knapsack, choose the maximum value
                    # of either including it or excluding it
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    # If the current item is too heavy, exclude it
                    dp[i][w] = dp[i - 1][w]

        # The maximum value is stored in the bottom-right corner of the table
        max_value = dp[n][capacity]
        return max_value
