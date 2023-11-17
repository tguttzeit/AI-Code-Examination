class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
        self.edges.append([source, destination, weight])

    def bellman_ford(self, source):
        # Create distance array and initialize it with infinity
        dist = [float("Inf")] * self.V
        # Set distance to source vertex to 0
        dist[source] = 0
        # Iterate over all edges
        for i in range(self.V - 1):
            for source, destination, weight in self.graph:
                if dist[source] != float("Inf") and dist[source] + weight < dist[destination]:
                    dist[destination] = dist[source] + weight
        # Check for negative cycles
        for source, destination, weight in self.graph:
            if dist[source] != float("Inf") and dist[source] + weight < dist[destination]:
                return None
        # Create the result dictionary
        result = {}
        for i in range(self.V):
            if dist[i] != float("Inf"):
                result[i] = dist[i]
        return result