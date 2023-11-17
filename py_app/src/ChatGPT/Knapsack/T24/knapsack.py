class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Initialize a table to store the maximum values
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    # If the current item can be included in the knapsack
                    # Calculate the maximum value either by including it or excluding it
                    dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
                else:
                    # If the current item cannot be included, just use the previous row's value
                    dp[i][w] = dp[i - 1][w]

        # The result is stored in the bottom-right cell of the table
        return dp[n][capacity]
