class DepthFirstSearch:
    def __init__(self, num_nodes):
        self.adjacency_list = [[] for _ in range(num_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)
        self.adjacency_list[destination].append(source)

    def dfs(self, start_node):
        visited = []
        stack = [start_node]

        while stack:
            current_node = stack.pop()
            visited.append(current_node)
            for adjacent_node in self.adjacency_list[current_node]:
                if adjacent_node not in visited:
                    stack.append(adjacent_node)

        return visited