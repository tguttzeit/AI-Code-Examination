class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.num_of_nodes = num_of_nodes
        self.adj_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adj_list[source].append(destination)

    def dfs(self, start_node):
        visited = [False] * self.num_of_nodes
        stack = [start_node]
        result = []
        while len(stack) > 0:
            node = stack.pop()
            if not visited[node]:
                result.append(node)
                visited[node] = True
                for neighbor in self.adj_list[node]:
                    stack.append(neighbor)
        return result