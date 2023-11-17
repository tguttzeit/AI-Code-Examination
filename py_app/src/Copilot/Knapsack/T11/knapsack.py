class Knapsack:
    def __init__(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values

    def bottom_up(self):
        # Create a 2D array of size len(weights) + 1 by capacity + 1
        # Initialize the first row and column with 0
        # Iterate through the 2D array
        # If the weight is less than or equal to the current capacity
        # Then we can either include or exclude the item
        # If we include the item, then we subtract the current item's weight from the current capacity
        # And add the current item's value to the value of the item in the 2D array
        # If we exclude the item, then we just copy the value of the item above
        # Else we just copy the value of the item above
        # Return the last item in the 2D array
        dp = [[0 for i in range(self.capacity + 1)] for j in range(len(self.weights) + 1)]

        for i in range(1, len(self.weights) + 1):
            for j in range(1, self.capacity + 1):
                if self.weights[i - 1] <= j:
                    dp[i][j] = max(dp[i - 1][j - self.weights[i - 1]] + self.values[i - 1], dp[i - 1][j])
                else:
                    dp[i][j] = dp[i - 1][j]

        return dp[len(self.weights)][self.capacity]
