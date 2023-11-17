class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = {}
        self.distance = {}
        for i in range(vertices):
            self.graph[i] = []
            self.distance[i] = float("inf")

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))

    def find_shortest_paths(self, source):
        visited = [False] * self.vertices
        self.distance[source] = 0
        for i in range(self.vertices):
            min_distance = float("inf")
            min_index = -1
            for j in range(self.vertices):
                if not visited[j] and self.distance[j] < min_distance:
                    min_distance = self.distance[j]
                    min_index = j
            visited[min_index] = True
            for (destination, weight) in self.graph[min_index]:
                if not visited[destination] and self.distance[min_index] + weight < self.distance[destination]:
                    self.distance[destination] = self.distance[min_index] + weight
        return self.distance