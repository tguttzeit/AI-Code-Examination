class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances and predecessor dictionaries
        distance = {v: float('inf') for v in range(self.vertices)}
        predecessor = {v: None for v in range(self.vertices)}
        distance[source] = 0

        # Relaxation step
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight
                    predecessor[destination] = source

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                return None  # Negative cycle detected

        # Construct the result dictionary
        result = {}
        for v in range(self.vertices):
            if distance[v] != float('inf'):
                result[v] = (distance[v], predecessor[v])

        return result
