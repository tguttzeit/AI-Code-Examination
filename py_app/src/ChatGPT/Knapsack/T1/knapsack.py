class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        dp = [[0] * (capacity + 1) for _ in range(n + 1)]

        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif weights[i - 1] <= w:
                    dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
                else:
                    dp[i][w] = dp[i - 1][w]

        return dp[n][capacity]
