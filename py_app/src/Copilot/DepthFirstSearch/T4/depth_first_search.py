class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.num_of_nodes = num_of_nodes
        self.adjacency_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        visited_nodes = []
        self.dfs_util(start_node, visited_nodes)
        return visited_nodes

    def dfs_util(self, current_node, visited_nodes):
        visited_nodes.append(current_node)
        for adjacent_node in self.adjacency_list[current_node]:
            if adjacent_node not in visited_nodes:
                self.dfs_util(adjacent_node, visited_nodes)
