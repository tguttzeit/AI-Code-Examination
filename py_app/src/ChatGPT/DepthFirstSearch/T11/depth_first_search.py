class DepthFirstSearch:
    def __init__(self):
        self.graph = {}  # Initialize an empty graph as a dictionary.

    def add_edge(self, source, destination):
        # Add an edge between the source and destination nodes.
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited = []          # To store the visited nodes.
        stack = [start_node]  # Initialize a stack with the start_node.

        while stack:
            node = stack.pop()  # Pop the top node from the stack.
            if node not in visited:
                visited.append(node)
                # Add neighbors of the current node to the stack.
                if node in self.graph:
                    stack.extend(self.graph[node])

        return visited
