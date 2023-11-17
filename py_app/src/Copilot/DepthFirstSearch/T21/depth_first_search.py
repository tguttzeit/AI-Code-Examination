class DepthFirstSearch:
    def __init__(self):
        self.graph = {}
        self.visited = []

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append(destination)

    def dfs(self, start_node):
        self.visited.append(start_node)
        if start_node in self.graph:
            for node in self.graph[start_node]:
                if node not in self.visited:
                    self.dfs(node)
        return self.visited