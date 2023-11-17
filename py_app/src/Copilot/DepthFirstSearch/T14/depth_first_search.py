class DepthFirstSearch:
    def __init__(self):
        self.adjacency_list = {}
        self.visited_nodes = []

    def add_edge(self, source, destination):
        if source not in self.adjacency_list:
            self.adjacency_list[source] = []
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        self.visited_nodes.append(start_node)
        if start_node not in self.adjacency_list:
            return self.visited_nodes
        for node in self.adjacency_list[start_node]:
            if node not in self.visited_nodes:
                self.dfs(node)
        return self.visited_nodes
