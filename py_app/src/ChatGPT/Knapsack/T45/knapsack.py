class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Create a table to store the maximum values for different subproblems.
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        # Fill the dp table using a bottom-up approach.
        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                # If the current item's weight is greater than the current capacity,
                # we cannot include it in the knapsack.
                if weights[i - 1] > w:
                    dp[i][w] = dp[i - 1][w]
                else:
                    # Otherwise, we have two choices:
                    # 1. Include the current item in the knapsack.
                    # 2. Exclude the current item from the knapsack.
                    dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])

        # The final entry in the dp table contains the maximum value.
        return dp[n][capacity]
