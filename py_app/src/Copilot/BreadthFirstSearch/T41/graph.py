class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = [vertex]
        while queue:
            vertex = queue.pop(0)
            if vertex not in visited:
                visited.append(vertex)
                for neighbor in self.adjacency_list[vertex]:
                    queue.append(neighbor)
        return visited

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)
