# Source: https://www.geeksforgeeks.org/finding-shortest-path-between-any-two-nodes-using-floyd-warshall-algorithm/
class FloydWarshall:

    # CHANGE FOR EXPERIMENT: Added constructor to initialize the variables
    def __init__(self, nodes):
        self.MAX, self.INF = 100, 10 ** 7
        self.adjacent = [[-1 for i in range(nodes)] for i in range(nodes)]
        self.distance = [[-1 for i in range(nodes)] for i in range(nodes)]
        self.nodes = nodes
        self.graph = [[self.INF for i in range(nodes)] for i in range(nodes)]

    def initialise(self, nodes):
        for i in range(nodes):
            for j in range(nodes):
                self.distance[i][j] = self.graph[i][j]

                # No edge between node
                # i and j
                if self.graph[i][j] == self.INF:
                    self.adjacent[i][j] = -1
                else:
                    self.adjacent[i][j] = j

    # CHANGE FOR EXPERIMENT: Added method to add edges to the graph
    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    # Function construct the shortest
    # path between source and destination
    def path(self, source, destination):
        # If there's no path between
        # node u and v, simply return
        # an empty array
        if self.adjacent[source][destination] == -1:
            return []
        # Storing the path in a vector
        constructed_path = [source]
        while source != destination:
            source = self.adjacent[source][destination]
            constructed_path.append(source)

        return constructed_path

    # Standard Floyd Warshall Algorithm
    # with little modification Now if we find
    # that dis[i][j] > dis[i][k] + dis[k][j]
    # then we modify next[i][j] = next[i][k]
    def run(self):
        self.initialise(self.nodes)
        for k in range(len(self.adjacent)):
            for i in range(len(self.adjacent)):
                for j in range(len(self.adjacent)):
                    # We cannot travel through
                    # edge that doesn't exist
                    if self.distance[i][k] == self.INF or self.distance[k][j] == self.INF:
                        continue
                    if self.distance[i][j] > self.distance[i][k] + self.distance[k][j]:
                        self.distance[i][j] = self.distance[i][k] + self.distance[k][j]
                        self.adjacent[i][j] = self.adjacent[i][k]
