class Knapsack:
    def bottom_up(self, capacity, weights, values):
        n = len(weights)
        if n == 0:
            return 0
        if capacity == 0:
            return 0

        # Initialize the memo
        memo = [[0 for j in range(capacity + 1)] for i in range(n + 1)]

        # Fill the memo
        for i in range(n + 1):
            for j in range(capacity + 1):
                if i == 0 or j == 0:
                    memo[i][j] = 0
                elif weights[i - 1] <= j:
                    memo[i][j] = max(values[i - 1] + memo[i - 1][j - weights[i - 1]], memo[i - 1][j])
                else:
                    memo[i][j] = memo[i - 1][j]

        # Return the maximum value
        return memo[n][capacity]


