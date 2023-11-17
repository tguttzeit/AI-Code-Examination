class Knapsack:

    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        K = [[0 for x in range(capacity + 1)] for x in range(n + 1)]
        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    K[i][w] = 0
                elif weights[i - 1] <= w:
                    K[i][w] = max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w])
                else:
                    K[i][w] = K[i - 1][w]

        return K[n][capacity]
