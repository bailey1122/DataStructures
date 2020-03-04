package com.datastructure.ds.interview.sortingAndSearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// 10 MB memory
public class MissingInt2 {

    int findOpenNumber(String fileName) throws FileNotFoundException {
        int rangeSize = (1 << 20);

        int[] blocks = getCountPerBlock(fileName, rangeSize);

        int blockIndex = findBlockWithMissing(blocks, rangeSize);
        if (blockIndex < 0) return -1;

        byte[] bitVector = getBitVectorForRange(fileName, blockIndex, rangeSize);

        int offset = findZero(bitVector);
        if (offset < 0) return -1;

        return rangeSize * blockIndex + offset;
    }

    int findZero(byte b) {
        for (int i = 0; i < Byte.SIZE; i++) {
            int mask = 1 << i;
            if ((b & mask) == 0) {
                return i;
            }
        }
        return -1;
    }

    int findZero(byte[] bitVector) {
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) {
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return -1;
    }

    byte[] getBitVectorForRange(String fileName, int blockIndex, int rangeSize)
            throws FileNotFoundException {
        int start = blockIndex * rangeSize;
        int end = start + rangeSize;
        byte[] bitVector = new byte[rangeSize / Byte.SIZE];

        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            if (start <= value && value < end) {
                int offset = value - start;
                int mask = (1 << (offset % Byte.SIZE));
                bitVector[offset / Byte.SIZE] |= mask;
            }
        }
        in.close();
        return bitVector;
    }

    int findBlockWithMissing(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    int[] getCountPerBlock(String fileName, int rangeSize)
            throws FileNotFoundException {
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[arraySize];

        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            blocks[value / rangeSize]++;
        }
        in.close();
        return blocks;
    }

    public static void main(String[] args) {
        System.out.println(32000 >> 5);
    }
}