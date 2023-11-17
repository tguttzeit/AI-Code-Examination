class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.matrix = [[float("inf")] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.matrix[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.matrix[source][destination] = weight

    def path(self, source, destination):
        if self.matrix[source][destination] == float("inf"):
            return []
        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        return path

    def run(self):
        self.next = [[0] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if self.matrix[i][j] != float("inf"):
                    self.next[i][j] = j
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.matrix[i][k] + self.matrix[k][j] < self.matrix[i][j]:
                        self.matrix[i][j] = self.matrix[i][k] + self.matrix[k][j]
                        self.next[i][j] = self.next[i][k]