class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = [vertex]

        while queue:
            current = queue.pop(0)
            if current not in visited:
                visited.append(current)
                for i in self.adjacency_list[current]:
                    queue.append(i)
        return visited

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)
