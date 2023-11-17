class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distances = [float("inf")] * self.vertices
        distances[source] = 0
        visited = [False] * self.vertices
        for _ in range(self.vertices):
            min_distance = float("inf")
            min_distance_index = -1
            for vertex in range(self.vertices):
                if distances[vertex] < min_distance and not visited[vertex]:
                    min_distance = distances[vertex]
                    min_distance_index = vertex
            visited[min_distance_index] = True
            for vertex in range(self.vertices):
                if self.graph[min_distance_index][vertex] > 0 and not visited[vertex] and distances[vertex] > distances[min_distance_index] + self.graph[min_distance_index][vertex]:
                    distances[vertex] = distances[min_distance_index] + self.graph[min_distance_index][vertex]
        paths = {}
        for vertex in range(self.vertices):
            if distances[vertex] != float("inf"):
                paths[vertex] = distances[vertex]
        return paths