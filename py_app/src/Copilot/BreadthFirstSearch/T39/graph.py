class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = [vertex]
        visited[vertex] = True
        while len(queue) > 0:
            current_vertex = queue.pop(0)
            for adjacent_vertex in self.adjacency_list[current_vertex]:
                if not visited[adjacent_vertex]:
                    queue.append(adjacent_vertex)
                    visited[adjacent_vertex] = True
        return visited

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)
