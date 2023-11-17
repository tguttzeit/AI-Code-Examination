class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node.")
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node.")

        dist = [list(row) for row in self.graph]

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]

        if dist[source][destination] == float('inf'):
            return []
        else:
            path = [source]
            while source != destination:
                for i in range(self.nodes):
                    if dist[source][destination] == dist[source][i] + self.graph[i][destination]:
                        path.append(i)
                        source = i
                        break
            return path

    def run(self):
        dist = [list(row) for row in self.graph]

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]

        self.graph = dist
