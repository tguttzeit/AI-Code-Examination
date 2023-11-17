class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        # Initialize the memo as a 2D array of rows = weights, cols = capacity + 1
        # The extra column is for the case when the capacity is 0.
        # The extra row is for the case when the weight is 0.
        # The value of each cell is the maximum value for the given weight and capacity.
        for i in range(len(weights) + 1):
            self.memo[i] = []
            for j in range(capacity + 1):
                self.memo[i].append(0)

        # Fill the memo using the bottom up approach.
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                # If the current weight is more than the current capacity, then
                # the value is the same as the previous weight.
                if weights[i - 1] > j:
                    self.memo[i][j] = self.memo[i - 1][j]
                # Otherwise, take the value of the previous weight and the
                # value of the current weight plus the value of the remaining
                # capacity.
                else:
                    self.memo[i][j] = max(self.memo[i - 1][j], values[i - 1] + self.memo[i - 1][j - weights[i - 1]])

        # Return the value of the last cell.
        return self.memo[len(weights)][capacity]

