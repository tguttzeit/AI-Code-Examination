import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances to all nodes as infinite and the source node as 0
        distances = [float('inf')] * self.vertices
        distances[source] = 0

        # Initialize a priority queue (min heap) to keep track of nodes to be explored
        min_heap = [(0, source)]

        # Initialize a dictionary to store the shortest paths
        shortest_paths = {}

        while min_heap:
            # Get the node with the minimum distance from the priority queue
            current_distance, current_node = heapq.heappop(min_heap)

            # Skip if we have already processed this node with a shorter distance
            if current_distance > distances[current_node]:
                continue

            # Add the node to the shortest_paths dictionary with its distance
            shortest_paths[current_node] = current_distance

            # Explore neighbors of the current node
            for neighbor, weight in self.graph[current_node]:
                distance = current_distance + weight

                # If a shorter path is found, update the distance and add the neighbor to the priority queue
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(min_heap, (distance, neighbor))

        # Remove nodes with infinite distance (no path exists) from the dictionary
        shortest_paths = {node: distance for node, distance in shortest_paths.items() if distance != float('inf')}
        return shortest_paths
