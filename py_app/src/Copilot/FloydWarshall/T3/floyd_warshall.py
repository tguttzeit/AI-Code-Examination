class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float("inf") for _ in range(nodes)] for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            return []
        if self.graph[source][destination] == float("inf"):
            return []
        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        return path

    def run(self):
        self.next = [[-1 for _ in range(self.nodes)] for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if self.graph[i][j] != float("inf"):
                    self.next[i][j] = j
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] != float("inf") and self.graph[k][j] != float("inf") and self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next[i][j] = self.next[i][k]
        for i in range(self.nodes):
            if self.graph[i][i] < 0:
                return False
        return True