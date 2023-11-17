class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for i in range(self.vertices)]

    def add_edge(self, u, v):
        self.adj_list[u].append(v)

    def bfs(self, vertex):
        queue = []
        visited = [False for i in range(self.vertices)]
        queue.append(vertex)
        visited[vertex] = True
        bfs_list = []
        while queue:
            vertex = queue.pop(0)
            bfs_list.append(vertex)
            for i in self.adj_list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
        return bfs_list
