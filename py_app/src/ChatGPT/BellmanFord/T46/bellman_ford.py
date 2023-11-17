class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances to all nodes as infinity, except the source node
        distances = {node: float('inf') for node in range(self.vertices)}
        distances[source] = 0

        # Relax edges |V| - 1 times where |V| is the number of vertices
        for _ in range(self.vertices - 1):
            for source_node, dest_node, weight in self.graph:
                if distances[source_node] != float('inf') and distances[source_node] + weight < distances[dest_node]:
                    distances[dest_node] = distances[source_node] + weight

        # Check for negative cycles
        for source_node, dest_node, weight in self.graph:
            if distances[source_node] != float('inf') and distances[source_node] + weight < distances[dest_node]:
                return None  # Negative cycle found

        # Create the result dictionary, omitting nodes with no path
        result = {node: distance for node, distance in enumerate(distances) if distance != float('inf')}

        return result