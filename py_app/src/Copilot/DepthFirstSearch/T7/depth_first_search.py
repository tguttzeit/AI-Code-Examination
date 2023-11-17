class DepthFirstSearch:
    def __init__(self):
        self.adjacency_list = {}
        self.visited = []
        self.stack = []

    def add_edge(self, source, destination):
        if source not in self.adjacency_list:
            self.adjacency_list[source] = [destination]
        else:
            if destination not in self.adjacency_list[source]:
                self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        self.visited.append(start_node)
        self.stack.append(start_node)

        while len(self.stack) > 0:
            node = self.stack.pop()
            for neighbour in self.adjacency_list[node]:
                if neighbour not in self.visited:
                    self.visited.append(neighbour)
                    self.stack.append(neighbour)

        return self.visited