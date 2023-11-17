class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.num_of_nodes = num_of_nodes
        self.adjacency_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)
        self.adjacency_list[destination].append(source)

    def dfs(self, start_node):
        visited_nodes = []
        stack = [start_node]
        while stack:
            current_node = stack.pop()
            visited_nodes.append(current_node)
            for adjacent_node in self.adjacency_list[current_node]:
                if adjacent_node not in visited_nodes:
                    stack.append(adjacent_node)
        return visited_nodes
