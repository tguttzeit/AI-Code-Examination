class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []
        for i in range(self.vertices):
            self.edges.append([])

    def bfs(self, vertex):
        visited = []
        queue = []
        queue.append(vertex)
        visited.append(vertex)
        while len(queue) > 0:
            s = queue.pop(0)
            for i in self.edges[s]:
                if i not in visited:
                    visited.append(i)
                    queue.append(i)
        return visited

    def add_edge(self, u, v):
        self.edges[u].append(v)
        self.edges[v].append(u)
