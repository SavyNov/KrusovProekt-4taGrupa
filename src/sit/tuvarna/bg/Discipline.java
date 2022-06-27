package sit.tuvarna.bg;

import java.util.HashMap;
import java.util.Map;

public class Discipline {
    String name;
    String type;
    float grade;
    public Discipline(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return  name ;
    }
}