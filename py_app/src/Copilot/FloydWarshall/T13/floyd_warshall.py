class FloydWarshall:

    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[0 for column in range(nodes)] for row in range(nodes)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if self.graph[source][destination] == 0:
            return []
        else:
            return [source, destination]

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    self.graph[i][j] = min(self.graph[i][j], self.graph[i][k] + self.graph[k][j])
