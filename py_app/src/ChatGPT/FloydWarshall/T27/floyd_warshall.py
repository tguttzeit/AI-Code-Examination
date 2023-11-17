class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight

    def path(self, source, destination):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            if self.graph[source][destination] == float('inf'):
                return []
            path = [source]
            while source != destination:
                source = self.next_node[source][destination]
                path.append(source)
            return path
        else:
            return []

    def run(self):
        self.next_node = [[-1] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if i != j and self.graph[i][j] != float('inf'):
                    self.next_node[i][j] = i

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next_node[i][j] = self.next_node[k][j]

