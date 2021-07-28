import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        // stack -> to get the topological order
        Stack<Integer> stack = new Stack<Integer>();
        // dfs nodes
        int[] visited = new int[numCourses];
        Arrays.fill(visited, -1);
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }

        // add the edges
        // get in-degree
        for (int i = 0; i < prerequisites.length; i++ ) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] += 1;
        }

        // traverse the in-degree zero vetices, and add it to the queue
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        boolean cycle = false;
        for (Integer degreeZero : q) {
            cycle = dfs(adjList, degreeZero, visited, stack);
        }
        if (!cycle && stack.size() == numCourses) {
            int[] result = new int[stack.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = stack.pop();
            }
            return result;
        }
        return new int[0];
    }
    public boolean dfs(Map<Integer, ArrayList<Integer>> adjList, int root, int[] visited, Stack<Integer> topological) {
        // if this root has been visited(handled) -> return false -> no cycle
        if (visited[root] == 1) {
            return false;
        }
        // mark visiting
        visited[root] = 0;

        for (Integer neighbor : adjList.get(root)) {
            // if neighbor is visiting node. -> cycle
            if (visited[neighbor] == 0) {
                return true;
            }
            if (dfs(adjList, neighbor, visited, topological)) {
                return true;
            }
        }
        // backtracking -> visiting -> visited -> add
        visited[root] = 1;
        topological.add(root);
        return false;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[][] pre = new int[4][2];
        pre[0] = new int[]{1,0};
        pre[1] = new int[]{2,0};
        pre[2] = new int[]{3,1};
        pre[3] = new int[]{3,2};
        s1.findOrder(4, pre);
    }
}