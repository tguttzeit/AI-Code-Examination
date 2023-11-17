class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # A dictionary to represent the graph

    def add_edge(self, source, destination):
        # Add an edge from source to destination
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited = []  # List to store visited nodes
        stack = [start_node]  # Stack to keep track of nodes to visit

        while stack:
            node = stack.pop()  # Get the current node from the stack

            if node not in visited:
                visited.append(node)  # Mark the node as visited

                if node in self.graph:
                    # Push unvisited neighbors onto the stack
                    for neighbor in self.graph[node]:
                        if neighbor not in visited:
                            stack.append(neighbor)

        return visited

