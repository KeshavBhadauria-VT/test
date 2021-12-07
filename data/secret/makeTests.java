//@author Keshav Bhadauria
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class makeTests {


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            File file = new File("Sample0" + i + ".in");
            FileWriter writer = new FileWriter(file);
            HashSet<Pair> set = new HashSet<>();
            int length = (int)(Math.random() * 100) + 1;
            int width = (int)(Math.random() * 100) + 1;
            int numberOfUnMovable = (int)(Math.random() * (length * width - 1));
            writer.write(length + " " + width + " " + numberOfUnMovable + "\n");
            for (int z = 0; z < numberOfUnMovable; z++) {
                int randomX = (int)(Math.random() *  length);
                int randomY = (int)(Math.random() * width);
                Pair<Integer, Integer> integerPair = new Pair<>(randomX, randomY);
                if (set.contains(integerPair)) {
                    z--;
                    continue;
                }
                writer.write(integerPair.toString());
                set.add(integerPair);
            }
            int endingX = (int)(Math.random() * length);
            int endingY = (int)(Math.random() * width);
            Pair<Integer, Integer> ending = new Pair<>(endingX, endingY);
            while (set.contains(ending)) {
                endingX = (int)(Math.random() * length);
                endingY = (int)(Math.random() * width);
                ending = new Pair<>(endingX, endingY);
            }
            writer.write("\n");
            writer.write(ending.toString());
            writer.close();
        }
    }


    public static class Pair<L,R> {

        private final L left;
        private final R right;

        public Pair(L left, R right) {
            assert left != null;
            assert right != null;

            this.left = left;
            this.right = right;
        }

        public L getLeft() { return left; }
        public R getRight() { return right; }

        @Override
        public int hashCode() { return left.hashCode() ^ right.hashCode(); }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair pairo = (Pair) o;
            return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
        }


        @Override public String toString() {
            return "[" + left + "," + right + "] ";
        }
    }

}