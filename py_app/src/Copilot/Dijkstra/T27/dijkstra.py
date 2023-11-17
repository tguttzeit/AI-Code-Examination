class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        visited = [False] * self.vertices
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        for vertex in range(self.vertices):
            u = self.min_distance(distance, visited)
            visited[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and not visited[v] and distance[u] + self.graph[u][v] < distance[v]:
                    distance[v] = distance[u] + self.graph[u][v]
        return distance

    def min_distance(self, distance, visited):
        min = float("inf")
        for vertex in range(self.vertices):
            if distance[vertex] < min and not visited[vertex]:
                min = distance[vertex]
                min_index = vertex
        return min_index