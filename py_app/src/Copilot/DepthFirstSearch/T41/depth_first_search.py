class DepthFirstSearch:
    # Constructor
    def __init__(self):
        self.graph = {}

    # Public method to add edge
    def add_edge(self, source, destination):
        if source not in self.graph:
            self.graph[source] = []
        if destination not in self.graph:
            self.graph[destination] = []
        self.graph[source].append(destination)
        self.graph[destination].append(source)

    # Public method to perform dfs
    def dfs(self, start_node):
        visited = []
        stack = [start_node]
        while stack:
            current_node = stack.pop()
            if current_node not in visited:
                visited.append(current_node)
                for adjacent_node in self.graph[current_node]:
                    stack.append(adjacent_node)
        return visited
