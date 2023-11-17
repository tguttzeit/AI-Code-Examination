class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight
        self.edges.append([source, destination, weight])

    def find_shortest_path(self, source):
        visited = [False] * self.vertices
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        for i in range(self.vertices):
            min_distance = float("inf")
            for j in range(self.vertices):
                if not visited[j] and distance[j] < min_distance:
                    min_distance = distance[j]
                    min_index = j
            visited[min_index] = True
            for k in range(self.vertices):
                if self.graph[min_index][k] > 0 and not visited[k] and distance[k] > distance[min_index] + self.graph[min_index][k]:
                    distance[k] = distance[min_index] + self.graph[min_index][k]
        return distance

    def find_shortest_paths(self, source):
        distance = self.find_shortest_path(source)
        result = {}
        for i in range(self.vertices):
            if distance[i] != float("inf"):
                result[i] = distance[i]
        return result