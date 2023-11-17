class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            self.graph[source][destination] = weight

    def path(self, source, destination):
        if 0 <= source < self.nodes and 0 <= destination < self.nodes:
            if self.graph[source][destination] == float('inf'):
                return []
            
            path = [source]
            while source != destination:
                source = self.next_node[source][destination]
                path.append(source)
            return path

    def run(self):
        dist = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        self.next_node = [[None] * self.nodes for _ in range(self.nodes)]

        for i in range(self.nodes):
            for j in range(self.nodes):
                dist[i][j] = self.graph[i][j]
                if i != j and self.graph[i][j] != float('inf'):
                    self.next_node[i][j] = i

        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
                        self.next_node[i][j] = self.next_node[k][j]

        return dist
