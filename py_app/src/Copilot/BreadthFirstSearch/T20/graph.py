class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for i in range(vertices)]

    def add_edge(self, src, dest):
        self.adj_list[src].append(dest)
        self.adj_list[dest].append(src)

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        while queue:
            vertex = queue.pop(0)
            for i in self.adj_list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
        return visited
