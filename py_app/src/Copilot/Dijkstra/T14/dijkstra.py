class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]
        self.distance = [float("inf")] * vertices
        self.visited = [False] * vertices

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        self.distance[source] = 0
        for count in range(self.vertices):
            u = self.min_distance()
            self.visited[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and self.visited[v] == False and self.distance[v] > self.distance[u] + self.graph[u][v]:
                    self.distance[v] = self.distance[u] + self.graph[u][v]
        return self.distance

    def min_distance(self):
        min_dist = float("inf")
        for v in range(self.vertices):
            if self.distance[v] < min_dist and self.visited[v] == False:
                min_dist = self.distance[v]
                min_index = v
        return min_index