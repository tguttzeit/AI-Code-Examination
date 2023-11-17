class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]
        self.nodes = []

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def find_shortest_paths(self, source):
        visited = [False] * self.vertices
        distance = [float('inf')] * self.vertices
        distance[source] = 0
        for _ in range(self.vertices):
            u = self._min_distance(distance, visited)
            visited[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and not visited[v] and distance[v] > distance[u] + self.graph[u][v]:
                    distance[v] = distance[u] + self.graph[u][v]
        return {i: distance[i] for i in range(self.vertices) if distance[i] != float('inf')}

    def _min_distance(self, distance, visited):
        min = float('inf')
        for v in range(self.vertices):
            if distance[v] < min and not visited[v]:
                min = distance[v]
                min_index = v
        return min_index