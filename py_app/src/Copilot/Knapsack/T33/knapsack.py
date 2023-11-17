class Knapsack:
    def __init__(self):
        self.weights = []
        self.values = []
        self.capacity = 0
        self.dp = []

    def bottom_up(self, capacity, weights, values):
        self.weights = weights
        self.values = values
        self.capacity = capacity
        self.dp = [[0 for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                if weights[i - 1] <= j:
                    self.dp[i][j] = max(values[i - 1] + self.dp[i - 1][j - weights[i - 1]], self.dp[i - 1][j])
                else:
                    self.dp[i][j] = self.dp[i - 1][j]
        return self.dp[-1][-1]