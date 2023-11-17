class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.inf = float('inf')
        self.distances = [[self.inf] * nodes for _ in range(nodes)]
        self.next_node = [[-1] * nodes for _ in range(nodes)]

    def add_edge(self, source, destination, weight):
        # Update the distance and next_node matrices with the edge information
        self.distances[source][destination] = weight
        self.next_node[source][destination] = destination

    def run(self):
        # Initialize distances to the direct edge weights and next_node to the destination
        for i in range(self.nodes):
            self.distances[i][i] = 0
            for j in range(self.nodes):
                if self.distances[i][j] != self.inf:
                    self.next_node[i][j] = j

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distances[i][j] > self.distances[i][k] + self.distances[k][j]:
                        self.distances[i][j] = self.distances[i][k] + self.distances[k][j]
                        self.next_node[i][j] = self.next_node[i][k]

    def path(self, source, destination):
        # Check if there is no path from source to destination
        if self.distances[source][destination] == self.inf:
            return []

        # Reconstruct the shortest path
        path = [source]
        while source != destination:
            source = self.next_node[source][destination]
            path.append(source)
        
        return path
