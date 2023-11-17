class Dijkstra:

    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        shortest_paths = {}
        for i in range(self.vertices):
            shortest_paths[i] = distance[i]
        visited = [False] * self.vertices
        for _ in range(self.vertices):
            u = self.min_distance(distance, visited)
            visited[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and visited[v] is False and distance[v] > distance[u] + self.graph[u][v]:
                    distance[v] = distance[u] + self.graph[u][v]
                    shortest_paths[v] = distance[v]
        for i in range(self.vertices):
            if shortest_paths[i] == float("inf"):
                shortest_paths.pop(i)
        return shortest_paths

    def min_distance(self, distance, visited):
        min = float("inf")
        for v in range(self.vertices):
            if distance[v] < min and visited[v] is False:
                min = distance[v]
                min_index = v
        return min_index
