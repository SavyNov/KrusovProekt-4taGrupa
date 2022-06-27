package sit.tuvarna.bg;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Discipline oop = new Discipline("OOP","mandatory");
        Discipline ps = new Discipline("PS","mandatory");
        Discipline gs = new Discipline("GS","mandatory");
        Discipline mpt = new Discipline("MPT","optional");
        Discipline sport = new Discipline("Sport","optional");
        Discipline sa = new Discipline("SA","mandatory");
        Discipline cs = new Discipline("CS", "optional");
        Major sit = new Major("SIT");
        Major kst = new Major("KST");
        ArrayList<Discipline> disciplines = new ArrayList<>();
        Discipline[] sitDisciplines = {oop,ps,gs,mpt,sport};
        Discipline[] kstDisciplines = {oop,ps,sport,sa,cs};

        Major[] majors = {sit,kst};
        for (Discipline s : sitDisciplines){
            sit.addToArray(s);
            disciplines.add(s);
        }
        for (Discipline s : kstDisciplines){
            kst.addToArray(s);
            disciplines.add(s);
        }

        MainMenu mainMenu = new MainMenu();
        mainMenu.Menu(majors,disciplines);


    }
}