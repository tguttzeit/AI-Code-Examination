class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        # Add an edge to the graph with the given weight
        self.graph[source][destination] = weight

    def path(self, source, destination):
        # Check if there is a direct edge from source to destination
        if self.graph[source][destination] != float('inf'):
            return [source, destination]

        # Initialize the path matrix with the same values as the graph
        path_matrix = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                path_matrix[i][j] = self.graph[i][j]

        # Apply Floyd-Warshall algorithm to find shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if path_matrix[i][k] + path_matrix[k][j] < path_matrix[i][j]:
                        path_matrix[i][j] = path_matrix[i][k] + path_matrix[k][j]

        # If there is still no path from source to destination, return an empty list
        if path_matrix[source][destination] == float('inf'):
            return []

        # Reconstruct the path using the path matrix
        path = [source]
        while source != destination:
            for neighbor in range(self.nodes):
                if path_matrix[source][destination] == self.graph[source][neighbor] + path_matrix[neighbor][destination]:
                    path.append(neighbor)
                    source = neighbor
                    break

        return path

    def run(self):
        # Apply the Floyd-Warshall algorithm to compute all-pairs shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

