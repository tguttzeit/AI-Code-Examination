class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        shortest_path = [False] * self.vertices

        for _ in range(self.vertices):
            minimum_distance = float("inf")
            for vertex in range(self.vertices):
                if distance[vertex] < minimum_distance and not shortest_path[vertex]:
                    minimum_distance = distance[vertex]
                    minimum_distance_vertex = vertex

            shortest_path[minimum_distance_vertex] = True

            for vertex in range(self.vertices):
                if self.graph[minimum_distance_vertex][vertex] > 0 and not shortest_path[vertex] and distance[vertex] > distance[minimum_distance_vertex] + self.graph[minimum_distance_vertex][vertex]:
                    distance[vertex] = distance[minimum_distance_vertex] + self.graph[minimum_distance_vertex][vertex]

        return distance