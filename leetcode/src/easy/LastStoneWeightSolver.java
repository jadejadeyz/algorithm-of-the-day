package easy;

import java.util.Comparator;
import java.util.PriorityQueue;



public class LastStoneWeightSolver {

    class IntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer v1, Integer v2) {
            return v1 < v2 ? 1 : v1 > v2 ? -1 : 0;
        }
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(new IntComparator());

        for (int stone: stones)
            que.add(stone);

        while (!que.isEmpty() && que.size() > 1) {
            Integer first = que.poll();
            Integer second = que.poll();
            Integer newStone = first - second;
            if (newStone > 0)
                que.add(newStone);
        }

        if (que.isEmpty())
            return 0;
        else
            return que.peek();
    }
}
