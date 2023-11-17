class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def add_edge(self, src, dest):
        self.adjacency_list[src].append(dest)
        self.adjacency_list[dest].append(src)

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        while queue:
            vertex = queue.pop(0)
            print(vertex, end=' ')
            for i in self.adjacency_list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
