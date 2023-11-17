class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances from the source to all vertices as infinity
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relax all edges (V-1) times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                return None  # Negative cycle found

        # Prepare the result dictionary
        shortest_paths = {}
        for vertex, distance in enumerate(distances):
            if distance != float('inf'):
                shortest_paths[vertex] = distance

        return shortest_paths
