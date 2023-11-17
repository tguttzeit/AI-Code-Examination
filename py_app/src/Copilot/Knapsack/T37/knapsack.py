class Knapsack:
    # constructor
    def __init__(self):
        self.cache = []

    # public method
    def bottom_up(self, capacity, weights, values):
        self.cache = [[0 for x in range(capacity + 1)] for x in range(len(values) + 1)]

        for i in range(len(values) + 1):
            for j in range(capacity + 1):
                if i == 0 or j == 0:
                    self.cache[i][j] = 0
                elif weights[i - 1] <= j:
                    self.cache[i][j] = max(values[i - 1] + self.cache[i - 1][j - weights[i - 1]], self.cache[i - 1][j])
                else:
                    self.cache[i][j] = self.cache[i - 1][j]

        return self.cache[len(values)][capacity]
