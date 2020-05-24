package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(N)
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int initColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length ||
                image[sr][sc] != initColor) {
            return;
        }

        image[sr][sc] = newColor;

        fill(image, sr - 1, sc, initColor, newColor);
        fill(image, sr + 1, sc, initColor, newColor);
        fill(image, sr, sc - 1, initColor, newColor);
        fill(image, sr, sc + 1, initColor, newColor);
    }
}
