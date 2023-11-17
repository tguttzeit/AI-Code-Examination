class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []
    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
    def bellman_ford(self, source):
        dist = [float("Inf")] * self.V
        dist[source] = 0
        for i in range(self.V - 1):
            for source, destination, weight in self.graph:
                if dist[source] != float("Inf") and dist[source] + weight < dist[destination]:
                    dist[destination] = dist[source] + weight
        for source, destination, weight in self.graph:
            if dist[source] != float("Inf") and dist[source] + weight < dist[destination]:
                return None
        return dist
