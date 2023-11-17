class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.INF = float('inf')
        self.graph = [[self.INF] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        # Check if source and destination are valid nodes
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight

    def path(self, source, destination):
        # Check if source and destination are valid nodes
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            # Initialize the result list to store the shortest path
            result = []

            # If there is no path from source to destination, return an empty list
            if self.graph[source][destination] == self.INF:
                return result

            # Initialize the predecessor matrix to track the path
            predecessor = [[-1] * self.nodes for _ in range(self.nodes)]

            # Initialize the shortest paths using Floyd-Warshall algorithm
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] != self.INF:
                        predecessor[i][j] = i

            # Reconstruct the path
            while source != destination:
                result.append(destination)
                destination = predecessor[source][destination]

            result.append(source)
            result.reverse()
            return result

        else:
            # Invalid source or destination node
            return []

    def run(self):
        # Floyd-Warshall algorithm implementation
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

