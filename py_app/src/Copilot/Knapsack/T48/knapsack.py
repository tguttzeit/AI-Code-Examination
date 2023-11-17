class Knapsack:
    def __init__(self):
        self.capacity = 0
        self.weights = []
        self.values = []
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        self.capacity = capacity
        self.weights = weights
        self.values = values
        self.memo = {}

        return self._bottom_up(0, 0)

    def _bottom_up(self, index, weight):
        if index >= len(self.weights):
            return 0

        if (index, weight) in self.memo:
            return self.memo[(index, weight)]

        if weight + self.weights[index] > self.capacity:
            return self._bottom_up(index + 1, weight)

        self.memo[(index, weight)] = max(
            self._bottom_up(index + 1, weight),
            self._bottom_up(index + 1, weight + self.weights[index]) + self.values[index]
        )

        return self.memo[(index, weight)]




