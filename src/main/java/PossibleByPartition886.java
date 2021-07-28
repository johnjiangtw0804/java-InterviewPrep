import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleByPartition886 {
    class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            // graph coloring
            HashMap<Integer, List<Integer>> map = new HashMap<>();

            // 零開始
            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<Integer>());
            }

            // adjList
            // dislikes[1,2] <= 1開始
            for (int[] dislikePair : dislikes) {
                map.get(dislikePair[0]-1).add(dislikePair[1]-1);
                map.get(dislikePair[1]-1).add(dislikePair[0]-1);
            }

            // 0 = unvisited, 1 = groupA, -1 = groupB
            int[] visited = new int[n];

            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && !dfs(map, visited, i, 1)) {
                    return false;
                }
            }
            return true;
        }
        private boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int person, int group) {
            // mark group
            visited[person] = group;

            for (int neighbor : map.get(person)) {
                if (visited[neighbor] == group) {
                    return false;
                }
                // 這寫的超棒->還沒走過用&&去走->如果false -> return false;
                if (visited[neighbor] == 0 && !dfs(map, visited, neighbor, -group)) {
                    return false;
                }
            }
            return true;
        }
    }
}
