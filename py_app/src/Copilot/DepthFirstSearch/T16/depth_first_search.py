class DepthFirstSearch:
    def __init__(self):
        self.adjacency_list = {}
        self.visited = []

    def add_edge(self, source, destination):
        if source not in self.adjacency_list:
            self.adjacency_list[source] = []

        if destination not in self.adjacency_list:
            self.adjacency_list[destination] = []

        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        self.visited.append(start_node)

        for neighbour in self.adjacency_list[start_node]:
            if neighbour not in self.visited:
                self.dfs(neighbour)

        return self.visited