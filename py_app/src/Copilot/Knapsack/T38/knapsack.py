class Knapsack:
    # The constructor takes a list of weights and a list of values.
    def __init__(self, weights, values):
        self.weights = weights
        self.values = values

    # Implement the bottom_up() method.
    def bottom_up(self, capacity, weights, values):
        # Create a 2D array of size len(weights) + 1 x capacity + 1
        # and initialize all values to 0.
        # This array will be used to store the results of subproblems.
        # The first dimension represents the number of items.
        # The second dimension represents the capacity.
        # The value at each index represents the maximum value that can be obtained
        # using the first i items and j capacity.
        table = [[0 for x in range(capacity + 1)] for x in range(len(weights) + 1)]

        # Iterate through the table.
        for i in range(len(weights) + 1):
            for j in range(capacity + 1):
                # If the first item or the first capacity is 0,
                # set the value at this index to 0.
                if i == 0 or j == 0:
                    table[i][j] = 0
                # If the weight of the current item is less than or equal to the current capacity,
                # set the value at this index to the maximum of the previous item's value
                # or the value of the current item plus the value of the item in the table
                # at the current index minus the weight of the current item.
                elif weights[i - 1] <= j:
                    table[i][j] = max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j])
                # Otherwise, set the value at this index to the value of the previous item.
                else:
                    table[i][j] = table[i - 1][j]

        # Return the value of the last item in the last row of the table.
        return table[len(weights)][capacity]

