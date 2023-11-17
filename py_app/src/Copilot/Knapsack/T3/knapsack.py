class Knapsack:
    def __init__(self):
        self.capacity = 0
        self.values = []
        self.weights = []
        self.max_value = 0
        self.max_value_list = []

    def bottom_up(self, capacity, weights, values):
        self.capacity = capacity
        self.values = values
        self.weights = weights
        self.max_value = 0
        self.max_value_list = []

        # init 2d array
        table = []
        for i in range(len(self.values) + 1):
            row = []
            for j in range(self.capacity + 1):
                row.append(0)
            table.append(row)

        # fill 2d array
        for i in range(1, len(self.values) + 1):
            for j in range(1, self.capacity + 1):
                if self.weights[i - 1] <= j:
                    table[i][j] = max(self.values[i - 1] + table[i - 1][j - self.weights[i - 1]], table[i - 1][j])
                else:
                    table[i][j] = table[i - 1][j]

        # find max value
        self.max_value = table[len(self.values)][self.capacity]

        # find max value list
        i = len(self.values)
        j = self.capacity
        while i > 0 and j > 0:
            if table[i][j] != table[i - 1][j]:
                self.max_value_list.append(i - 1)
                j -= self.weights[i - 1]
            i -= 1

        return self.max_value

    def __str__(self):
        return "Max Value: " + str(self.max_value) + "\nMax Value List: " + str(self.max_value_list)
