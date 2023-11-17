class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[None for i in range(nodes)] for j in range(nodes)]
        self.dist = [[None for i in range(nodes)] for j in range(nodes)]
        self.next = [[None for i in range(nodes)] for j in range(nodes)]
        self.has_negative_cycle = False

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if self.has_negative_cycle:
            return []
        if self.dist[source][destination] is None:
            return []
        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        return path

    def run(self):
        for i in range(self.nodes):
            for j in range(self.nodes):
                if self.graph[i][j] is not None:
                    self.dist[i][j] = self.graph[i][j]
                    self.next[i][j] = j
                else:
                    self.dist[i][j] = float('inf')
                    self.next[i][j] = None
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.dist[i][k] + self.dist[k][j] < self.dist[i][j]:
                        self.dist[i][j] = self.dist[i][k] + self.dist[k][j]
                        self.next[i][j] = self.next[i][k]
        for i in range(self.nodes):
            if self.dist[i][i] < 0:
                self.has_negative_cycle = True
                break