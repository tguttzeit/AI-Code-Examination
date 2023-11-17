class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float("inf") for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source == destination:
            return [source]
        if self.graph[source][destination] == float("inf"):
            return []
        path = []
        while source != destination:
            path.append(source)
            source = self.next[source][destination]
        path.append(destination)
        return path

    def run(self):
        self.next = [[float("inf") for _ in range(self.nodes)] for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if self.graph[i][j] != float("inf"):
                    self.next[i][j] = j
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next[i][j] = self.next[i][k]
        return self.graph