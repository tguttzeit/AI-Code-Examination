class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity and the source as 0
        distances = {vertex: float('infinity') for vertex in range(self.vertices)}
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

        # Filter out unreachable nodes and return the shortest distances
        shortest_distances = {vertex: distance for vertex, distance in distances.items() if distance != float('infinity')}
        return shortest_distances
