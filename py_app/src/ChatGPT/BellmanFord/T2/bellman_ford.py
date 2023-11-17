class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances from the source node to all other nodes as infinite
        distance = {vertex: float("inf") for vertex in range(self.vertices)}
        distance[source] = 0

        # Relax all edges V-1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float("inf") and distance[source] + weight < distance[destination]:
                # Negative cycle detected
                return None

        # Build the result dictionary
        shortest_paths = {}
        for vertex, dist in enumerate(distance):
            if dist != float("inf"):
                shortest_paths[vertex] = dist

        return shortest_paths

