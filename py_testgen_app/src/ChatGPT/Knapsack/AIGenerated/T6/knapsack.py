class Knapsack:
    def __init__(self):
        self.memoization_table = None

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Initialize a memoization table with zeros
        self.memoization_table = [[0] * (capacity + 1) for _ in range(n + 1)]

        # Fill the memoization table using a bottom-up approach
        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    self.memoization_table[i][w] = max(
                        values[i - 1] + self.memoization_table[i - 1][w - weights[i - 1]],
                        self.memoization_table[i - 1][w]
                    )
                else:
                    self.memoization_table[i][w] = self.memoization_table[i - 1][w]

        # Return the maximum value for the given capacity
        return self.memoization_table[n][capacity]
