class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(self.vertices)]

    def bfs(self, vertex):
        queue = [vertex]
        visited = [False for _ in range(self.vertices)]
        visited[vertex] = True
        result = [vertex]
        while queue:
            current = queue.pop(0)
            for neighbor in self.adjacency_list[current]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    result.append(neighbor)
                    queue.append(neighbor)
        return result

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)
