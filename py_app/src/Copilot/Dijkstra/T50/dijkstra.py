class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight
        self.edges.append([source, destination, weight])

    def find_shortest_paths(self, source):
        visited = [False] * self.vertices
        distance = [float('inf')] * self.vertices
        distance[source] = 0
        paths = {str(source): 0}
        for _ in range(self.vertices):
            min_distance = float('inf')
            for v in range(self.vertices):
                if not visited[v] and distance[v] < min_distance:
                    min_distance = distance[v]
                    u = v
            visited[u] = True
            for v in range(self.vertices):
                if not visited[v] and self.graph[u][v] != 0 and distance[v] > distance[u] + self.graph[u][v]:
                    distance[v] = distance[u] + self.graph[u][v]
                    paths[str(v)] = distance[v]
        return paths

    def find_shortest_path(self, source, destination):
        paths = self.find_shortest_paths(source)
        return paths[str(destination)]