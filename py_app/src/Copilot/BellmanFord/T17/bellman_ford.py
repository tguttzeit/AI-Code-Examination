class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []
        self.dist = {}

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        for i in range(self.V):
            self.dist[i] = float("Inf")
        self.dist[source] = 0

        for i in range(self.V-1):
            for source, destination, weight in self.graph:
                if self.dist[source] != float("Inf") and self.dist[source] + weight < self.dist[destination]:
                    self.dist[destination] = self.dist[source] + weight

        for source, destination, weight in self.graph:
            if self.dist[source] != float("Inf") and self.dist[source] + weight < self.dist[destination]:
                return None
        return self.dist