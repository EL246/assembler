package main.java.assembler.command.c_command;

enum JumpVal {

    JGT("001"),
    JEQ("010"),
    JGE("011"),
    JLT("100"),
    JNE("101"),
    JLE("110"),
    JMP("111"),
    DEFAULT("000");

    String val;

    JumpVal(String val){
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
