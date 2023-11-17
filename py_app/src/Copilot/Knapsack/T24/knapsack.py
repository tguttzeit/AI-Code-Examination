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
        self.dp = [[0 for i in range(self.capacity + 1)] for j in range(len(self.weights) + 1)]

        for i in range(1, len(self.weights) + 1):
            for j in range(1, self.capacity + 1):
                if self.weights[i - 1] <= j:
                    self.dp[i][j] = max(self.dp[i - 1][j], self.values[i - 1] + self.dp[i - 1][j - self.weights[i - 1]])
                else:
                    self.dp[i][j] = self.dp[i - 1][j]
        return self.dp[len(self.weights)][self.capacity]
