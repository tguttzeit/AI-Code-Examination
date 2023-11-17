class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf') for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
        self.dist = [[float('inf') for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.dist[i][i] = 0
        self.next = [[float('inf') for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.next[i][i] = -1

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.dist[source][destination] = weight
        self.next[source][destination] = destination

    def path(self, source, destination):
        if self.dist[source][destination] == float('inf'):
            return []
        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.dist[i][j] > self.dist[i][k] + self.dist[k][j]:
                        self.dist[i][j] = self.dist[i][k] + self.dist[k][j]
                        self.next[i][j] = self.next[i][k]