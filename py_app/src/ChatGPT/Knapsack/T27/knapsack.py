class Knapsack:
    def __init__(self):
        self.memo = None

    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        self.memo = [[0] * (capacity + 1) for _ in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    self.memo[i][w] = max(self.memo[i - 1][w], self.memo[i - 1][w - weights[i - 1]] + values[i - 1])
                else:
                    self.memo[i][w] = self.memo[i - 1][w]

        return self.memo[n][capacity]
