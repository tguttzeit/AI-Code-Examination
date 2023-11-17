class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0] * vertices for i in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight
        self.graph[destination][source] = weight

    def find_shortest_paths(self, source):
        distance = [float("inf")] * self.vertices
        distance[source] = 0
        sptSet = [False] * self.vertices
        for i in range(self.vertices):
            min_distance = float("inf")
            for j in range(self.vertices):
                if min_distance > distance[j] and sptSet[j] == False:
                    min_distance = distance[j]
                    min_index = j
            sptSet[min_index] = True
            for j in range(self.vertices):
                if self.graph[min_index][j] > 0 and sptSet[j] == False and distance[j] > distance[min_index] + self.graph[min_index][j]:
                    distance[j] = distance[min_index] + self.graph[min_index][j]
        result = {}
        for i in range(self.vertices):
            if i != source:
                if distance[i] != float("inf"):
                    result[i] = distance[i]
        return result