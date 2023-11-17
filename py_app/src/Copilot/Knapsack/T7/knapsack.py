class Knapsack:
    def __init__(self):
        self._capacity = 0
        self._weights = []
        self._values = []

    def bottom_up(self, capacity, weights, values):
        self._capacity = capacity
        self._weights = weights
        self._values = values

        # Create a matrix of size len(weights) * capacity
        matrix = [[0 for x in range(capacity + 1)] for x in range(len(weights) + 1)]

        # Fill the matrix with the maximum value of the knapsack
        for i in range(len(weights) + 1):
            for j in range(capacity + 1):
                if i == 0 or j == 0:
                    matrix[i][j] = 0
                elif weights[i - 1] <= j:
                    matrix[i][j] = max(values[i - 1] + matrix[i - 1][j - weights[i - 1]], matrix[i - 1][j])
                else:
                    matrix[i][j] = matrix[i - 1][j]

        return matrix[len(weights)][capacity]
