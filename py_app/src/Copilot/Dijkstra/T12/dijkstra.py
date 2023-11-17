class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        shortest_path_tree = [False] * self.vertices

        for _ in range(self.vertices):
            min_distance = float("inf")
            for v in range(self.vertices):
                if distance[v] < min_distance and not shortest_path_tree[v]:
                    min_distance = distance[v]
                    min_index = v
            shortest_path_tree[min_index] = True

            for v in range(self.vertices):
                if self.graph[min_index][v] > 0 and not shortest_path_tree[v] and distance[v] > distance[min_index] + self.graph[min_index][v]:
                    distance[v] = distance[min_index] + self.graph[min_index][v]

        result = {}
        for v in range(self.vertices):
            if distance[v] != float("inf"):
                result[v] = distance[v]
        return result