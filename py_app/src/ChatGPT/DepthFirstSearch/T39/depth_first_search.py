class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # A dictionary to represent the graph
        self.visited = []  # List to track visited nodes

    def add_edge(self, source, destination):
        # Add an edge between the source and destination nodes
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        # Initialize the visited list for each DFS call
        self.visited = []

        # Call the recursive DFS function
        self._dfs_recursive(start_node)

        return self.visited

    def _dfs_recursive(self, node):
        # Mark the current node as visited
        self.visited.append(node)

        # Visit all adjacent nodes that have not been visited
        if node in self.graph:
            for neighbor in self.graph[node]:
                if neighbor not in self.visited:
                    self._dfs_recursive(neighbor)
