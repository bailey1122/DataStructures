package com.datastructure.ds.interview.leetc;

import java.util.stream.Stream;

public class KeyboardRow {

    public String[] findWords(String[] words) {
        return Stream.of(words).filter(w -> w.toLowerCase()
                .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
    }
}
