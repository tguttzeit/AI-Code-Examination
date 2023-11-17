class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        # TODO complete this method.
        # You may add additional methods as you see fit.
        # You may modify the parameters of this method.
        # You must use memoization.
        # You must use bottom-up.
        # You must return the maximum value.
        # raise NotImplementedError
        self.memo = {}
        for i in range(len(weights)+1):
            self.memo[i] = {}
            for j in range(capacity+1):
                self.memo[i][j] = 0
        for i in range(1, len(weights)+1):
            for j in range(1, capacity+1):
                if weights[i-1] > j:
                    self.memo[i][j] = self.memo[i-1][j]
                else:
                    self.memo[i][j] = max(self.memo[i-1][j], values[i-1]+self.memo[i-1][j-weights[i-1]])
        return self.memo[len(weights)][capacity]
