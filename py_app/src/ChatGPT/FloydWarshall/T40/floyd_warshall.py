class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

        # Initialize the diagonal with zeros (distance to itself is always 0)
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")

        # Initialize a matrix to store the shortest distances
        dist = [row[:] for row in self.graph]

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]

        # Check for negative cycles (if the diagonal becomes negative)
        for i in range(self.nodes):
            if dist[i][i] < 0:
                return []  # Negative cycle detected, no valid path

        # Reconstruct the path
        path = []
        while destination != source:
            path.append(destination)
            for i in range(self.nodes):
                if dist[source][destination] == dist[source][i] + self.graph[i][destination]:
                    destination = i
                    break
        path.append(source)
        return path[::-1]  # Reverse the path to get it from source to destination

    def run(self):
        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
