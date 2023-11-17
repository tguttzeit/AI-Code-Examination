class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.adj = [[float("inf") for j in range(self.nodes)] for i in range(self.nodes)]
        for i in range(self.nodes):
            self.adj[i][i] = 0
    def add_edge(self, source, destination, weight):
        self.adj[source][destination] = weight
    def path(self, source, destination):
        if self.adj[source][destination] == float("inf"):
            return []
        else:
            return [source, destination]
    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    self.adj[i][j] = min(self.adj[i][j], self.adj[i][k] + self.adj[k][j])
        return self.adj