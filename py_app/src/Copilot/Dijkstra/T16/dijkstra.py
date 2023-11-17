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
        for i in range(self.vertices):
            min_distance = float("inf")
            for j in range(self.vertices):
                if distance[j] < min_distance and visited[j] is False:
                    min_distance = distance[j]
                    min_index = j
            visited[min_index] = True
            for k in range(self.vertices):
                if self.graph[min_index][k] > 0 and visited[k] is False and distance[k] > distance[min_index] + self.graph[min_index][k]:
                    distance[k] = distance[min_index] + self.graph[min_index][k]

        output = {}
        for i in range(self.vertices):
            if i != source:
                output[i] = distance[i]
        return output