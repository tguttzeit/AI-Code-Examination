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
            current_node = stack.pop()
            if current_node not in visited:
                visited.append(current_node)
                if current_node in self.adjacency_list:
                    for neighbour in self.adjacency_list[current_node]:
                        stack.append(neighbour)
        return visited