class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for _ in range(self.vertices)] for _ in range(self.vertices)]
        self.visited = [False for _ in range(self.vertices)]
        self.distance = [float('inf') for _ in range(self.vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        self.distance[source] = 0

        for _ in range(self.vertices):
            min_distance = float('inf')
            min_vertex = None

            for vertex in range(self.vertices):
                if not self.visited[vertex] and self.distance[vertex] < min_distance:
                    min_distance = self.distance[vertex]
                    min_vertex = vertex

            self.visited[min_vertex] = True

            for vertex in range(self.vertices):
                if self.graph[min_vertex][vertex] > 0 and not self.visited[vertex] and self.distance[vertex] > self.distance[min_vertex] + self.graph[min_vertex][vertex]:
                    self.distance[vertex] = self.distance[min_vertex] + self.graph[min_vertex][vertex]

        result = {}

        for vertex in range(self.vertices):
            if vertex != source:
                result[vertex] = self.distance[vertex] if self.distance[vertex] != float('inf') else None

        return result