class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinite and distance to the source as 0
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relaxation step: Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                return None  # Negative cycle exists

        # Create a dictionary with the shortest distances to each node
        shortest_paths = {vertex: distances[vertex] for vertex in range(self.vertices) if distances[vertex] != float('inf')}

        return shortest_paths
