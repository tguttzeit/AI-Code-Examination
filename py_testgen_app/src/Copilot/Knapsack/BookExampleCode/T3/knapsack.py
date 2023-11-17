# Source: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

class Knapsack:

    # CHANGE FOR EXPERIMENT: Renamed method and parameter 'n' got removed
    def bottom_up(self, capacity, weights, values):
        K = [[0 for x in range(capacity + 1)] for x in range(len(values) + 1)]

        # Build table K[][] in bottom up manner
        for i in range(len(values) + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    K[i][w] = 0
                elif weights[i - 1] <= w:
                    K[i][w] = max(values[i - 1]
                                  + K[i - 1][w - weights[i - 1]],
                                  K[i - 1][w])
                else:
                    K[i][w] = K[i - 1][w]

        return K[len(values)][capacity]
