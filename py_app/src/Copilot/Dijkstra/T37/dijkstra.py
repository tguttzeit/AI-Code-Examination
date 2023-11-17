class Dijkstra:
    def __init__(self, vertices):
        # write your code here
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        # write your code here
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        # write your code here
        visited = [False] * self.vertices
        dist = [float('inf')] * self.vertices
        dist[source] = 0
        for _ in range(self.vertices):
            min_dist = float('inf')
            for v in range(self.vertices):
                if not visited[v] and dist[v] <= min_dist:
                    min_dist = dist[v]
                    min_index = v
            u = min_index
            visited[u] = True
            for v in range(self.vertices):
                if not visited[v] and self.graph[u][v] != 0 and dist[u] != float('inf') and dist[u] + self.graph[u][v] < dist[v]:
                    dist[v] = dist[u] + self.graph[u][v]
        result = {}
        for i in range(self.vertices):
            if dist[i] != float('inf'):
                result[i] = dist[i]
        return result
