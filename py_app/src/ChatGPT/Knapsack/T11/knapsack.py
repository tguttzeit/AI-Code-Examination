class Knapsack:
    def __init__(self):
        self.memo = None

    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        self.memo = [[0] * (capacity + 1) for _ in range(n + 1)]

        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    self.memo[i][w] = 0
                elif weights[i - 1] <= w:
                    self.memo[i][w] = max(
                        values[i - 1] + self.memo[i - 1][w - weights[i - 1]],
                        self.memo[i - 1][w],
                    )
                else:
                    self.memo[i][w] = self.memo[i - 1][w]

        return self.memo[n][capacity]
