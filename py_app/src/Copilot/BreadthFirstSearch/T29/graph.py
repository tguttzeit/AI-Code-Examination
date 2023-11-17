class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = [vertex]
        while queue:
            vertex = queue.pop(0)
            if vertex not in visited:
                visited.append(vertex)
                queue.extend(self.edges[vertex])
        return visited

    def add_edge(self, vertex1, vertex2):
        self.edges[vertex1].append(vertex2)
        self.edges[vertex2].append(vertex1)
