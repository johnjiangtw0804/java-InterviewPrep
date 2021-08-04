package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule_207 {
    // cycle detection
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
            visited[i] = -1;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjList, i, visited)) {
                return false;
            }
        }

        return true;
    }
    public boolean dfs(HashMap<Integer, ArrayList<Integer>> adjList, int node, int[] visited) {
        if(visited[node] == 1) {
            return true;
        }

        visited[node] = 0;

        for (Integer neighbor : adjList.get(node)) {
            if (visited[neighbor] == 0) {
                return false;
            }
            if (!dfs(adjList, neighbor, visited)) {
                return false;
            }
        }

        visited[node] = 1;
        return true;
    }
}
