class Knapsack:
    def __init__(self):
        self.__memo = None

    def bottom_up(self, capacity, weights, values):
        self.__memo = [[None for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]
        for i in range(len(weights) + 1):
            self.__memo[i][0] = 0
        for i in range(capacity + 1):
            self.__memo[0][i] = 0
        for i in range(1, len(weights) + 1):
            for j in range(1, capacity + 1):
                if weights[i - 1] <= j:
                    self.__memo[i][j] = max(values[i - 1] + self.__memo[i - 1][j - weights[i - 1]], self.__memo[i - 1][j])
                else:
                    self.__memo[i][j] = self.__memo[i - 1][j]
        return self.__memo[len(weights)][capacity]
