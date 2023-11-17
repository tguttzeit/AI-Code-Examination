class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = []
        queue.append(vertex)
        while queue:
            current = queue.pop(0)
            if current not in visited:
                visited.append(current)
                for i in self.edges[current]:
                    queue.append(i)
        return visited

    def add_edge(self, vertex1, vertex2):
        self.edges[vertex1].append(vertex2)
        self.edges[vertex2].append(vertex1)
