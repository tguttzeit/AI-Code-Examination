import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming it's an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances with infinity and the source with 0
        distances = [float('inf')] * self.vertices
        distances[source] = 0

        # Priority queue to track vertices with their distances
        pq = [(0, source)]

        shortest_paths = {}

        while pq:
            dist_u, u = heapq.heappop(pq)

            # Skip this node if no path exists
            if dist_u > distances[u]:
                continue

            shortest_paths[u] = dist_u

            for v, weight in self.graph[u]:
                if dist_u + weight < distances[v]:
                    distances[v] = dist_u + weight
                    heapq.heappush(pq, (distances[v], v))

        # Create a dictionary of shortest paths
        result = {}
        for i, distance in enumerate(distances):
            if i != source and distance < float('inf'):
                result[i] = distance

        return result
