class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # Adjacency list representation of the graph
        self.visited = set()

    def add_edge(self, source, destination):
        # Add an edge to the graph
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        # Perform DFS starting from the given start_node
        self.visited.clear()  # Clear the visited set
        result = []  # List to store the visited nodes in DFS order
        self._dfs_recursive(start_node, result)
        return result

    def _dfs_recursive(self, node, result):
        # Helper function for recursive DFS traversal
        if node not in self.visited:
            result.append(node)
            self.visited.add(node)
            if node in self.graph:
                for neighbor in self.graph[node]:
                    self._dfs_recursive(neighbor, result)
