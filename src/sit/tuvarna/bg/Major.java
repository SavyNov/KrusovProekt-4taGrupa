package sit.tuvarna.bg;

import java.util.ArrayList;

public class Major {
    ArrayList<Discipline> disciplineList = new ArrayList<Discipline>();
    String name;

    public Major(String name){
        this.name = name;
    }


    public void addToArray(Discipline disc){
        disciplineList.add(disc);
    }
    public void add(Discipline d){
        disciplineList.add(d);
    }

    public void setGrade(Discipline d,float grade){
        d.setGrade(grade);
    }

    public float getGrade(Discipline d){
       return d.getGrade();
    }

    public String getName(Discipline d){
        return d.getName();
    }
    @Override
    public String toString() {
        return "Major:" + this.name + " with disciplines: " + this.disciplineList.toString();
    }
}
