class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

        # Initialize the diagonal with zeros
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        # Initialize the path matrix with the same values as the graph
        path_matrix = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                path_matrix[i][j] = self.graph[i][j]

        # Construct the path matrix using the Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    path_matrix[i][j] = min(path_matrix[i][j], path_matrix[i][k] + path_matrix[k][j])

        # If there is no path from source to destination, return an empty list
        if path_matrix[source][destination] == float('inf'):
            return []

        # Reconstruct the path from source to destination
        path = []
        while source != destination:
            path.append(source)
            for i in range(self.nodes):
                if path_matrix[source][destination] == self.graph[source][i] + path_matrix[i][destination]:
                    source = i
                    break
        path.append(destination)

        return path

    def run(self):
        # Apply the Floyd-Warshall algorithm to find all shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    self.graph[i][j] = min(self.graph[i][j], self.graph[i][k] + self.graph[k][j])

