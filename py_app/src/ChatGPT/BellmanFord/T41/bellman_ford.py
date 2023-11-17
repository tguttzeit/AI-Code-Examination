class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances from the source to all other vertices as infinity
        distances = {vertex: float('infinity') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relax all edges |V| - 1 times, where |V| is the number of vertices
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] + weight < distances[destination]:
                return None  # Negative cycle detected

        # Construct the shortest path dictionary
        shortest_paths = {vertex: distance for vertex, distance in distances.items() if distance != float('infinity')}
        return shortest_paths
