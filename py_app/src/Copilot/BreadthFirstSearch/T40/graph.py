class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(vertices)]

    def bfs(self, vertex):
        visited = []
        queue = [vertex]

        while queue:
            v = queue.pop(0)
            if v not in visited:
                visited.append(v)
                queue.extend(self.adjacency_list[v])
        return visited

    def add_edge(self, src, dst):
        self.adjacency_list[src].append(dst)
        self.adjacency_list[dst].append(src)
