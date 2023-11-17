class Knapsack:
    def __init__(self):
        self.table = [[0 for x in range(100)] for x in range(100)]
        self.weights = []
        self.values = []

    def bottom_up(self, capacity, weights, values):
        self.weights = weights
        self.values = values
        # initialize table
        for i in range(0, len(weights) + 1):
            for j in range(0, capacity + 1):
                if i == 0 or j == 0:
                    self.table[i][j] = 0
                elif weights[i - 1] <= j:
                    self.table[i][j] = max(values[i - 1] + self.table[i - 1][j - weights[i - 1]], self.table[i - 1][j])
                else:
                    self.table[i][j] = self.table[i - 1][j]
        return self.table[len(weights)][capacity]
