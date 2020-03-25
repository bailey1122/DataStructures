package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    private class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(
                (a, b) -> a.end - b.end);
        minHeap.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval earliest = minHeap.poll();
            Interval current = intervals[i];
            if (earliest.end <= current.start) {
                earliest.end = current.end;
            } else {
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }

        return minHeap.size();
    }
}
