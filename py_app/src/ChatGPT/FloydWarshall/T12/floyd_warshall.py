class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        # Adding an edge with the given weight
        if source < self.nodes and destination < self.nodes:
            self.graph[source][destination] = weight

    def path(self, source, destination):
        if source == destination:
            return [source]

        # Initialize the path with the source and destination
        path = [source, destination]

        # If there's no edge between source and destination, return an empty path
        if self.graph[source][destination] == float('inf'):
            return []

        # If there is a direct edge from source to destination, return the path
        if self.graph[source][destination] != float('inf'):
            return path

        # Floyd-Warshall's algorithm to find the shortest path
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

        # If there is a path from source to destination, update the path
        if self.graph[source][destination] != float('inf'):
            path = []
            while source != destination:
                path.append(source)
                for i in range(self.nodes):
                    if self.graph[source][destination] == self.graph[source][i] + self.graph[i][destination]:
                        source = i
                        break
            path.append(destination)
        return path

    def run(self):
        # Floyd-Warshall's algorithm to find all shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
