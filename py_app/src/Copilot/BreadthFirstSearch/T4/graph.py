class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for i in range(vertices)]

    def add_edge(self, u, v):
        self.adj_list[u].append(v)
        self.adj_list[v].append(u)

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        while queue:
            vertex = queue.pop(0)
            print(vertex)
            for i in self.adj_list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True

