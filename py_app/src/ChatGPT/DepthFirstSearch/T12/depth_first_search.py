class DepthFirstSearch:
    def __init__(self):
        self.graph = {}
    
    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append(destination)
    
    def dfs(self, start_node):
        visited = set()
        result = []

        def dfs_recursive(node):
            visited.add(node)
            result.append(node)
            if node in self.graph:
                for neighbor in self.graph[node]:
                    if neighbor not in visited:
                        dfs_recursive(neighbor)

        if start_node in self.graph:
            dfs_recursive(start_node)

        return result

