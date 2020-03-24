package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class MeetingRooms {

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

    public boolean canAttendMeetings(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (ends[i] > starts[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
