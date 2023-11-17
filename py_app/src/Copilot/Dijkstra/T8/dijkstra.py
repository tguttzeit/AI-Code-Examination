class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find_shortest_paths(self, source):
        dist = [float('inf')] * self.vertices
        dist[source] = 0
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if dist[source] != float('inf') and dist[source] + weight < dist[destination]:
                    dist[destination] = dist[source] + weight

        return {i: dist[i] for i in range(self.vertices) if dist[i] != float('inf') and i != source}