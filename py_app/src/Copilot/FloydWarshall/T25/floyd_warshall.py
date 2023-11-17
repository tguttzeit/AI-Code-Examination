class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf') for j in range(nodes)] for i in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if self.graph[source][destination] == float('inf'):
            return []
        path = [source]
        while source != destination:
            source = self.graph[source].index(min(self.graph[source]))
            path.append(source)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    self.graph[i][j] = min(self.graph[i][j], self.graph[i][k] + self.graph[k][j])
