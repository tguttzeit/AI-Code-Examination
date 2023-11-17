class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinite and the source as 0
        distance = {vertex: float('inf') for vertex in range(self.vertices)}
        distance[source] = 0

        # Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source_vertex, dest_vertex, edge_weight in self.graph:
                if distance[source_vertex] != float('inf') and distance[source_vertex] + edge_weight < distance[dest_vertex]:
                    distance[dest_vertex] = distance[source_vertex] + edge_weight

        # Check for negative cycles
        for source_vertex, dest_vertex, edge_weight in self.graph:
            if distance[source_vertex] != float('inf') and distance[source_vertex] + edge_weight < distance[dest_vertex]:
                # Negative cycle found
                return None

        # Create the result dictionary with shortest paths
        shortest_paths = {}
        for vertex in range(self.vertices):
            if distance[vertex] != float('inf'):
                shortest_paths[vertex] = distance[vertex]

        return shortest_paths
