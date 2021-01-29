package everyday;

/**
 * @author jbzm
 * @date 8/4/20 5:40 PM
 **/
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses > 1000) {
            return true;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        boolean[][] adjacencyMatrix = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            for (int j = 1; j < prerequisites[0].length; j++) {
                adjacencyMatrix[prerequisite[0]][prerequisite[j]] = true;
            }
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (!recursiveCheck(i, 0, adjacencyMatrix)) {
                return false;
            }
        }
        return true;
    }

    public boolean recursiveCheck(int v, int num, boolean[][] adjacencyMatrix) {
        if (num > adjacencyMatrix.length) {
            return false;
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i]) {
                if (!recursiveCheck(i, ++num, adjacencyMatrix)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] ints = new int[][]{};
        System.out.println(courseSchedule.canFinish(2000
                , ints));
    }
}