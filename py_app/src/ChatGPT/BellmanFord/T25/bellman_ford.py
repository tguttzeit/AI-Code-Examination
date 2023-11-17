class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0  # Distance to source vertex is 0

        # Relaxation step to find the shortest path
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                return None  # Negative cycle found

        # Create a dictionary to store the shortest paths
        shortest_paths = {}
        for vertex in range(self.vertices):
            if distances[vertex] != float('inf'):
                shortest_paths[vertex] = distances[vertex]

        return shortest_paths
