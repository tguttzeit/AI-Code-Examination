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
        if (
            0 <= source < self.nodes
            and 0 <= destination < self.nodes
            and self.graph[source][destination] != float('inf')
        ):
            return [source, destination]

        # Initialize the predecessor matrix to trace the path.
        predecessor = [[-1] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if i != j and self.graph[i][j] != float('inf'):
                    predecessor[i][j] = i

        # Run Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        predecessor[i][j] = predecessor[k][j]

        # Reconstruct the path if it exists
        if predecessor[source][destination] == -1:
            return []
        path = []
        while source != destination:
            path.append(source)
            source = predecessor[source][destination]
        path.append(destination)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
