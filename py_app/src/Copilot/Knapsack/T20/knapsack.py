class Knapsack:
    def __init__(self):
        self.cache = {}

    def bottom_up(self, capacity, weights, values):
        if capacity <= 0:
            return 0
        if len(weights) == 0 or len(values) == 0:
            return 0
        if len(weights) != len(values):
            return 0

        self.cache = {}

        for i in range(len(weights)):
            self.cache[(i, 0)] = 0
            self.cache[(0, i)] = 0

        for i in range(1, len(weights)):
            for j in range(1, capacity):
                if weights[i] <= j:
                    self.cache[(i, j)] = max(values[i] + self.cache[(i - 1, j - weights[i])], self.cache[(i - 1, j)])
                else:
                    self.cache[(i, j)] = self.cache[(i - 1, j)]

        return self.cache[(len(weights) - 1, capacity - 1)]
