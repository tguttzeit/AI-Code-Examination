class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance dictionary with infinity for all vertices except source
        distance = {v: float('inf') for v in range(self.vertices)}
        distance[source] = 0

        # Relaxation step (V - 1) times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                return None  # Negative cycle detected

        # Prepare the result dictionary, skipping nodes with no path
        shortest_paths = {}
        for vertex in range(self.vertices):
            if distance[vertex] != float('inf'):
                shortest_paths[vertex] = distance[vertex]

        return shortest_paths