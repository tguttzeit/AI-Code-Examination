class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.INF = float('inf')
        self.distances = [[self.INF] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.distances[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")
        self.distances[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")
        
        # Initialize path matrix with node indices as a path
        path_matrix = [[i if i != j else -1 for j in range(self.nodes)] for i in range(self.nodes)]
        
        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distances[i][k] != self.INF and self.distances[k][j] != self.INF:
                        if self.distances[i][j] > self.distances[i][k] + self.distances[k][j]:
                            self.distances[i][j] = self.distances[i][k] + self.distances[k][j]
                            path_matrix[i][j] = path_matrix[k][j]
        
        # Reconstruct the path
        path = []
        while source != destination:
            if path_matrix[source][destination] == -1:
                return []  # No path exists
            path.append(source)
            source = path_matrix[source][destination]
        path.append(destination)
        
        return path

    def run(self):
        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distances[i][j] > self.distances[i][k] + self.distances[k][j]:
                        self.distances[i][j] = self.distances[i][k] + self.distances[k][j]
