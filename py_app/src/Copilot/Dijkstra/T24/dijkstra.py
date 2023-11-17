class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for i in range(self.vertices)]
                      for j in range(self.vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def min_distance(self, distance, visited):
        min = float('inf')
        for vertex in range(self.vertices):
            if distance[vertex] < min and visited[vertex] == False:
                min = distance[vertex]
                min_index = vertex
        return min_index

    def find_shortest_paths(self, source):
        distance = [float('inf')] * self.vertices
        distance[source] = 0
        visited = [False] * self.vertices
        for vertex in range(self.vertices):
            u = self.min_distance(distance, visited)