class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # A dictionary to represent the graph
        self.visited = []  # A list to keep track of visited nodes

    def add_edge(self, source, destination):
        # Add an edge to the graph
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append(destination)

    def dfs(self, start_node):
        # Initialize visited list for each DFS call
        self.visited = []
        
        # Call the recursive DFS function starting from the given node
        self._dfs_recursive(start_node)
        
        return self.visited

    def _dfs_recursive(self, node):
        # Mark the current node as visited
        self.visited.append(node)

        # Recur for all adjacent vertices that have not been visited
        if node in self.graph:
            for neighbor in self.graph[node]:
                if neighbor not in self.visited:
                    self._dfs_recursive(neighbor)
