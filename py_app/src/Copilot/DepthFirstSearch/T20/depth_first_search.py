class DepthFirstSearch:
    def __init__(self):
        self.graph = {}
        self.visited = []
        self.stack = []

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append(destination)

    def dfs(self, start_node):
        self.visited.append(start_node)
        self.stack.append(start_node)
        while len(self.stack) != 0:
            current_node = self.stack.pop()
            for neighbor in self.graph[current_node]:
                if neighbor not in self.visited:
                    self.visited.append(neighbor)
                    self.stack.append(neighbor)
        return self.visited
