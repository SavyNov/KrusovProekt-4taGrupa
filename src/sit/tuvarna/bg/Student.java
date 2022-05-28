package sit.tuvarna.bg;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    protected StringBuilder name;
    protected String facultyNumber;
    protected int year;
    protected Major major;
    protected int group;
    protected String status;
    protected float AverageGrade;
    protected Discipline disc;


    public Student(StringBuilder name, String facultyNumber,int year, Major major, int group, String status) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.year = year;
        this.major = major;
        this.group = group;
        this.status = status;
    }

    public void addGrade(Discipline disc,Float grade){
        this.major.setGrade(disc,grade);
    }

    public float calculateAverageGrade(){  //tozi method ne raboti
        for(Discipline d : this.major.disciplineList ){
            if(this.major.getGrade(d) > 2f) {
                System.out.println("Successful exams: \n");
                System.out.println(this.major.getName(d) + " with grade " + this.major.getGrade(d));
            }
            else if(this.major.getGrade(d) <= 2f){
                System.out.println("Failed exams: \n");
                System.out.println( this.major.getName(d) + " with grade " + this.major.getGrade(d));
            }
            AverageGrade += this.major.getGrade(d);
        }
        System.out.println("Average grade: ");
        return AverageGrade;
    }
    @Override
    public String toString() {
       return "Student " + this.name + this.facultyNumber + " from " + this.major + " with disciplines " + major.toString();
    }
}

