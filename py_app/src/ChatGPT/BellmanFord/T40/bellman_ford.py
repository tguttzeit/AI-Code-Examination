class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinity and distance to source as 0
        distance = {v: float("inf") for v in range(self.vertices)}
        distance[source] = 0

        # Relax all edges |V| - 1 times, where |V| is the number of vertices
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float("inf") and distance[source] + weight < distance[destination]:
                return None  # Negative cycle exists

        # Create a dictionary to store the shortest paths
        shortest_paths = {v: distance[v] for v in range(self.vertices) if distance[v] != float("inf")}

        return shortest_paths
