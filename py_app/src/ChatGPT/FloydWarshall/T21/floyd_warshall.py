class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.distances = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight
            self.distances[source][destination] = weight

    def path(self, source, destination):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            if self.distances[source][destination] == float('inf'):
                return []
            path = [source]
            while source != destination:
                next_node = None
                for i in range(self.nodes):
                    if self.distances[source][i] + self.graph[i][destination] == self.distances[source][destination]:
                        next_node = i
                        break
                if next_node is None:
                    return []  # No path found
                path.append(next_node)
                source = next_node
            return path
        else:
            return []

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distances[i][k] + self.distances[k][j] < self.distances[i][j]:
                        self.distances[i][j] = self.distances[i][k] + self.distances[k][j]
