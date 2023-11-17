class DepthFirstSearch:
    def __init__(self):
        self.graph = {}
        self.visited = []

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = [destination]
        else:
            self.graph[source].append(destination)

    def dfs(self, start_node):
        if start_node not in self.graph:
            return []
        self.visited.append(start_node)
        for node in self.graph[start_node]:
            if node not in self.visited:
                self.dfs(node)
        return self.visited
