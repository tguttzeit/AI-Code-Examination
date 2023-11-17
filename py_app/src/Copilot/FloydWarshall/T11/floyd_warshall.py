class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf') for i in range(nodes)] for j in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
    def path(self, source, destination):
        if self.graph[source][destination] == float('inf'):
            return []
        else:
            return [source, destination]
    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
