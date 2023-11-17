class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    dp[i][w] = dp[i - 1][w]

        return dp[n][capacity]
