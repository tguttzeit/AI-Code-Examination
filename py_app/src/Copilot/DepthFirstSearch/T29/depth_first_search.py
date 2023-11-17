class DepthFirstSearch:
    def __init__(self, num_of_nodes):
        self.num_of_nodes = num_of_nodes
        self.adjacency_list = [[] for _ in range(num_of_nodes)]

    def add_edge(self, source, destination):
        self.adjacency_list[source].append(destination)

    def dfs(self, start_node):
        visited = [False for _ in range(self.num_of_nodes)]
        stack = [start_node]
        visited[start_node] = True
        result = []
        while len(stack) > 0:
            node = stack.pop()
            result.append(node)
            for n in self.adjacency_list[node]:
                if not visited[n]:
                    stack.append(n)
                    visited[n] = True
        return result