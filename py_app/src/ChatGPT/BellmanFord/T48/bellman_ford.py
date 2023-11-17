class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Step 1: Initialize distance from source to all other vertices as infinity
        distance = {vertex: float('inf') for vertex in range(self.vertices)}
        distance[source] = 0

        # Step 2: Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Step 3: Check for negative-weight cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                return None  # Negative cycle detected

        # Remove nodes with unreachable paths from the output dictionary
        shortest_paths = {vertex: distance[vertex] for vertex in distance if distance[vertex] != float('inf')}

        return shortest_paths
