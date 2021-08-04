package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfProvinces547 {
        public int findCircleNum(int[][] isConnected) {
            HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
            boolean[] visited = new boolean[isConnected.length];
            // init
            for (int i = 0; i < isConnected.length; i++) {
                adjList.put(i, new ArrayList<>());
            }

            // 做adjList list裡面要放 nodes -> 除了自己之外
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[i].length; j++) {
                    if (isConnected[i][j] == 1 && i != j) {
                        adjList.get(i).add(j);
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i]) {
                    result++;
                    dfs(adjList, i, visited);
                }
            }
            return result;
        }
        public void dfs(HashMap<Integer, ArrayList<Integer>> adjList, int root, boolean[] visited) {
            if (visited[root]) {
                return;
            }
            // visiting add here
            visited[root] = true;

            for (Integer neighbor : adjList.get(root)) {
                dfs(adjList, neighbor, visited);
            }

            // visited add here -> 任何back tracking 都加後面
        }
    public static void main(String[] args) {
        int[][] input = new int[4][4];
        input[0] = new int[]{0,1,1,0};
        input[1] = new int[]{0,1,1,1};
        input[2] = new int[]{1,0,1,1};
        NumberOfProvinces547 number = new NumberOfProvinces547();
        number.findCircleNum(input);
    }
}
