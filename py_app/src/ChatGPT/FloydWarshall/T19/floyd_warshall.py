class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

        # Initialize the diagonal with 0 since the distance from a node to itself is always 0.
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

    def path(self, source, destination):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            if self.graph[source][destination] == float('inf'):
                return []  # No path exists
            else:
                # Reconstruct the shortest path
                path = [source]
                while source != destination:
                    for j in range(self.nodes):
                        if self.graph[source][destination] == self.graph[source][j] + self.graph[j][destination]:
                            path.append(j)
                            source = j
                            break
                return path
        else:
            return []  # Invalid source or destination
