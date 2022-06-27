package sit.tuvarna.bg;

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

    public float calculateAverageGrade(){
        for(Discipline d : this.major.disciplineList ){
            if(this.major.getGrade(d) > 2f) {
                System.out.println("Passed: " + this.major.getName(d) + " with grade " + this.major.getGrade(d));
                AverageGrade += this.major.getGrade(d);
            }
            else if(this.major.getGrade(d) <= 2f){
               System.out.println("Failed: " + this.major.getName(d) + " with grade " + this.major.getGrade(d));
                AverageGrade += this.major.getGrade(d);
            }
        }
        System.out.println("Average grade: " + AverageGrade/this.major.disciplineList.size());
        return AverageGrade;
    }


    public void setMajor(String major) {
        this.major.name = major;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public StringBuilder getName() {
        return name;
    }
    public String getFacultyNumber() {
        return facultyNumber;
    }
    public int getYear() {
        return year;
    }
    public Major getMajor() {
        return major;
    }
    public int getGroup() {
        return group;
    }
    public String getStatus() {
        return status;
    }
    public float getAverageGrade() {
        return AverageGrade;
    }

    @Override
    public String toString() {
        return "Student " + this.name + " - " + this.facultyNumber + " from " + this.major + " in year " + this.year;
    }
}