import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming it's an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances and a priority queue for Dijkstra's algorithm
        distances = [float('inf')] * self.vertices
        distances[source] = 0
        priority_queue = [(0, source)]  # (distance, vertex)

        shortest_paths = {}

        while priority_queue:
            dist_u, u = heapq.heappop(priority_queue)

            if dist_u > distances[u]:
                continue

            shortest_paths[u] = dist_u

            for v, w in self.graph[u]:
                if distances[u] + w < distances[v]:
                    distances[v] = distances[u] + w
                    heapq.heappush(priority_queue, (distances[v], v))

        # Create a dictionary with shortest paths to other nodes
        result = {}
        for i, distance in enumerate(distances):
            if i != source and distance != float('inf'):
                result[i] = distance

        return result
