class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float("inf")] * nodes for i in range(nodes)]
        self.dist = [[float("inf")] * nodes for i in range(nodes)]
        self.next = [[float("inf")] * nodes for i in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
            self.dist[i][i] = 0
            self.next[i][i] = i

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.dist[source][destination] = weight
        self.next[source][destination] = destination

    def path(self, source, destination):
        if self.dist[source][destination] == float("inf"):
            return []
        path = []
        while source != destination:
            path.append(source)
            source = self.next[source][destination]
        path.append(destination)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.dist[i][k] + self.dist[k][j] < self.dist[i][j]:
                        self.dist[i][j] = self.dist[i][k] + self.dist[k][j]
                        self.next[i][j] = self.next[i][k]