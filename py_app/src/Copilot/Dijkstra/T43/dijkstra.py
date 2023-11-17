class Dijkstra:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def print_solution(self, dist):
        print("Vertex \tDistance from Source")
        for node in range(self.V):
            print(node, "\t", dist[node])

    def min_distance(self, dist, spt_set):
        min = float("inf")
        for v in range(self.V):
            if dist[v] < min and spt_set[v] == False:
                min = dist[v]
                min_index = v
        return min_index

    def dijkstra(self, source):
        dist = [float("inf")] * self.V
        dist[source] = 0
        spt_set = [False] * self.V
        for cout in range(self.V):
            u = self.min_distance(dist, spt_set)
            spt_set[u] = True
            for v in range(self.V):
                if self.graph[u][v] > 0 and \
                        spt_set[v] == False and \
                        dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        self.print_solution(dist)

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        dist = [float("inf")] * self.V
        dist[source] = 0
        spt_set = [False] * self.V
        for cout in range(self.V):
            u = self.min_distance(dist, spt_set)
            spt_set[u] = True
            for v in range(self.V):
                if self.graph[u][v] > 0 and \
                        spt_set[v] == False and \
                        dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        shortest_paths = {}
        for node in range(self.V):
            if dist[node] != float("inf"):
                shortest_paths[node] = dist[node]
        return shortest_paths