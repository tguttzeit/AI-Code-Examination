class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.distance = [[float("inf")] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.distance[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.distance[source][destination] = weight

    def path(self, source, destination):
        if self.distance[source][destination] == float("inf"):
            return []

        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        return path

    def run(self):
        self.next = [[None] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                self.next[i][j] = j if self.distance[i][j] != float("inf") else None

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distance[i][k] == float("inf") or self.distance[k][j] == float("inf"):
                        continue
                    if self.distance[i][k] + self.distance[k][j] < self.distance[i][j]:
                        self.distance[i][j] = self.distance[i][k] + self.distance[k][j]
                        self.next[i][j] = self.next[i][k]