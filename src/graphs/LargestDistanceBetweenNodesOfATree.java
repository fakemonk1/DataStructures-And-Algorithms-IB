package graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 *
 * Largest Distance between nodes of a Tree
 Problem Setter: ulugbek_adilbekov
 Problem Tester: raghav_aggiwal
 Find largest distance
 Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

 The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:
 If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this:
 0
 /  |  \
 1   2   3
 \
 4

 Solution: Find the most distant node from the root, let this is d1
 not find the most distant  root from d as answer

 */
public class LargestDistanceBetweenNodesOfATree {
    static int N = 40005;
    static int ans = 0;
    static int node = 0;
    static boolean[] vis;
    static ArrayList<Integer>[] G;

    public int solve(ArrayList<Integer> A) {
        //size of the parent array
        int n = A.size();

        vis = new boolean[n];
        G = new ArrayList[n];

        // making the graph
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<Integer>();
        }

        // adding edges to graph
        for (int i = 0; i < n; i++) {
            int par = A.get(i);
            if (par != -1) {
                G[i].add(par);
                G[par].add(i);
            }
        }

        //filling vis array to 0
        Arrays.fill(vis, false);

        //running first dfs to find the farthest node from root.
        //It will be stored in variable root.
        ans = 0;
        dfs(0, 0);

        //running second dfs to find the farthest node from TreeNode node (as found in last dfs).
        //This distance will be stored in variable ans.
        Arrays.fill(vis, false);
        ans = 0;
        dfs(node, 0);

        //ans is the required result
        return ans;
    }

    public static void dfs(int root, int d) {
        //standard dfs subroutine
        vis[root] = true;

        if (d > ans) {
            ans = d;
            node = root;
        }

        for (Integer node : G[root]) {
            if (vis[node] == false) {
                dfs(node, d + 1);
            }
        }
    }
}