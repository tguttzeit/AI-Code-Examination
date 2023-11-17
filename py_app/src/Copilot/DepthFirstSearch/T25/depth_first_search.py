class DepthFirstSearch:

    def __init__(self):
        self.graph = dict()

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append(destination)

    def dfs(self, start_node):
        visited = []
        stack = [start_node]
        while stack:
            node = stack.pop()
            if node not in visited:
                visited.append(node)
                if node in self.graph:
                    for neighbor in self.graph[node]:
                        stack.append(neighbor)
        return visited