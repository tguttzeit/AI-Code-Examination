class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances with a large value (infinity)
        distances = {v: float('inf') for v in range(self.vertices)}
        distances[source] = 0

        # Relax edges |V-1| times
        for _ in range(self.vertices - 1):
            for source_node, dest_node, weight in self.graph:
                if distances[source_node] != float('inf') and distances[source_node] + weight < distances[dest_node]:
                    distances[dest_node] = distances[source_node] + weight

        # Check for negative cycles
        for source_node, dest_node, weight in self.graph:
            if distances[source_node] != float('inf') and distances[source_node] + weight < distances[dest_node]:
                return None  # Negative cycle detected

        # Create the result dictionary with valid paths
        result = {}
        for vertex, distance in enumerate(distances):
            if distance != float('inf'):
                result[vertex] = distance

        return result
