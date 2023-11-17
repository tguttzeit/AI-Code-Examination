class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances from the source vertex to all other vertices as infinity
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0

        # Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source_vertex, dest_vertex, weight in self.graph:
                if distances[source_vertex] != float('inf') and distances[source_vertex] + weight < distances[dest_vertex]:
                    distances[dest_vertex] = distances[source_vertex] + weight

        # Check for negative cycles
        for source_vertex, dest_vertex, weight in self.graph:
            if distances[source_vertex] != float('inf') and distances[source_vertex] + weight < distances[dest_vertex]:
                return None  # Negative cycle detected

        # Create the result dictionary, excluding unreachable nodes
        result = {vertex: distances[vertex] for vertex in range(self.vertices) if distances[vertex] != float('inf')}
        return result
