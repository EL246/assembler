package main.java.assembler.command;

class DestVal {

    static String getDest(String s){
        int d1 = s.contains("A") ? 1 : 0;
        int d2 = s.contains("D") ? 1 : 0;
        int d3 = s.contains("M") ? 1 : 0;

        return Integer.toString(d1) + Integer.toString(d2) + Integer.toString(d3);
    }
}
