class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinity, except the source
        distances = {vertex: float('infinity') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relaxation step to find shortest distances
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] + weight < distances[destination]:
                return None  # Negative cycle detected

        # Create a dictionary with shortest paths
        shortest_paths = {}
        for vertex, distance in distances.items():
            if distance != float('infinity'):
                shortest_paths[vertex] = distance

        return shortest_paths
