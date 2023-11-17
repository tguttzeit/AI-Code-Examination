class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        bfs_list = []
        while queue:
            vertex = queue.pop(0)
            bfs_list.append(vertex)
            for i in self.adj[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
        return bfs_list

    def add_edge(self, vertex1, vertex2):
        self.adj[vertex1].append(vertex2)
        self.adj[vertex2].append(vertex1)
