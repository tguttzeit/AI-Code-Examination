class Knapsack:
    def __init__(self):
        self.memo = []

    def bottom_up(self, capacity, weights, values):
        n = len(weights)

        # Initialize a memoization table with zeros
        self.memo = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

        # Build the memoization table using bottom-up dynamic programming
        for i in range(1, n + 1):
            for w in range(1, capacity + 1):
                if weights[i - 1] <= w:
                    # If the current item can fit in the knapsack, choose the maximum value
                    # between adding the current item and not adding it
                    self.memo[i][w] = max(values[i - 1] + self.memo[i - 1][w - weights[i - 1]], self.memo[i - 1][w])
                else:
                    # If the current item is too heavy to fit in the knapsack, skip it
                    self.memo[i][w] = self.memo[i - 1][w]

        # The maximum value is stored in the bottom-right cell of the memoization table
        return self.memo[n][capacity]
