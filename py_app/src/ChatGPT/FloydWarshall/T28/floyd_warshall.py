class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.distances = [[float('inf')] * nodes for _ in range(nodes)]
        self.constructed = False

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")
        self.graph[source][destination] = weight
        self.constructed = False

    def path(self, source, destination):
        if not self.constructed:
            raise ValueError("Call run() method to construct the shortest paths first")
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")

        if self.distances[source][destination] == float('inf'):
            return []
        
        path = [source]
        while source != destination:
            source = self.distances[source][destination][1]
            path.append(source)
        return path

    def run(self):
        self.distances = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if i == j:
                    self.distances[i][j] = 0
                elif self.graph[i][j] != float('inf'):
                    self.distances[i][j] = self.graph[i][j]

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distances[i][k] + self.distances[k][j] < self.distances[i][j]:
                        self.distances[i][j] = self.distances[i][k] + self.distances[k][j]

        self.constructed = True
