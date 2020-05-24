package com.datastructure.ds.interview.leetc;

import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        boolean[] timeSeen = new boolean[24 * 60];

        for (String timePoint : timePoints) {
            String[] timeSplit = timePoint.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);

            if (timeSeen[(hour * 60) + minute]) return 0;
            timeSeen[(hour * 60) + minute] = true;
        }

        Integer firstTimeSeen = null;
        Integer previousTimeSeen = null;
        Integer minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < timeSeen.length; i++) {
            if (timeSeen[i]) {
                if (firstTimeSeen == null) {
                    firstTimeSeen = i;
                    previousTimeSeen = i;
                } else {
                    minDistance = Math.min(minDistance, Math.min(
                            i - previousTimeSeen, 24 * 60 - i + firstTimeSeen));
                    previousTimeSeen = i;
                }
            }
        }

        minDistance = Math.min(minDistance, Math.min(previousTimeSeen - firstTimeSeen,
                24 * 60 - previousTimeSeen + firstTimeSeen));

        return minDistance;
    }

    public static void main(String[] args) {
        System.out.println((-14) - (-10));
    }
}
