class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.inf = float('inf')
        self.graph = [[self.inf] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
    
    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight
    
    def path(self, source, destination):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            dist = [list(row) for row in self.graph]
            for k in range(self.nodes):
                for i in range(self.nodes):
                    for j in range(self.nodes):
                        if dist[i][k] + dist[k][j] < dist[i][j]:
                            dist[i][j] = dist[i][k] + dist[k][j]
            if dist[source][destination] == self.inf:
                return []
            path = [source]
            while source != destination:
                for i in range(self.nodes):
                    if dist[source][destination] == dist[source][i] + self.graph[i][destination]:
                        source = i
                        path.append(source)
                        break
            return path
        else:
            return []
    
    def run(self):
        dist = [list(row) for row in self.graph]
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        self.graph = dist
