package main.java.assembler.command;

import java.util.HashMap;

public class ACommand implements Command{
    private static int n = 16;
    private String line;

    public ACommand(String line) {
        this.line = line;
//        n = 16;
    }

    @Override
    public String processAndGetValue(HashMap<String, Integer> symbols) {
        processLine();
        int value;
        try {
            value = Short.parseShort(line);
        } catch (NumberFormatException e){
            if(symbols.get(line)==null){
                value = n;
                symbols.put(line, n);
                n++;
            } else {
                value = symbols.get(line);
                System.out.println("Value of " + line + " is " + value);
            }
        }
        return getValue(value);
    }

    private void processLine() {
        StringBuilder stringBuilder = new StringBuilder(line);
        line = stringBuilder.deleteCharAt(0).toString();
    }

    private String getValue(Integer value) {
        String bin = Integer.toBinaryString(value);
        while (bin.length() < 16){
            bin = "0" + bin;
        }
        return bin;
    }
}
