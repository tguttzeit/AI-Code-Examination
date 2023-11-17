class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float("inf") for i in range(nodes)] for j in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if self.graph[source][destination] == float("inf"):
            return []
        result = [source]
        while source != destination:
            source = self.next[source][destination]
            result.append(source)
        return result

    def run(self):
        self.next = [[float("inf") for i in range(self.nodes)] for j in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if self.graph[i][j] != float("inf"):
                    self.next[i][j] = j
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next[i][j] = self.next[i][k]