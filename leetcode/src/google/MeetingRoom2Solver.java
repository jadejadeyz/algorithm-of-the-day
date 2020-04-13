package google;

import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2Solver {

    private int partitionByStartTime(int[][] intervals, int low, int high) {
        int pivot = intervals[high][0];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (intervals[j][0] <= pivot) {
                i++;
                int tmpStart = intervals[j][0];
                int tmpEnd = intervals[j][1];
                intervals[j][0] = intervals[i][0];
                intervals[j][1] = intervals[i][1];
                intervals[i][0] = tmpStart;
                intervals[i][1] = tmpEnd;
            }
        }
        int tmpStart = intervals[i+1][0];
        int tmpEnd = intervals[i+1][1];
        intervals[i+1][0] = intervals[high][0];
        intervals[i+1][1] = intervals[high][1];
        intervals[high][0] = tmpStart;
        intervals[high][1] = tmpEnd;

        return i+1;
    }

    public void sortByStartTime(int[][] intervals, int low, int high) {
        if(low < high) {
            int p = partitionByStartTime(intervals, low, high);
            sortByStartTime(intervals, low, p-1);
            sortByStartTime(intervals, p+1, high);
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        sortByStartTime(intervals, 0, intervals.length-1);
        Queue<Integer> rooms = new PriorityQueue<>();

        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (rooms.peek() > intervals[i][0]) // room can't be released on time, new room needed
                rooms.add(intervals[i][1]);
            else {// room is available, update its priority (i.e. ending time)
                rooms.remove();
                rooms.add(intervals[i][1]);
            }
        }

        return rooms.size();
    }
}
