class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        while queue:
            vertex = queue.pop(0)
            for i in self.adj[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
        return visited

    def add_edge(self, v1, v2):
        self.adj[v1].append(v2)
        self.adj[v2].append(v1)
