class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.edges = []
        self.distances = []
        self.parent = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
        self.edges.append([source, destination])
        self.distances.append(weight)

    def bellman_ford(self, source):
        self.distances[source] = 0
        self.parent[source] = source

        for i in range(self.vertices - 1):
            for j in range(len(self.graph)):
                u = self.graph[j][0]
                v = self.graph[j][1]
                w = self.graph[j][2]

                if self.distances[u] != float("Inf") and self.distances[u] + w < self.distances[v]:
                    self.distances[v] = self.distances[u] + w
                    self.parent[v] = u

        for i in range(len(self.graph)):
            u = self.graph[i][0]
            v = self.graph[i][1]
            w = self.graph[i][2]

            if self.distances[u] != float("Inf") and self.distances[u] + w < self.distances[v]:
                return None

        return self.distances