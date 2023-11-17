class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.next_node = [[None] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        if source == destination:
            return  # No self-loops allowed
        self.graph[source][destination] = weight
        self.next_node[source][destination] = destination

    def path(self, source, destination):
        if self.graph[source][destination] == float('inf'):
            return []  # No path exists
        path = [source]
        while source != destination:
            source = self.next_node[source][destination]
            path.append(source)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next_node[i][j] = self.next_node[i][k]
