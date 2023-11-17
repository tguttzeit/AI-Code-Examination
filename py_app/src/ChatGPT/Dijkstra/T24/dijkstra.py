import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = {}
    
    def add_edge(self, source, destination, weight):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append((destination, weight))

    def find_shortest_paths(self, source):
        shortest_paths = {source: 0}
        priority_queue = [(0, source)]

        while priority_queue:
            current_distance, current_node = heapq.heappop(priority_queue)

            # Skip this node if we have already found a shorter path to it
            if current_distance > shortest_paths[current_node]:
                continue

            if current_node in self.graph:
                for neighbor, weight in self.graph[current_node]:
                    distance = current_distance + weight
                    if neighbor not in shortest_paths or distance < shortest_paths[neighbor]:
                        shortest_paths[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

        return shortest_paths