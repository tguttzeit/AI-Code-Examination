class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.nodes = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
        if source not in self.nodes:
            self.nodes.append(source)
        if destination not in self.nodes:
            self.nodes.append(destination)

    def bellman_ford(self, source):
        distance = {node: float("Inf") for node in self.nodes}
        distance[source] = 0

        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                return None

        return distance