class DepthFirstSearch:
    def __init__(self):
        self.graph = {}

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = [destination]
        else:
            if destination not in self.graph[source]:
                self.graph[source].append(destination)

    def dfs(self, start_node):
        visited = []
        stack = [start_node]
        while stack:
            current = stack.pop()
            if current not in visited:
                visited.append(current)
                stack.extend(self.graph[current][::-1])
        return visited
