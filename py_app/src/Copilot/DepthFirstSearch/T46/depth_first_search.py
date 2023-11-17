class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.adjacency_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        visited = []
        stack = [start_node]
        while stack:
            node = stack.pop()
            if node not in visited:
                visited.append(node)
                for neighbor in self.adjacency_list[node]:
                    stack.append(neighbor)
        return visited