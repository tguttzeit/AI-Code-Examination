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
            print(vertex, end=" ")
            for i in self.adj[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True

    def add_edge(self, vertex, edge):
        self.adj[vertex].append(edge)
