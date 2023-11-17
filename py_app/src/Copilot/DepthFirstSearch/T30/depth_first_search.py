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
        for neighbour in self.graph[start_node]:
            if neighbour not in self.visited:
                self.dfs(neighbour)
        return self.visited