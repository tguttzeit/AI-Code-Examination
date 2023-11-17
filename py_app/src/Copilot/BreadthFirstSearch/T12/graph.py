class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = []
        visited.append(vertex)
        queue.append(vertex)

        while queue:
            vertex = queue.pop(0)
            for i in self.adj[vertex]:
                if i not in visited:
                    visited.append(i)
                    queue.append(i)
        return visited

    def add_edge(self, vertex1, vertex2):
        self.adj[vertex1].append(vertex2)
        self.adj[vertex2].append(vertex1)
