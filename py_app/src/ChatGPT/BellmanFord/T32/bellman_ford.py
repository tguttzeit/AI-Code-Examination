class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # Initialize distance array with maximum value
        distance = {vertex: float('inf') for vertex in range(self.V)}
        distance[source] = 0

        # Relaxation step
        for _ in range(self.V - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                return None  # Negative cycle detected

        # Prepare the result dictionary, skipping unreachable nodes
        result = {}
        for vertex in range(self.V):
            if distance[vertex] != float('inf'):
                result[vertex] = distance[vertex]

        return result
