class Knapsack:
    def __init__(self):
        self.memoization_table = None

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Initialize a memoization table
        self.memoization_table = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        # Build the memoization table bottom-up
        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    self.memoization_table[i][w] = 0
                elif weights[i - 1] <= w:
                    self.memoization_table[i][w] = max(
                        values[i - 1] + self.memoization_table[i - 1][w - weights[i - 1]],
                        self.memoization_table[i - 1][w],
                    )
                else:
                    self.memoization_table[i][w] = self.memoization_table[i - 1][w]

        # The maximum value will be at the bottom-right corner of the memoization table
        return self.memoization_table[n][capacity]
