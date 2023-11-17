class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.distances = {}

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        for i in range(self.vertices):
            self.distances[i] = float("inf")
        self.distances[source] = 0

        for i in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if self.distances[source] != float("inf") and self.distances[source] + weight < self.distances[destination]:
                    self.distances[destination] = self.distances[source] + weight

        for source, destination, weight in self.graph:
            if self.distances[source] != float("inf") and self.distances[source] + weight < self.distances[destination]:
                print("Negative cycle found")
                return None

        return self.distances