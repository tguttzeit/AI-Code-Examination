class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = []

        visited.append(vertex)
        queue.append(vertex)

        while queue:
            s = queue.pop(0)

            for i in self.adj_list[s]:
                if i not in visited:
                    visited.append(i)
                    queue.append(i)

        return visited

    def add_edge(self, vertex1, vertex2):
        self.adj_list[vertex1].append(vertex2)
        self.adj_list[vertex2].append(vertex1)
