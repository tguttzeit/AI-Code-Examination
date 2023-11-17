class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        if source == destination:
            return
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source == destination:
            return [source]

        if self.graph[source][destination] == float('inf'):
            return []

        path = [source]
        while source != destination:
            source = self.next_node[source][destination]
            path.append(source)

        return path

    def run(self):
        # Initialize next_node matrix for path reconstruction
        self.next_node = [[None] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                if self.graph[i][j] != float('inf'):
                    self.next_node[i][j] = j
                else:
                    self.next_node[i][j] = None

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next_node[i][j] = self.next_node[i][k]
