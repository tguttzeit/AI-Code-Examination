class DepthFirstSearch:
    def __init__(self):
        self.graph = {}
        self.visited = []

    def add_edge(self, source, destination):
        # TODO
        if source not in self.graph:
            self.graph[source] = [destination]
        else:
            self.graph[source].append(destination)

        if destination not in self.graph:
            self.graph[destination] = [source]
        else:
            self.graph[destination].append(source)

    def dfs(self, start_node):
        # TODO
        self.visited.append(start_node)
        for i in self.graph[start_node]:
            if i not in self.visited:
                self.dfs(i)
        return self.visited