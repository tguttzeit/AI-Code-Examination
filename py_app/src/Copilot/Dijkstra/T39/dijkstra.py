class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]
        self.distances = [float("inf")] * vertices
        self.visited = [False] * vertices

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def find_shortest_paths(self, source):
        self.distances[source] = 0
        for count in range(self.vertices):
            min_distance = self.min_distance()
            self.visited[min_distance] = True
            for vertex in range(self.vertices):
                if self.graph[min_distance][vertex] > 0 and not self.visited[vertex] and self.distances[vertex] > self.distances[min_distance] + self.graph[min_distance][vertex]:
                    self.distances[vertex] = self.distances[min_distance] + self.graph[min_distance][vertex]
        return self.distances

    def min_distance(self):
        min_distance = float("inf")
        for vertex in range(self.vertices):
            if self.distances[vertex] < min_distance and not self.visited[vertex]:
                min_distance = self.distances[vertex]
                min_distance_index = vertex
        return min_distance_index