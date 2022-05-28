package sit.tuvarna.bg;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Discipline oop = new Discipline("OOP","mandatory");
        Discipline ps = new Discipline("PS","mandatory");
        Discipline gs = new Discipline("GS","mandatory");
        Discipline mpt = new Discipline("MPT","mandatory");
        Discipline sport = new Discipline("Sport","optional");

        Discipline[] disciplines = {oop,ps,gs,mpt,sport};

        Major sit = new Major("SIT");
        for (Discipline s : disciplines){
            sit.addToArray(s);
        }

        Student student = new Student(new StringBuilder("Ivan"), "20621587",2, sit, 2, "studying");
        student.addGrade(gs, 5F);
        student.calculateAverageGrade();

    }
}
