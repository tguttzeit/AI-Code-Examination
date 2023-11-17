class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        self.memo = {}
        for i in range(len(weights)):
            self.memo[(i, 0)] = 0
        for i in range(capacity):
            self.memo[(0, i)] = 0

        for i in range(1, len(weights)):
            for j in range(1, capacity):
                if weights[i] <= j:
                    self.memo[(i, j)] = max(values[i] + self.memo[(i - 1, j - weights[i])], self.memo[(i - 1, j)])
                else:
                    self.memo[(i, j)] = self.memo[(i - 1, j)]

        return self.memo[(len(weights) - 1, capacity - 1)]
