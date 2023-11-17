class DepthFirstSearch:

    def __init__(self):
        self.graph = {}

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append(destination)

    def dfs(self, start_node):
        visited, stack = [], [start_node]
        while stack:
            vertex = stack.pop()
            if vertex not in visited:
                visited.append(vertex)
                if vertex in self.graph:
                    for neighbour in self.graph[vertex]:
                        stack.append(neighbour)
        return visited