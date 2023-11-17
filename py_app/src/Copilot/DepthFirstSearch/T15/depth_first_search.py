class DepthFirstSearch:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        visited = [False] * self.vertices
        stack = []
        stack.append(start_node)
        visited[start_node] = True
        result = []

        while stack:
            current_node = stack.pop()
            result.append(current_node)

            for adjacent in self.adjacency_list[current_node]:
                if not visited[adjacent]:
                    stack.append(adjacent)
                    visited[adjacent] = True

        return result