class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        dist = [float("Inf")] * self.vertices
        dist[source] = 0
        sptSet = [False] * self.vertices
        for cout in range(self.vertices):
            u = self.min_distance(dist, sptSet)
            sptSet[u] = True
            for v in range(self.vertices):
                if self.graph[u][v] > 0 and sptSet[v] == False and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        return self.print_solution(dist)

    def min_distance(self, dist, sptSet):
        min = float("Inf")
        for v in range(self.vertices):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v
        return min_index

    def print_solution(self, dist):
        dist_dict = {}
        for node in range(self.vertices):
            if dist[node] != float("Inf"):
                dist_dict[node] = dist[node]
        return dist_dict