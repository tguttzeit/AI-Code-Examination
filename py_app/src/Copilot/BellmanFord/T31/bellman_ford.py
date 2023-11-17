class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # Step 1: fill the distance list and predecessor list
        distance = [float("Inf")] * self.vertices
        predecessor = [None] * self.vertices
        distance[source] = 0

        # Step 2: relax edges
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight
                    predecessor[destination] = source

        # Step 3: detect negative cycle
        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                return None

        # Step 4: return the shortest path
        result = {}
        for i in range(self.vertices):
            if distance[i] != float("Inf"):
                result[i] = distance[i]
        return result