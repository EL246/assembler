package main.java.assembler.command.c_command;

import main.java.assembler.command.Command;
import main.java.assembler.file.SymbolTable;

public class CCommand implements Command {
    private String line;
    private String dest;
    private String jump;
    private String comp;
    private boolean aVal;

    public CCommand(String line) {
        this.line = line;
    }

    @Override
    public String processAndGetValue(SymbolTable symbols) {
        line = line.replaceAll("\\s+", "");
        parseSections();
        return combineSectionsToBinary();
    }

    private String combineSectionsToBinary() {
        return "111" +
                (isaVal() ? 1 : 0) +
                CalcVal.getVal(comp) +
                DestVal.getDest(dest) +
                JumpVal.valueOf(jump).getVal();
    }

    private void parseSections() {
        String j = setDest();
        String a = setJump(j);
        setA(a);
        setComp(a);
    }

    private void setComp(String a) {
        comp = a;
    }

    private void setA(String c) {
        aVal = c.contains("M");
    }

    private String setJump(String s) {
        String[] values = s.split(";");
        if (values.length == 1) {
            jump = "DEFAULT";
            return values[0];
        } else {
            jump = values[1];
            return values[0];
        }
    }

    private String setDest() {
        String[] values = line.split("=");
        if (values.length == 1) {
            dest = "";
            return values[0];
        } else {
            dest = values[0];
            return values[1];
        }
    }

    private boolean isaVal() {
        return aVal;
    }
}
