class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity and distance to source as 0
        distance = {vertex: float('inf') for vertex in range(self.V)}
        distance[source] = 0

        # Relax all edges V-1 times
        for _ in range(self.V - 1):
            for source_vertex, dest_vertex, edge_weight in self.graph:
                if distance[source_vertex] != float('inf') and distance[source_vertex] + edge_weight < distance[dest_vertex]:
                    distance[dest_vertex] = distance[source_vertex] + edge_weight

        # Check for negative cycles
        for source_vertex, dest_vertex, edge_weight in self.graph:
            if distance[source_vertex] != float('inf') and distance[source_vertex] + edge_weight < distance[dest_vertex]:
                # Negative cycle detected
                return None

        # Prepare the result dictionary, skipping nodes with no path
        shortest_paths = {}
        for vertex, dist in distance.items():
            if dist != float('inf'):
                shortest_paths[vertex] = dist

        return shortest_paths

