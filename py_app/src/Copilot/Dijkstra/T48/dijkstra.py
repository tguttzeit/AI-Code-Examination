class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append([destination, weight])

    def find_shortest_paths(self, source):
        dist = [float("inf") for _ in range(self.vertices)]
        dist[source] = 0
        visited = [False for _ in range(self.vertices)]
        for _ in range(self.vertices):
            u = self.find_min_dist(dist, visited)
            visited[u] = True
            for v, w in self.graph[u]:
                if not visited[v] and dist[u] + w < dist[v]:
                    dist[v] = dist[u] + w
        return dist

    def find_min_dist(self, dist, visited):
        min_dist = float("inf")
        min_index = -1
        for i in range(self.vertices):
            if not visited[i] and dist[i] < min_dist:
                min_dist = dist[i]
                min_index = i
        return min_index