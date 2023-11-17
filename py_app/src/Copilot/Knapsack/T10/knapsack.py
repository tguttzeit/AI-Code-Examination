class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        table = [[0 for x in range(capacity + 1)] for x in range(n + 1)]

        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    table[i][w] = 0
                elif weights[i - 1] <= w:
                    table[i][w] = max(values[i - 1] + table[i - 1][w - weights[i - 1]], table[i - 1][w])
                else:
                    table[i][w] = table[i - 1][w]
        return table[n][capacity]
