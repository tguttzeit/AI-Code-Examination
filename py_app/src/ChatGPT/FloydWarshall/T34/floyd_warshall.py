class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.constructed = False

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")
        self.graph[source][destination] = weight
        self.constructed = False

    def path(self, source, destination):
        if not self.constructed:
            raise ValueError("Graph is not yet constructed. Call run() method first.")
        
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")

        if self.graph[source][destination] == float('inf'):
            return []

        # Reconstruct the path using the predecessor matrix
        path = [source]
        while source != destination:
            source = self.predecessor[source][destination]
            path.append(source)

        return path

    def run(self):
        self.predecessor = [[-1] * self.nodes for _ in range(self.nodes)]

        for i in range(self.nodes):
            for j in range(self.nodes):
                if i == j:
                    continue
                self.predecessor[i][j] = i

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.predecessor[i][j] = self.predecessor[k][j]

        self.constructed = True

