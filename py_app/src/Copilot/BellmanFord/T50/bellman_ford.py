class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        distances = [float("Inf")] * self.vertices
        distances[source] = 0
        for _ in range(self.vertices - 1):
            for src, dest, weight in self.graph:
                if distances[src] != float("Inf") and distances[src] + weight < distances[dest]:
                    distances[dest] = distances[src] + weight

        for src, dest, weight in self.graph:
            if distances[src] != float("Inf") and distances[src] + weight < distances[dest]:
                return None

        return distances
