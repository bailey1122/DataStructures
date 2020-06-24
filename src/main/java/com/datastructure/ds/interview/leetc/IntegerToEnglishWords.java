package com.datastructure.ds.interview.leetc;

public class IntegerToEnglishWords {

    public String[] NUMS_LESS_THAN_TWENTY = {"", "One", "Two", "Three",
            "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};
    public String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder res = new StringBuilder();
        int index = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder sb = new StringBuilder();
                convert(sb, num % 1000);
                res.insert(0, sb.append(THOUSANDS[index]).append(" "));
            }

            index++;
            num /= 1000;
        }

        return res.toString().trim();
    }

    private void convert(StringBuilder sb, int num) {
        if (num == 0) return;

        if (num < 20) {
            sb.append(NUMS_LESS_THAN_TWENTY[num]).append(" ");
        } else if (num < 100) {
            sb.append(TENS[num / 10]).append(" ");
            convert(sb, num % 10);
        } else {
            sb.append(NUMS_LESS_THAN_TWENTY[num / 100]).append(" Hundred ");
            convert(sb, num % 100);
        }
    }
}
