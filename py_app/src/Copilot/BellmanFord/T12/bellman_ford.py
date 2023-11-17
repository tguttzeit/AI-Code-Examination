class BellmanFord:
    def __init__(self, vertices):
        self.v = vertices
        self.graph = []
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
        self.edges.append([source, destination, weight])

    def bellman_ford(self, source):
        dist = [float("Inf")] * self.v
        dist[source] = 0
        for i in range(self.v - 1):
            for source, destination, weight in self.graph:
                if dist[source] != float("Inf") and dist[source] + weight < dist[destination]:
                    dist[destination] = dist[source] + weight

        for source, destination, weight in self.graph:
            if dist[source] != float("Inf") and dist[source] + weight < dist[destination]:
                return None

        shortest_path = {}
        for i in range(self.v):
            if dist[i] != float("Inf"):
                shortest_path[i] = dist[i]
        return shortest_path