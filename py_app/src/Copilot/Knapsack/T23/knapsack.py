class Knapsack:
    def __init__(self):
        self.cache = {}
        self.n = 0
        self.capacity = 0
        self.values = []
        self.weights = []

    def bottom_up(self, capacity, weights, values):
        self.n = len(weights)
        self.capacity = capacity
        self.values = values
        self.weights = weights

        for i in range(self.n + 1):
            for j in range(self.capacity + 1):
                if i == 0 or j == 0:
                    self.cache[(i, j)] = 0
                elif self.weights[i - 1] <= j:
                    self.cache[(i, j)] = max(self.values[i - 1] + self.cache[(i - 1, j - self.weights[i - 1])], self.cache[(i - 1, j)])
                else:
                    self.cache[(i, j)] = self.cache[(i - 1, j)]
        return self.cache[(self.n, self.capacity)]