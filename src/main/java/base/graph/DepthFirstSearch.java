package base.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jbzm
 * @date 8/6/20 5:01 PM
 **/
public class DepthFirstSearch {

    public int[] dfs(LinkedList<Integer>[] adj, int v, int s, int t) {

        if (adj == null) {
            return null;
        }

        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new ArrayBlockingQueue<>(v);
        int[] path = new int[v];

        // init path array

        for (int i = 0; i < v; i++) {
            path[i] = -1;
        }

        queue.add(s);

        visited[s] = true;

        while (queue.peek() != null) {
            Integer currentVertex = queue.poll();
            if (currentVertex == t) {
                break;
            }
            while (adj[currentVertex].peek() != null) {
                Integer nextVertex = adj[currentVertex].pollFirst();
                if (visited[nextVertex]) {
                    continue;
                }
                visited[nextVertex] = true;
                queue.add(nextVertex);
                path[nextVertex] = currentVertex;
            }
        }

        return path;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(5, 7);
        graph.addEdge(7, 8);
        graph.addEdge(6, 8);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        int[] dfs = depthFirstSearch.dfs(graph.getAdj(), graph.getV(), 1, 8);
        int tmp = 8;
        while (tmp != 1) {
            System.out.println(tmp);
            tmp = dfs[tmp];
        }
        System.out.println(1);
    }
}