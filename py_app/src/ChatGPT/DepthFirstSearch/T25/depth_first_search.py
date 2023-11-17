class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # Initialize an empty graph

    def add_edge(self, source, destination):
        # Add an edge from source to destination
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited = []  # List to keep track of visited nodes
        stack = [start_node]  # Initialize a stack with the start node

        while stack:
            node = stack.pop()  # Pop the last node from the stack
            if node not in visited:
                visited.append(node)  # Mark the node as visited

                # Push unvisited neighbors onto the stack
                if node in self.graph:
                    for neighbor in self.graph[node]:
                        if neighbor not in visited:
                            stack.append(neighbor)

        return visited
