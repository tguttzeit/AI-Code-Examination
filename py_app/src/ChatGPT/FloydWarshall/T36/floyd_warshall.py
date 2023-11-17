class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight

    def run(self):
        # Initialize the distance matrix with the graph's edges
        dist = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                dist[i][j] = self.graph[i][j]

        # Apply the Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] != float('inf') and dist[k][j] != float('inf'):
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

        self.distances = dist

    def path(self, source, destination):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            if self.distances[source][destination] == float('inf'):
                return []  # No path exists
            path = [source]
            while source != destination:
                next_node = min(
                    range(self.nodes),
                    key=lambda node: self.distances[source][node] + self.distances[node][destination]
                )
                path.append(next_node)
                source = next_node
            return path
        else:
            return []  # Invalid source or destination
