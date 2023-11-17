class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        m = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, capacity + 1):
                if weights[i - 1] <= j:
                    m[i][j] = max(m[i - 1][j], m[i - 1][j - weights[i - 1]] + values[i - 1])
                else:
                    m[i][j] = m[i - 1][j]
        return m[n][capacity]
