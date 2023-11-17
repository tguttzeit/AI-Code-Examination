class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        visited = [False] * self.vertices
        dist = [float("inf")] * self.vertices
        dist[source] = 0
        for _ in range(self.vertices):
            min_dist = float("inf")
            for vertex in range(self.vertices):
                if dist[vertex] < min_dist and visited[vertex] == False:
                    min_dist = dist[vertex]
                    min_vertex = vertex
            visited[min_vertex] = True
            for vertex in range(self.vertices):
                if self.graph[min_vertex][vertex] > 0 and visited[vertex] == False and dist[vertex] > dist[min_vertex] + self.graph[min_vertex][vertex]:
                    dist[vertex] = dist[min_vertex] + self.graph[min_vertex][vertex]
        paths = {}
        for vertex in range(self.vertices):
            if dist[vertex] != float("inf"):
                paths[vertex] = dist[vertex]
        return paths