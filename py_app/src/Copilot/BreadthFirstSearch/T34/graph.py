class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj = [[] for i in range(vertices)]

    def add_edge(self, u, v):
        self.adj[u].append(v)

    def bfs(self, s):
        visited = [False] * self.vertices
        queue = []
        queue.append(s)
        visited[s] = True
        while queue:
            s = queue.pop(0)
            print(s, end=" ")
            for i in self.adj[s]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
