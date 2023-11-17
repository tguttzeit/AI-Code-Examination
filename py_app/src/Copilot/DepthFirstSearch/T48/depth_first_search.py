class DepthFirstSearch:
    def __init__(self):
        self.adjacency_list = {}
        self.visited = []

    def add_edge(self, source, destination):
        if source in self.adjacency_list:
            self.adjacency_list[source].append(destination)
        else:
            self.adjacency_list[source] = [destination]

    def dfs(self, start_node):
        self.visited.append(start_node)
        for node in self.adjacency_list[start_node]:
            if node not in self.visited:
                self.dfs(node)
        return self.visited