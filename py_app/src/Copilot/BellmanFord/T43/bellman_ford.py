class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
        self.edges.append([source, destination, weight])
        self.edges.append([destination, source, weight])

    def bellman_ford(self, source):
        distance = [float("Inf")] * self.vertices
        distance[source] = 0
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        for source, destination, weight in self.edges:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                return None

        return {i: distance[i] for i in range(self.vertices) if i != source and distance[i] != float("Inf")}