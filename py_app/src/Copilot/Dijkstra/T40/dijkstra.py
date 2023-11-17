class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)]
                        for row in range(vertices)]

    def minDistance(self, dist, sptSet):
        min = 999999
        for v in range(self.vertices):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v
        return min_index

    def dijkstra(self, src):
        dist = [999999] * self.vertices
        dist[src] = 0
        sptSet = [False] * self.vertices

        for cout in range(self.vertices):
            u = self.minDistance(dist, sptSet)
            sptSet[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and sptSet[v] == False and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        return dist

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def find_shortest_paths(self, src):
        return self.dijkstra(src)