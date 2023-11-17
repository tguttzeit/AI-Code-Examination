class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0] * vertices for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        dist = [float('inf')] * self.vertices
        dist[source] = 0
        visited = [False] * self.vertices

        for _ in range(self.vertices):
            min_dist = float('inf')
            min_index = -1
            for i in range(self.vertices):
                if not visited[i] and dist[i] < min_dist:
                    min_dist = dist[i]
                    min_index = i

            visited[min_index] = True

            for i in range(self.vertices):
                if not visited[i] and self.graph[min_index][i] != 0 and dist[i] > dist[min_index] + self.graph[min_index][i]:
                    dist[i] = dist[min_index] + self.graph[min_index][i]

        result = {}
        for i in range(self.vertices):
            if i != source and dist[i] != float('inf'):
                result[i] = dist[i]

        return result