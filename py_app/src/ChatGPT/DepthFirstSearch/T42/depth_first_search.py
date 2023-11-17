class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # A dictionary to represent the graph

    def add_edge(self, source, destination):
        # Add an edge to the graph
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited = []  # List to keep track of visited nodes
        stack = []    # Stack for DFS traversal

        # Helper function for recursive DFS
        def dfs_recursive(node):
            visited.append(node)  # Mark the current node as visited
            if node in self.graph:
                for neighbor in self.graph[node]:
                    if neighbor not in visited:
                        dfs_recursive(neighbor)

        # Check if the start_node exists in the graph
        if start_node not in self.graph:
            return visited

        # Start DFS from the given start_node using recursion
        dfs_recursive(start_node)
        return visited
