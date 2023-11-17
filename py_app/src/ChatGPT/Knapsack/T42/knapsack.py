class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Initialize a table to store the maximum values for each subproblem
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif weights[i - 1] <= w:
                    # Choose the maximum between including the current item or excluding it
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    dp[i][w] = dp[i - 1][w]

        # The maximum value is stored in dp[n][capacity]
        return dp[n][capacity]
