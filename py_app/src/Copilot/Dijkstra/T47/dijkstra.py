class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distances = [float("inf")] * self.vertices
        distances[source] = 0
        shortest_paths = {}
        while len(shortest_paths) < self.vertices:
            min_distance = float("inf")
            min_vertex = None
            for vertex in range(self.vertices):
                if distances[vertex] < min_distance and vertex not in shortest_paths:
                    min_distance = distances[vertex]
                    min_vertex = vertex
            shortest_paths[min_vertex] = min_distance
            for vertex in range(self.vertices):
                if self.graph[min_vertex][vertex] != 0:
                    distances[vertex] = min(distances[vertex], distances[min_vertex] + self.graph[min_vertex][vertex])
        return shortest_paths