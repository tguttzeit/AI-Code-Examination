class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # init distance
        distance = [float('inf')] * self.vertices
        distance[source] = 0

        # relax edges
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # check negative cycle
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                return None

        return distance