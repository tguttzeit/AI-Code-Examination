class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]

        # Initialize diagonal elements to 0
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")
        
        self.graph[source][destination] = weight

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        if self.graph[source][destination] == float('inf'):
            return []

        path = [source]
        while source != destination:
            for next_node in range(self.nodes):
                if (
                    self.graph[source][destination] == self.graph[source][next_node] + self.graph[next_node][destination]
                    and source != next_node
                ):
                    source = next_node
                    path.append(source)
                    break

        return path
