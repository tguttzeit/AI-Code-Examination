class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        while queue:
            vertex = queue.pop(0)
            print(vertex, end=" ")
            for i in self.adjacency_list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True

    def add_edge(self, start_vertex, end_vertex):
        self.adjacency_list[start_vertex].append(end_vertex)
        self.adjacency_list[end_vertex].append(start_vertex)
