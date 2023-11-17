class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    def find_shortest_paths(self, source):
        # Creating a list of unvisited nodes
        unvisited = [x for x in range(self.vertices)]
        # Creating a list of distances
        distances = [float("inf")] * self.vertices
        # Setting the distance of the source node to 0
        distances[source] = 0
        while len(unvisited) > 0:
            # Finding the unvisited node with the minimum distance
            min_index = -1
            for i in range(len(unvisited)):
                if min_index == -1:
                    min_index = unvisited[i]
                elif distances[unvisited[i]] < distances[min_index]:
                    min_index = unvisited[i]
            # Removing the node from the unvisited list
            unvisited.remove(min_index)
            # Updating the distance of the adjacent nodes
            for i in range(len(self.graph[min_index])):
                if self.graph[min_index][i] > 0:
                    if distances[i] > distances[min_index] + self.graph[min_index][i]:
                        distances[i] = distances[min_index] + self.graph[min_index][i]
        # Creating the output dictionary
        output = {}
        for i in range(len(distances)):
            if distances[i] != float("inf"):
                output[i] = distances[i]
        return output