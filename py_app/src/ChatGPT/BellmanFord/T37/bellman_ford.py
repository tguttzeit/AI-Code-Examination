class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances with a maximum value
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relax all edges for |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                return None  # Negative cycle detected

        # Remove nodes with no path and return the shortest distances
        shortest_distances = {vertex: dist for vertex, dist in distances.items() if dist != float('inf')}
        return shortest_distances
