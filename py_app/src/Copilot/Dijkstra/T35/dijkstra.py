class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def min_distance(self, dist, shortest_path):
        min = float("inf")
        for v in range(self.vertices):
            if dist[v] < min and shortest_path[v] == False:
                min = dist[v]
                min_index = v
        return min_index

    def find_shortest_paths(self, source):
        dist = [float("inf")] * self.vertices
        dist[source] = 0
        shortest_path = [False] * self.vertices
        for _ in range(self.vertices):
            u = self.min_distance(dist, shortest_path)
            shortest_path[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and shortest_path[v] == False and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        return dist