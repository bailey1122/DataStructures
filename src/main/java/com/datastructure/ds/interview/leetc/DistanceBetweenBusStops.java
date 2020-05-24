package com.datastructure.ds.interview.leetc;

public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockWiseDistance = 0;
        int totalDistance = 0;

        for (int i = 0; i < distance.length; i++) {
            if (start < destination && (i >= start && i < destination)) {
                clockWiseDistance += distance[i];
            }

            if (start > destination && (i >= start || i < destination)) {
                clockWiseDistance += distance[i];
            }

            totalDistance += distance[i];
        }

        return Math.min(clockWiseDistance, totalDistance - clockWiseDistance);
    }
}
