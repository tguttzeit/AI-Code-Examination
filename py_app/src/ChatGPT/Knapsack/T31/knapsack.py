class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Create a table to store the maximum value for each subproblem
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    # If the current item can be included, compare the value of including it
                    # with the value of excluding it and take the maximum
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    # If the current item's weight exceeds the remaining capacity, exclude it
                    dp[i][w] = dp[i - 1][w]

        return dp[n][capacity]
