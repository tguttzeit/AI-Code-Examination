class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.next_node = [[-1] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")
        self.graph[source][destination] = weight
        self.next_node[source][destination] = destination

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next_node[i][j] = self.next_node[i][k]

    def path(self, source, destination):
        if (
            source < 0
            or source >= self.nodes
            or destination < 0
            or destination >= self.nodes
        ):
            raise ValueError("Invalid node indices")

        if self.graph[source][destination] == float("inf"):
            return []

        path = [source]
        while source != destination:
            source = self.next_node[source][destination]
            path.append(source)
        return path

