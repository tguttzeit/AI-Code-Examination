class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.num_of_nodes = num_of_nodes
        self.adjacency_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        visited = [False] * self.num_of_nodes
        traversal = []
        self.dfs_recursive(start_node, visited, traversal)
        return traversal

    def dfs_recursive(self, current_node, visited, traversal):
        traversal.append(current_node)
        visited[current_node] = True
        for node in self.adjacency_list[current_node]:
            if not visited[node]:
                self.dfs_recursive(node, visited, traversal)


