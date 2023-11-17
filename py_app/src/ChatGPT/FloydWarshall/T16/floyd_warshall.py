class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

        # Initialize diagonal elements to 0
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")

        # Initialize the path matrix with the same values as the graph
        path_matrix = [[None for _ in range(self.nodes)] for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if i != j and self.graph[i][j] != float('inf'):
                    path_matrix[i][j] = i

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        path_matrix[i][j] = path_matrix[k][j]

        # Reconstruct the path if it exists
        if path_matrix[source][destination] is None:
            return []
        path = [destination]
        while path[-1] != source:
            path.append(path_matrix[source][path[-1]])
        return path[::-1]

    def run(self):
        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
    