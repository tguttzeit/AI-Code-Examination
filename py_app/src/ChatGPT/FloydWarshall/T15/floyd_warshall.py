class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.constructed = False

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")
        
        self.graph[source][destination] = weight
        self.constructed = False

    def path(self, source, destination):
        if not self.constructed:
            self.run()

        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node indices")

        if self.graph[source][destination] == float('inf'):
            return []

        path = [source]
        while source != destination:
            source = self.next_node[source][destination]
            path.append(source)

        return path

    def run(self):
        self.next_node = [[-1] * self.nodes for _ in range(self.nodes)]

        for i in range(self.nodes):
            for j in range(self.nodes):
                if i == j:
                    continue
                self.next_node[i][j] = j if self.graph[i][j] != float('inf') else -1

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next_node[i][j] = self.next_node[i][k]

        self.constructed = True
