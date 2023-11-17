class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # Initialize an empty dictionary to represent the graph
        self.visited = []  # Initialize an empty list to store visited nodes

    def add_edge(self, source, destination):
        # Check if the source node is already in the graph
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            # If the source node is not in the graph, add it along with the destination node
            self.graph[source] = [destination]

    def dfs(self, start_node):
        # Create a recursive function to perform DFS
        def dfs_recursive(node):
            # Mark the current node as visited
            self.visited.append(node)

            # Visit all adjacent nodes that haven't been visited yet
            if node in self.graph:
                for neighbor in self.graph[node]:
                    if neighbor not in self.visited:
                        dfs_recursive(neighbor)

        # Ensure that the start_node is in the graph before performing DFS
        if start_node in self.graph:
            # Clear the list of visited nodes
            self.visited = []
            # Start DFS from the specified node
            dfs_recursive(start_node)

        return self.visited
