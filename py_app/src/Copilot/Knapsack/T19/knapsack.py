class Knapsack:
    def __init__(self):
        self.capacity = 0
        self.weights = []
        self.values = []
        self.table = []

    def bottom_up(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values
        self.table = [[0 for i in range(self.capacity + 1)] for j in range(len(self.weights) + 1)]

        for i in range(1, len(self.weights) + 1):
            for j in range(1, self.capacity + 1):
                if self.weights[i - 1] > j:
                    self.table[i][j] = self.table[i - 1][j]
                else:
                    self.table[i][j] = max(self.table[i - 1][j], self.table[i - 1][j - self.weights[i - 1]] + self.values[i - 1])

        return self.table[len(self.weights)][self.capacity]
