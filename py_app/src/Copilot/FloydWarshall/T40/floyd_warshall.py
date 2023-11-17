class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf') for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source == destination:
            return []
        path = []
        if self.graph[source][destination] != float('inf'):
            path.append(source)
            path.append(destination)
            return path
        return []

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]