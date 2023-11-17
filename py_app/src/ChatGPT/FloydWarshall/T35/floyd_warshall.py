class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

        # Initialize diagonal elements to 0
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        # Check if source and destination are valid nodes
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")

        # Add the edge with the given weight
        self.graph[source][destination] = weight

    def path(self, source, destination):
        # Check if source and destination are valid nodes
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")

        # Initialize the result list to store the shortest path
        path_result = []

        # Initialize the distance matrix using the Floyd-Warshall algorithm
        dist = [list(row) for row in self.graph]

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][j] > dist[i][k] + dist[k][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]

        # Reconstruct the shortest path from source to destination
        if dist[source][destination] == float('inf'):
            return path_result  # No path exists

        path_result.append(source)
        while source != destination:
            for i in range(self.nodes):
                if dist[source][destination] == dist[source][i] + self.graph[i][destination]:
                    source = i
                    path_result.append(i)
                    break

        return path_result

    def run(self):
        # Apply the Floyd-Warshall algorithm to find shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
