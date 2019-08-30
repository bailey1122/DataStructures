package com.datastructure.ds.interview.arraysAndStrings;

public class Urlify {
    public static void main(String[] args) {
        String a = "Mr John Smith       ";
        char[] s = a.toCharArray();
        Urlify u = new Urlify();
        System.out.println(u.replaceSpaces(s, 13));

    }

    public String replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0'; // end array
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return new String(str).trim();
    }
}
