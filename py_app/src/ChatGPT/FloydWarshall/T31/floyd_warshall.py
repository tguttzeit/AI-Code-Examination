class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        # Add an edge with the given weight
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if self.graph[source][destination] == float('inf'):
            return []  # No path exists
        path = [source]
        while source != destination:
            source = self.next_node(source, destination)
            path.append(source)
        return path

    def next_node(self, source, destination):
        min_dist = float('inf')
        next_node = source
        for i in range(self.nodes):
            if i != source and self.graph[source][i] < min_dist:
                min_dist = self.graph[source][i]
                next_node = i
        return next_node

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
