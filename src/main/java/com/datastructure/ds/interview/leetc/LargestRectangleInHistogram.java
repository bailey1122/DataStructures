package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            int currBarH = heights[i];

            while (stack.peek() != -1 && currBarH <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
