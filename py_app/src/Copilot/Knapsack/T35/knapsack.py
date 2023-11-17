class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        # YOUR CODE HERE
        self.memo = {}
        for i in range(0, len(weights) + 1):
            for j in range(0, capacity + 1):
                if i == 0 or j == 0:
                    self.memo[(i, j)] = 0
                elif weights[i - 1] <= j:
                    self.memo[(i, j)] = max(values[i - 1] + self.memo[(i - 1, j - weights[i - 1])], self.memo[(i - 1, j)])
                else:
                    self.memo[(i, j)] = self.memo[(i - 1, j)]
        return self.memo[(len(weights), capacity)]
