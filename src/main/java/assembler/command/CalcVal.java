package main.java.assembler.command;

import java.util.HashMap;
import java.util.Map;

class CalcVal {
    private static Map<String,String> calcValues = new HashMap<>();

    private static String[][] values = {
            {"0","101010"},{"1","111111"}, {"-1","111010"}, {"D","001100"},
            {"A","110000"}, {"M","110000"}, {"!D","001101"}, {"!A","110001"},
            {"!M","110001"}, {"-D","001111"}, {"-A","110011"},{"-M","110011"},
            {"D+1","011111"}, {"A+1","110111"},{"M+1","110111"}, {"D-1", "001110"},
            {"A-1","110010"}, {"M-1","110010"}, {"D+A", "000010"},{"D+M", "000010"},
            {"D-A", "010011"},{"D-M", "010011"}, {"A-D","000111"}, {"M-D","000111"},
            {"D&A","000000"}, {"D&M","000000"},{"D|A","010101"},{"D|M", "010101"} };

    static {
        for (String[] s : values) {
            calcValues.put(s[0],s[1]);
        }
    }

    static String getVal(String key){
        return calcValues.get(key);
    }

}

