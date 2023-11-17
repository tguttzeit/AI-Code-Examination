class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        visited = [False] * self.vertices
        for _ in range(self.vertices):
            u = self._min_distance(distance, visited)
            visited[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and not visited[v] and distance[v] > distance[u] + self.graph[u][v]:
                    distance[v] = distance[u] + self.graph[u][v]
        result = {}
        for i in range(self.vertices):
            if i != source:
                if distance[i] == float("inf"):
                    continue
                result[i] = distance[i]
        return result

    def _min_distance(self, distance, visited):
        min = float("inf")
        min_index = -1
        for v in range(self.vertices):
            if distance[v] < min and not visited[v]:
                min = distance[v]
                min_index = v
        return min_index