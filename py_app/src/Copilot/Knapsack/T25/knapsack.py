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
        self.dp = [[0 for i in range(self.capacity + 1)] for j in range(len(self.weights) + 1)]
        for i in range(len(self.weights) + 1):
            for j in range(self.capacity + 1):
                if i == 0 or j == 0:
                    self.dp[i][j] = 0
                elif self.weights[i - 1] <= j:
                    self.dp[i][j] = max(self.values[i - 1] + self.dp[i - 1][j - self.weights[i - 1]], self.dp[i - 1][j])
                else:
                    self.dp[i][j] = self.dp[i - 1][j]
        return self.dp[len(self.weights)][self.capacity]