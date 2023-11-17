class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        shortest_path = dict()
        for _ in range(self.vertices):
            u = self.min_distance(distance)
            shortest_path[u] = distance[u]
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and v not in shortest_path and distance[v] > distance[u] + self.graph[u][v]:
                    distance[v] = distance[u] + self.graph[u][v]
        return shortest_path

    def min_distance(self, distance):
        min_value = float("inf")
        min_index = -1
        for v in range(self.vertices):
            if distance[v] < min_value:
                min_value = distance[v]
                min_index = v
        return min_index