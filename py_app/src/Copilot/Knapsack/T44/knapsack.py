class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        self.memo = {}
        for i in range(len(weights) + 1):
            self.memo[(i, 0)] = 0
        for i in range(capacity + 1):
            self.memo[(0, i)] = 0
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                if weights[i - 1] <= j:
                    self.memo[(i, j)] = max(values[i - 1] + self.memo[(i - 1, j - weights[i - 1])], self.memo[(i - 1, j)])
                else:
                    self.memo[(i, j)] = self.memo[(i - 1, j)]
        return self.memo[(len(weights), capacity)]
