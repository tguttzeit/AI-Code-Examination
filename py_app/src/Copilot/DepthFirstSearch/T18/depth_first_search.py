class DepthFirstSearch:
    def __init__(self):
        self.adjacency_list = {}
        self.visited = []

    def add_edge(self, source, destination):
        if source not in self.adjacency_list:
            self.adjacency_list[source] = [destination]
        else:
            self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        self.visited.append(start_node)
        if start_node in self.adjacency_list:
            for node in self.adjacency_list[start_node]:
                if node not in self.visited:
                    self.dfs(node)
        return self.visited