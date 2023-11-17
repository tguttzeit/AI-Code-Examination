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
            for i in self.adjacency_list[vertex]:
                if visited[i] is False:
                    visited[i] = True
                    queue.append(i)
        return visited

    def add_edge(self, src, dest):
        self.adjacency_list[src].append(dest)
        self.adjacency_list[dest].append(src)
