class DepthFirstSearch:
    def __init__(self):
        self.graph = {}

    def add_edge(self, source, destination):
        if source in self.graph:
            self.graph[source].append(destination)
        else:
            self.graph[source] = [destination]

    def dfs(self, start_node):
        visited = []
        stack = [start_node]

        while stack:
            node = stack.pop()
            if node not in visited:
                visited.append(node)
                if node in self.graph:
                    stack.extend(self.graph[node])

        return visited
   
