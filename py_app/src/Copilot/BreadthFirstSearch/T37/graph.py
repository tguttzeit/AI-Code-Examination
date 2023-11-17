class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = []
        queue.append(vertex)
        visited.append(vertex)
        while queue:
            node = queue.pop(0)
            for i in self.adjacency_list[node]:
                if i not in visited:
                    visited.append(i)
                    queue.append(i)
        return visited

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)
