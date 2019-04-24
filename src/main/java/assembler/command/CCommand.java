package main.java.assembler.command;

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
        line = line.replace(" ", "");
        parseSections();
        return combineSectionsToBinary();
    }

    private String combineSectionsToBinary() {
        String s = "111" + "111" +
                (isaVal() ? 1 : 0) +
                CalcVal.getVal(comp) +
                DestVal.getDest(dest) +
                JumpVal.valueOf(jump).getVal();
        return s;
    }

    private void parseSections() {
        setDest();


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
            return values[0].replace(" ","");
        } else {
            jump = values[1].replace(" ","");
            return values[0].replace(" ","");
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

    private String getDest() {
        return dest;
    }

    public String getJump() {
        return jump;
    }

    private String getComp() {
        return comp;
    }

    private boolean isaVal() {
        return aVal;
    }
}
