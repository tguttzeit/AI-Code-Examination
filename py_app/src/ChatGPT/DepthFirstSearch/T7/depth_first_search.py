class DepthFirstSearch:
    def __init__(self):
        self.graph = {}

    def add_edge(self, source, destination):
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited = set()
        result = []

        def dfs_helper(node):
            visited.add(node)
            result.append(node)
            if node in self.graph:
                for neighbor in self.graph[node]:
                    if neighbor not in visited:
                        dfs_helper(neighbor)

        dfs_helper(start_node)
        return result
