class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.matrix = [[float('inf') for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.matrix[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.matrix[source][destination] = weight

    def path(self, source, destination):
        if self.matrix[source][destination] == float('inf'):
            return []
        else:
            return [source, destination]

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    self.matrix[i][j] = min(self.matrix[i][j], self.matrix[i][k] + self.matrix[k][j])
