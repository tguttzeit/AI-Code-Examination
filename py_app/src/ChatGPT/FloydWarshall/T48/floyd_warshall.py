class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")

        # Initialize the path matrix with the same values as the graph matrix
        path_matrix = [row[:] for row in self.graph]

        # Calculate the shortest path using Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if path_matrix[i][k] + path_matrix[k][j] < path_matrix[i][j]:
                        path_matrix[i][j] = path_matrix[i][k] + path_matrix[k][j]

        # Reconstruct the shortest path
        if path_matrix[source][destination] == float('inf'):
            return []  # No path exists
        else:
            path = [source]
            while source != destination:
                for next_node in range(self.nodes):
                    if path_matrix[source][destination] == path_matrix[source][next_node] + self.graph[next_node][destination]:
                        path.append(next_node)
                        source = next_node
                        break
            return path

    def run(self):
        # Calculate the shortest paths using Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

