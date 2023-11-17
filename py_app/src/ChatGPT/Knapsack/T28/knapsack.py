class Knapsack:
    def __init__(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values
        self.n = len(weights)
        self.dp = [[0 for _ in range(capacity + 1)] for _ in range(self.n + 1)]

    def bottom_up(self):
        for i in range(1, self.n + 1):
            for w in range(1, self.capacity + 1):
                if self.weights[i - 1] <= w:
                    self.dp[i][w] = max(self.values[i - 1] + self.dp[i - 1][w - self.weights[i - 1]], self.dp[i - 1][w])
                else:
                    self.dp[i][w] = self.dp[i - 1][w]
        return self.dp[self.n][self.capacity]
