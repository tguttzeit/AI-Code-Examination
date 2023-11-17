class Dijkstra:

    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.distances = [float('inf')] * vertices

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find_shortest_paths(self, source):
        self.distances[source] = 0
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if self.distances[source] != float('inf') and self.distances[source] + weight < self.distances[destination]:
                    self.distances[destination] = self.distances[source] + weight
        return self.distances