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
            for source, destination, weight in self.graph:
                if distances[source] != float("Inf") and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        for source, destination, weight in self.graph:
            if distances[source] != float("Inf") and distances[source] + weight < distances[destination]:
                print("Graph contains negative cycle")
                return None

        output = {}
        for i in range(self.vertices):
            if distances[i] != float("Inf"):
                output[i] = distances[i]

        return output