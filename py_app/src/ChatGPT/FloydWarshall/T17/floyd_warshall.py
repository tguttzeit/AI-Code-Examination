class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        if source == destination:
            self.graph[source][destination] = 0
        else:
            self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            return []

        if self.graph[source][destination] == float('inf'):
            return []

        path = [source]
        while source != destination:
            next_node = self.next_node[source][destination]
            path.append(next_node)
            source = next_node

        return path

    def run(self):
        dist = self.graph.copy()
        self.next_node = [[-1] * self.nodes for _ in range(self.nodes)]

        for i in range(self.nodes):
            for j in range(self.nodes):
                if i != j and dist[i][j] != float('inf'):
                    self.next_node[i][j] = i

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][j] > dist[i][k] + dist[k][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
                        self.next_node[i][j] = self.next_node[k][j]

        self.graph = dist
