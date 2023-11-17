class Knapsack:
    def __init__(self):
        self.memo = {}

    def bottom_up(self, capacity, weights, values):
        """Return the maximum value of items that doesn't exceed capacity.

        >>> k = Knapsack()
        >>> k.bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50])
        90
        >>> k.bottom_up(50, [10, 20, 30], [60, 100, 120])
        220
        >>> k.bottom_up(50, [10, 20, 30, 40, 50], [60, 100, 120, 140, 160])
        220
        >>> k.bottom_up(50, [10, 20, 30, 40, 50], [600, 100, 120, 140, 160])
        600
        """
        # YOUR CODE HERE
        if capacity == 0:
            return 0
        if len(weights) == 0:
            return 0
        if weights[0] > capacity:
            return self.bottom_up(capacity, weights[1:], values[1:])
        else:
            use_it = values[0] + self.bottom_up(capacity - weights[0], weights[1:], values[1:])
            lose_it = self.bottom_up(capacity, weights[1:], values[1:])
            return max(use_it, lose_it)
