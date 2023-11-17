class DepthFirstSearch:
    def __init__(self):
        self.graph = {}

    def add_edge(self, source, destination):
        # check if source is in graph
        if source not in self.graph:
            self.graph[source] = []

        # add destination to source list
        self.graph[source].append(destination)

    def dfs(self, start_node):
        # initialize visited list
        visited = []

        # call recursive dfs function
        self.dfs_recursive(start_node, visited)

        # return visited list
        return visited

    def dfs_recursive(self, node, visited):
        # mark node as visited
        visited.append(node)

        # check if node has neighbors
        if node in self.graph:
            # iterate through neighbors
            for neighbor in self.graph[node]:
                # check if neighbor has been visited
                if neighbor not in visited:
                    # recursively call dfs
                    self.dfs_recursive(neighbor, visited)
