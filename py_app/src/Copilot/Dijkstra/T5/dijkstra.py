class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        visited = [False] * self.vertices

        for _ in range(self.vertices):
            min_distance = float("inf")
            for vertex in range(self.vertices):
                if distance[vertex] < min_distance and not visited[vertex]:
                    min_distance = distance[vertex]
                    min_distance_vertex = vertex

            visited[min_distance_vertex] = True

            for vertex in range(self.vertices):
                if self.graph[min_distance_vertex][vertex] > 0 and not visited[vertex] and distance[vertex] > distance[min_distance_vertex] + self.graph[min_distance_vertex][vertex]:
                    distance[vertex] = distance[min_distance_vertex] + self.graph[min_distance_vertex][vertex]

        return distance