class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_matrix = [[0 for i in range(vertices)] for j in range(vertices)]
        self.visited = [False for i in range(vertices)]
        self.queue = []

    def bfs(self, start_vertex):
        self.queue.append(start_vertex)
        self.visited[start_vertex] = True

        while self.queue:
            start_vertex = self.queue.pop(0)
            print(start_vertex, end=" ")

            for i in range(self.vertices):
                if self.adjacency_matrix[start_vertex][i] == 1 and self.visited[i] == False:
                    self.queue.append(i)
                    self.visited[i] = True

    def add_edge(self, v1, v2):
        self.adjacency_matrix[v1][v2] = 1
        self.adjacency_matrix[v2][v1] = 1
