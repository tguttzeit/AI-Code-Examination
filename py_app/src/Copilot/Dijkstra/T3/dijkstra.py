class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def min_distance(self, distance, visited):
        min = float('inf')
        for v in range(self.vertices):
            if distance[v] < min and visited[v] == False:
                min = distance[v]
                min_index = v
        return min_index

    def find_shortest_paths(self, source):
        distance = [float('inf')] * self.vertices
        distance[source] = 0
        visited = [False] * self.vertices
        for _ in range(self.vertices):
            u = self.min_distance(distance, visited)