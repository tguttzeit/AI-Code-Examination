class Knapsack:
    def __init__(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values
        self.memo = [[-1] * (capacity + 1) for _ in range(len(weights))]

    def bottom_up(self):
        n = len(self.weights)

        # Initialize a memoization table
        for i in range(n + 1):
            for w in range(self.capacity + 1):
                if i == 0 or w == 0:
                    self.memo[i][w] = 0
                elif self.weights[i - 1] <= w:
                    self.memo[i][w] = max(self.values[i - 1] + self.memo[i - 1][w - self.weights[i - 1]],
                                          self.memo[i - 1][w])
                else:
                    self.memo[i][w] = self.memo[i - 1][w]

        return self.memo[n][self.capacity]
