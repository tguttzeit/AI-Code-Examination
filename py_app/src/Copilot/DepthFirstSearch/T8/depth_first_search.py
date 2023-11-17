class DepthFirstSearch:
    def __init__(self):
        self.adjacency_list = {}

    def add_edge(self, source, destination):
        if source not in self.adjacency_list:
            self.adjacency_list[source] = []
        if destination not in self.adjacency_list:
            self.adjacency_list[destination] = []

        self.adjacency_list[source].append(destination)
        self.adjacency_list[destination].append(source)

    def dfs(self, start_node):
        visited = []
        stack = [start_node]

        while stack:
            node = stack.pop()
            if node not in visited:
                visited.append(node)
                for neighbor in self.adjacency_list[node]:
                    stack.append(neighbor)

        return visited