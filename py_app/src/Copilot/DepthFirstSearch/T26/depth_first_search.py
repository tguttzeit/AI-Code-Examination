class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.num_of_nodes = num_of_nodes
        self.adjacency_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        visited = [False] * self.num_of_nodes
        self.dfs_helper(start_node, visited)
        return visited

    def dfs_helper(self, start_node, visited):
        visited[start_node] = True
        for node in self.adjacency_list[start_node]:
            if not visited[node]:
                self.dfs_helper(node, visited)
