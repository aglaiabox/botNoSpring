package org.example.model;

public class KangTask extends AbstractTask {
    String a;
    String b;
    String c;
    String d;
    String e;

    private static int counter = 0;
    private int index;

    public KangTask(String problem, String a, String b, String c, String d, String e, String correctAnswer) {
        super(problem, correctAnswer);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        counter ++;
        index = counter;


        super.problem = problem + System.lineSeparator()+ " /a  " + a + " /b  " + b + " /c  " + c + " /d  " + d + " /e  " + e;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return super.problem;
    }
}
