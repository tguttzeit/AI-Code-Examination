class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # A dictionary to represent the graph
        self.visited = set()  # A set to keep track of visited nodes

    def add_edge(self, source, destination):
        # Add an edge to the graph
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited_nodes = []  # List to store visited nodes
        self._dfs_recursive(start_node, visited_nodes)
        return visited_nodes

    def _dfs_recursive(self, node, visited_nodes):
        # Helper function for DFS traversal
        visited_nodes.append(node)
        self.visited.add(node)

        if node in self.graph:
            for neighbor in self.graph[node]:
                if neighbor not in self.visited:
                    self._dfs_recursive(neighbor, visited_nodes)