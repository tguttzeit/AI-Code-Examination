class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.inf = float('inf')
        self.graph = [[self.inf] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight

    def path(self, source, destination):
        if (
            0 <= source < self.nodes
            and 0 <= destination < self.nodes
            and self.graph[source][destination] != self.inf
        ):
            return [source, destination]
        return []

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if (
                        self.graph[i][k] != self.inf
                        and self.graph[k][j] != self.inf
                        and self.graph[i][k] + self.graph[k][j] < self.graph[i][j]
                    ):
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
