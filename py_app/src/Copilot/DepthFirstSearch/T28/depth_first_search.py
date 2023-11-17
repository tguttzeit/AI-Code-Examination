class DepthFirstSearch:

    def __init__(self):
        self.adjacency_list = {}

    def add_edge(self, source, destination):
        if source in self.adjacency_list:
            self.adjacency_list[source].append(destination)
        else:
            self.adjacency_list[source] = [destination]

    def dfs(self, start_node):
        visited = []
        stack = [start_node]
        while stack:
            vertex = stack.pop()
            if vertex not in visited:
                visited.append(vertex)
                if vertex in self.adjacency_list:
                    for neighbor in self.adjacency_list[vertex]:
                        stack.append(neighbor)
        return visited