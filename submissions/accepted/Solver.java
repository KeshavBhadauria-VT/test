//@author Keshav Bhadauria
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[scanner.nextInt()][scanner.nextInt()];
        int numberOfHeavy = scanner.nextInt();
        for (int i = 0; i < numberOfHeavy; i++) {
            String current = scanner.next().replace(",", " ").replace("[", "").replace("]", "");
            String[] strs = current.trim().split("\\s+");

            int y = (Integer.parseInt(strs[0]));
            int x = (Integer.parseInt(strs[1]));

            board[y][x] = 1;
        }
        String current = scanner.next().replace(",", " ").replace("[", "").replace("]", "");
        String[] strs = current.trim().split("\\s+");

        int y = (Integer.parseInt(strs[0]));
        int x = (Integer.parseInt(strs[1]));
        board[y][x] = 2;
        //Now the board is set up
        if (bfs(board, 0, 0, board.length, board[0].length, new Pair(x, y))) {
            System.out.println("SLEEPING");
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }


    public static boolean bfs(int[][] board, int row, int col, int n, int m, Pair goal) {
        Queue<Pair> pairQueue = new ArrayDeque<>();
        pairQueue.add(new Pair(row, col));

        board[row][col] = 4; //4 means visited
        while (!pairQueue.isEmpty()) {
            Pair value = pairQueue.poll();
            int x = value.x;
            int y = value.y;
            board[x][y] = 4;

            if (isValid(x+1, y, n , m) && (board[x+1][y] == 0 || board[x+1][y] == 2)) {
                pairQueue.add(new Pair(x+1, y));
                board[x+1][y] = 4;
            }
            if (isValid(x-1, y, n , m) && (board[x-1][y] == 0 || board[x-1][y] == 2)) {
                pairQueue.add(new Pair(x-1, y));
                board[x-1][y] = 4;
            }
            if (isValid(x, y+1, n , m) && (board[x][y+1] == 0 || board[x][y+1] == 2)) {
                pairQueue.add(new Pair(x, y+1));
                board[x][y+1] = 4;
            }
            if (isValid(x, y-1, n , m) && (board[x][y-1] == 0 || board[x][y-1] == 2)) {
                pairQueue.add(new Pair(x, y-1));
                board[x][y-1] = 4;
            }
        }
        return (board[goal.y][goal.x] == 4);


    }

    public static boolean isValid(int row, int col, int x, int y) {
        if (row < 0 || col < 0) {
            return false;
        }
        return row < x && col < y;
    }
    public static class Pair {
        private int x;
        private int y;


        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}