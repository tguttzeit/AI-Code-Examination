class Knapsack:
    def __init__(self):
        self.capacity = 0
        self.weights = []
        self.values = []
        self.dp = []

    def bottom_up(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values
        self.dp = [[0 for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]
        for i in range(1, len(self.weights) + 1):
            for j in range(1, self.capacity + 1):
                if j - self.weights[i - 1] >= 0:
                    self.dp[i][j] = max(self.dp[i - 1][j], self.dp[i - 1][j - self.weights[i - 1]] + self.values[i - 1])
                else:
                    self.dp[i][j] = self.dp[i - 1][j]
        return self.dp[len(weights)][capacity]
