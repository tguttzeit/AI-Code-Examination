class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Step 1: Initialize distance to all vertices as infinity and distance to the source as 0
        distance = {vertex: float('inf') for vertex in range(self.vertices)}
        distance[source] = 0

        # Step 2: Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Step 3: Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                # There is a negative cycle
                return None

        # Build and return the result dictionary
        result = {}
        for vertex in range(self.vertices):
            if distance[vertex] != float('inf'):
                result[vertex] = distance[vertex]

        return result
