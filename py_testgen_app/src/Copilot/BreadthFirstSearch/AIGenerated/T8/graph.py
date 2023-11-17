class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []
        for i in range(vertices):
            self.edges.append([])

    def bfs(self, vertex):
        visited = []
        queue = []
        queue.append(vertex)
        visited.append(vertex)
        while queue:
            current = queue.pop(0)
            for i in self.edges[current]:
                if i not in visited:
                    queue.append(i)
                    visited.append(i)
        return visited

    def add_edge(self, vertex1, vertex2):
        self.edges[vertex1].append(vertex2)
        self.edges[vertex2].append(vertex1)
