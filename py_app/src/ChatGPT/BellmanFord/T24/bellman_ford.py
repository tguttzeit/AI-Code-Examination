class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances with infinity and the source node with 0.
        distances = {vertex: float('infinity') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relaxation step
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] + weight < distances[destination]:
                return None  # Negative cycle detected

        # Filter out nodes with no path
        shortest_paths = {k: v for k, v in distances.items() if v != float('infinity')}

        return shortest_paths
