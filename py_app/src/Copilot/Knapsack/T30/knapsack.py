class Knapsack:
    def __init__(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values
        self.memo = [[None for i in range(capacity + 1)] for j in range(len(values) + 1)]

    def bottom_up(self):
        for i in range(len(self.values) + 1):
            for j in range(self.capacity + 1):
                if i == 0 or j == 0:
                    self.memo[i][j] = 0
                elif self.weights[i - 1] <= j:
                    self.memo[i][j] = max(self.values[i - 1] + self.memo[i - 1][j - self.weights[i - 1]], self.memo[i - 1][j])
                else:
                    self.memo[i][j] = self.memo[i - 1][j]
        return self.memo[len(self.values)][self.capacity]
