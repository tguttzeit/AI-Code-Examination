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
        if start_node in self.adjacency_list:
            for i in self.adjacency_list[start_node]:
                if i not in self.visited:
                    self.dfs(i)
        return self.visited