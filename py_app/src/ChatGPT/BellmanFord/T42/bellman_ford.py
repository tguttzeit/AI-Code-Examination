class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances with a maximum value
        distances = {vertex: float('inf') for vertex in range(self.V)}
        distances[source] = 0

        # Relax all edges V-1 times
        for _ in range(self.V - 1):
            for source, destination, weight in self.graph:
                if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                    distances[destination] = distances[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distances[source] != float('inf') and distances[source] + weight < distances[destination]:
                return None  # Negative cycle detected

        # Create a dictionary with the shortest path to each node
        shortest_paths = {vertex: distances[vertex] for vertex in range(self.V) if distances[vertex] != float('inf')}
        return shortest_paths
