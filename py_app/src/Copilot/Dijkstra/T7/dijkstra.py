class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        dist = [float("inf")] * self.vertices
        dist[source] = 0
        sptSet = [False] * self.vertices

        for cout in range(self.vertices):
            u = self.min_distance(dist, sptSet)
            sptSet[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and sptSet[v] == False and dist[v] > dist[u] + \
                        self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        result = {}
        for node in range(self.vertices):
            if dist[node] == float("inf"):
                result[node] = None
            else:
                result[node] = dist[node]
        return result

    def min_distance(self, dist, sptSet):
        min = float("inf")
        min_index = None
        for v in range(self.vertices):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v
        return min_index