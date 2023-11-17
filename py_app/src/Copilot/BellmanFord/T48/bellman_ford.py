class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # Step 1: fill the distance array and predecessor array
        distance = [float("Inf")] * self.vertices
        predecessor = [-1] * self.vertices
        distance[source] = 0

        # Step 2: relax edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight
                    predecessor[destination] = source

        # Step 3: check for negative-weight cycles
        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                return None

        return distance