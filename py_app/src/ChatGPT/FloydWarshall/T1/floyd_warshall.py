class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        dist = [[float('inf')] * self.nodes for _ in range(self.nodes)]

        # Initialize dist matrix with the values from the graph
        for i in range(self.nodes):
            for j in range(self.nodes):
                dist[i][j] = self.graph[i][j]

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]

        # If there is no path from source to destination, return an empty list
        if dist[source][destination] == float('inf'):
            return []

        # Reconstruct the shortest path
        path = []
        while source != destination:
            path.append(source)
            for i in range(self.nodes):
                if dist[source][destination] == dist[source][i] + self.graph[i][destination]:
                    source = i
                    break
        path.append(destination)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

