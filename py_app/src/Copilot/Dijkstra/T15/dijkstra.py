class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def find_shortest_paths(self, source):
        visited = [False] * self.vertices
        distance = [float('inf')] * self.vertices
        distance[source] = 0

        for _ in range(self.vertices):
            min_distance = float('inf')
            min_index = 0
            for v in range(self.vertices):
                if distance[v] < min_distance and not visited[v]:
                    min_distance = distance[v]
                    min_index = v
            visited[min_index] = True
            for v in range(self.vertices):
                if self.graph[min_index][v] > 0 and not visited[v] and distance[v] > distance[min_index] + self.graph[min_index][v]:
                    distance[v] = distance[min_index] + self.graph[min_index][v]

        result = {}
        for v in range(self.vertices):
            if distance[v] != float('inf'):
                result[v] = distance[v]
        return result
