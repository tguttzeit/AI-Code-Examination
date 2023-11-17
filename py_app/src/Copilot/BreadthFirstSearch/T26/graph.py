class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(self.vertices)]

    def bfs(self, vertex):
        bfs_list = []
        visited = [False] * self.vertices
        queue = []
        queue.append(vertex)
        visited[vertex] = True
        while queue:
            current = queue.pop(0)
            bfs_list.append(current)
            for i in self.adjacency_list[current]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
        return bfs_list

    def add_edge(self, src, dest):
        self.adjacency_list[src].append(dest)
        self.adjacency_list[dest].append(src)
