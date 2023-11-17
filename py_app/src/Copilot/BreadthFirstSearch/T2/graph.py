class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = [vertex]
        while queue:
            node = queue.pop(0)
            if node not in visited:
                visited.append(node)
                for i in self.edges[node]:
                    queue.append(i)
        return visited

    def add_edge(self, v1, v2):
        self.edges[v1].append(v2)
        self.edges[v2].append(v1)
