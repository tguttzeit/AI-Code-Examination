class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity
        distances = {v: float('infinity') for v in range(self.vertices)}
        distances[source] = 0

        # Relax edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] != float('infinity') and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] != float('infinity') and distances[source] + weight < distances[destination]:
                return None  # Negative cycle detected

        # Create a dictionary to store the shortest paths
        shortest_paths = {}
        for v in range(self.vertices):
            if distances[v] != float('infinity'):
                shortest_paths[v] = distances[v]

        return shortest_paths
