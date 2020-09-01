package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length, res[] = new int[n];

        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) q.offer(i);
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.offer(q.poll());
        }

        return res;
    }
}
