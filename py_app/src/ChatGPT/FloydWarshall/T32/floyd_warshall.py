class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
    
    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")
        self.graph[source][destination] = weight
    
    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid node index")
        
        dist = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        next_node = [[None] * self.nodes for _ in range(self.nodes)]
        
        # Initialize the distance matrix and next_node matrix with the given graph
        for i in range(self.nodes):
            for j in range(self.nodes):
                dist[i][j] = self.graph[i][j]
                if i != j and self.graph[i][j] != float('inf'):
                    next_node[i][j] = j
        
        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][j] > dist[i][k] + dist[k][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
                        next_node[i][j] = next_node[i][k]
        
        # Reconstruct the shortest path
        path = []
        while source != destination and next_node[source][destination] is not None:
            path.append(source)
            source = next_node[source][destination]
        if source == destination:
            path.append(source)
        else:
            path = []  # No path exists
        
        return path
    
    def run(self):
        # Floyd-Warshall algorithm to find all shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    self.graph[i][j] = min(self.graph[i][j], self.graph[i][k] + self.graph[k][j])
