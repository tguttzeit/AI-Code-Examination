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
        self.dp = [[0 for i in range(capacity + 1)] for j in range(len(weights) + 1)]
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                if j < weights[i - 1]:
                    self.dp[i][j] = self.dp[i - 1][j]
                else:
                    self.dp[i][j] = max(self.dp[i - 1][j], self.dp[i - 1][j - weights[i - 1]] + values[i - 1])
        return self.dp[len(weights)][capacity]
