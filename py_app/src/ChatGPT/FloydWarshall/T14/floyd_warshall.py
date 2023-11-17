class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        # Check for valid node indices
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        # Update the graph with the edge weight
        self.graph[source][destination] = weight

    def run(self):
        # Initialize the distance matrix with the graph values
        distance = [row[:] for row in self.graph]

        # Apply the Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if distance[i][k] + distance[k][j] < distance[i][j]:
                        distance[i][j] = distance[i][k] + distance[k][j]

        self.distance = distance

    def path(self, source, destination):
        # Check for valid node indices
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        # If there's no path from source to destination, return an empty list
        if self.distance[source][destination] == float('inf'):
            return []

        # Reconstruct the shortest path using the distance matrix
        path = [source]
        while source != destination:
            for node in range(self.nodes):
                if (
                    self.distance[source][destination]
                    == self.distance[source][node] + self.distance[node][destination]
                ):
                    path.append(node)
                    source = node
                    break

        return path
