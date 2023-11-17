class DepthFirstSearch:

    def __init__(self):
        self.graph = {}

    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []

        self.graph[source].append(destination)

    def dfs(self, start_node):
        visited = []
        stack = []

        stack.append(start_node)

        while stack:
            node = stack.pop()
            if node not in visited:
                visited.append(node)

                if node not in self.graph:
                    continue

                for neighbour in self.graph[node]:
                    stack.append(neighbour)

        return visited
