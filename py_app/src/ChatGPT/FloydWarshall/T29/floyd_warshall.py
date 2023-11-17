class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.distances = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        # Add an edge with the given weight to the graph
        self.graph[source][destination] = weight

    def path(self, source, destination):
        # Check if there is a path from source to destination
        if self.distances[source][destination] == float('inf'):
            return []

        # Reconstruct the shortest path
        path = [source]
        while source != destination:
            source = self.distances[source][destination][1]
            path.append(source)
        return path

    def run(self):
        # Initialize the distances matrix with the graph
        for i in range(self.nodes):
            for j in range(self.nodes):
                self.distances[i][j] = [self.graph[i][j], j]

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distances[i][j][0] > self.distances[i][k][0] + self.distances[k][j][0]:
                        self.distances[i][j][0] = self.distances[i][k][0] + self.distances[k][j][0]
                        self.distances[i][j][1] = self.distances[i][k][1]
