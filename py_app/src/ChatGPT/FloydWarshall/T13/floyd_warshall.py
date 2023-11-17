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

        # Initialize the result path list
        path = []

        # If there's no edge from source to destination, return an empty path
        if self.graph[source][destination] == float('inf'):
            return path

        # Backtrack to find the shortest path
        while source != destination:
            path.append(source)
            source = self.next_node[source][destination]
        
        path.append(destination)
        return path

    def run(self):
        # Initialize the next_node matrix for path reconstruction
        self.next_node = [[-1] * self.nodes for _ in range(self.nodes)]

        # Initialize the graph with minimum distances and next_node values
        for i in range(self.nodes):
            for j in range(self.nodes):
                if i != j and self.graph[i][j] != float('inf'):
                    self.next_node[i][j] = j

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next_node[i][j] = self.next_node[i][k]