class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0
    
    def add_edge(self, source, destination, weight):
        # Check for valid nodes
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")
        
        # Add the edge with the given weight
        self.graph[source][destination] = weight
    
    def path(self, source, destination):
        # Check for valid nodes
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")
        
        # Initialize the shortest path matrix
        dist = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        for i in range(self.nodes):
            for j in range(self.nodes):
                dist[i][j] = self.graph[i][j]
        
        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        
        # Check if there is a path from source to destination
        if dist[source][destination] == float('inf'):
            return []  # No path exists
        else:
            # Reconstruct the shortest path
            path = [source]
            while source != destination:
                for neighbor in range(self.nodes):
                    if dist[source][destination] == dist[source][neighbor] + self.graph[neighbor][destination]:
                        path.append(neighbor)
                        source = neighbor
                        break
            return path
    
    def run(self):
        # Floyd-Warshall algorithm to compute all-pairs shortest paths
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
