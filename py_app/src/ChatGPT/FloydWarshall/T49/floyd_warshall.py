class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        self.next = [[None] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
    
    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")
        
        self.graph[source][destination] = weight
        self.next[source][destination] = destination
    
    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")
        
        if self.graph[source][destination] == float('inf'):
            return []
        
        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        
        return path
    
    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][j] > self.graph[i][k] + self.graph[k][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
                        self.next[i][j] = self.next[i][k]
