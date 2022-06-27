package sit.tuvarna.bg;



import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {

    XMLOperations xmlOperator = new XMLOperations();
    ShowMenu menu = new ShowMenu();
    ArrayList<Student> studentList = new ArrayList<>();
    boolean isFileOpen = false;
    Scanner scanner = new Scanner(System.in);
    String ch;

    void Menu(Major[] majors, ArrayList<Discipline> disciplines){

        do {
            if (isFileOpen) {
                ch = scanner.nextLine();
                switch (ch) {
                    case "help": {
                        System.out.println(
                                "The following commands are supported:\n" +
                                "open <file> - opens <file>\n" +
                                "close - closes currently opened file\n" +
                                "save - saves the currently opened file\n" +
                                "saveas <file> - saves the currently opened file in <file>\n" +
                                "help - prints information");
                        break;
                    }
                    case "close": {
                        xmlOperator.closeXMLFile();
                        isFileOpen = false;
                        System.out.println("Successfully closed" + xmlOperator.getName()+ "\n");
                        break;
                    }
                    case "save": {
                        xmlOperator.writeXMLFile(studentList);
                        System.out.println("Successfully saved" + xmlOperator.getName());
                        break;
                    }
                    case "saveas": {
                        System.out.println("Input what name and directory of the file");
                        String fName = scanner.nextLine();
                        xmlOperator.setName(fName);
                        xmlOperator.writeXMLFileAs(studentList);
                        System.out.println("Successfully saved another " + fName + ".xml");
                        break;
                    }
                    default:
                        break;
                }
            } else {
                menu.showMenu();
                ch = scanner.nextLine();
                switch (ch) {
                    case "1": {
                        System.out.println("Enter a faculty number: ");
                        String fn = scanner.nextLine();
                        System.out.println("Enter name: ");
                        StringBuilder name = new StringBuilder(scanner.nextLine());
                        System.out.println("Enter major: ");
                        Major major = new Major(scanner.nextLine());
                        System.out.println("Enter group: ");
                        int group = Integer.parseInt(scanner.nextLine());
                        studentList.add((new Student(name, fn, 1, major, group, "studying")));
                        break;
                    }
                    case "2": {
                        System.out.println("Enter a faculty number: ");
                        String fn = scanner.nextLine();
                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber) && (!Objects.equals(s.status, "interrupted"))) {
                                System.out.println("Student \n" + s + " advanced to next year");
                                s.year = s.year + 1;
                            } else {
                                System.out.println("Wrong faculty number or student has interrupted! \n Input again: ");
                                fn = scanner.nextLine();
                            }

                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Enter a faculty number: ");
                        String fn = scanner.nextLine();
                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber) && (!Objects.equals(s.status, "interrupted"))) {
                                System.out.println("What do you want to change: ");
                                String chh = scanner.nextLine();
                                System.out.println(
                                        "1.Major\n" +
                                        "2.Group\n" +
                                        "3.Year\n");
                                switch (chh) {
                                    case "1": {
                                        System.out.println("Change major for student\n" + s + " to what:\n");
                                        String maj = scanner.nextLine();
                                        for (Major m : majors) {
                                            if (Objects.equals(maj, m.name)) {
                                                s.setMajor(maj);
                                            } else {
                                                System.out.println("Wrong major, input again\n");
                                                maj = scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Change group for student\n" + s + " to what(1-5):\n");
                                        int group = Integer.parseInt(scanner.nextLine());
                                        if (!(group < 5 && group > 1)) {
                                            throw new IllegalArgumentException(("Group not in the right interval!"));
                                        }
                                        s.setGroup(group);
                                        break;
                                    }
                                    case "3": {
                                        System.out.println("Change year for student\n" + s + " to what(1-4):\n");
                                        int year = Integer.parseInt(scanner.nextLine());
                                        if (!(year < 5 && year > 1)) {
                                            throw new IllegalArgumentException(("Year not in the right interval!"));
                                        }
                                        s.setYear(year);
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Wrong faculty number or student has interrupted! \n Input again: ");
                                fn = scanner.nextLine();
                            }

                        }
                        break;
                    }
                    case "4": {
                        System.out.println("FN of student: ");
                        String fn = scanner.nextLine();
                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber) && (!Objects.equals(s.status, "interrupted"))) {
                                if (s.calculateAverageGrade() > 2) {
                                    s.status = "graduated";
                                    System.out.println("Student " + s.facultyNumber + " graduated");
                                } else
                                    System.out.println("Student failed his exams");
                            } else{
                                System.out.println("Wrong faculty number or student has interrupted! \n Input again: ");
                                fn = scanner.nextLine();
                            }


                        }
                        break;
                    }
                    case "5": {
                        System.out.println("FN of student: ");
                        String fn = scanner.nextLine();
                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber) && (!Objects.equals(s.status, "interrupted"))) {
                                s.status = "interrupted";
                                System.out.println("Status of student changed successfully");
                            } else {
                                System.out.println("Wrong faculty number or student has interrupted! \n Input again: ");
                                fn = scanner.nextLine();
                            }

                        }
                        break;
                    }
                    case "6": {
                        System.out.println("FN of student: ");
                        String fn = scanner.nextLine();
                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber) && Objects.equals(s.status, "interrupted")) {
                                s.status = "studying";
                                System.out.println("Status of student changed successfully");
                            } else{
                                System.out.println("Wrong faculty number or student has not interrupted! \n Input again: ");
                                fn = scanner.nextLine();
                            }


                        }
                        break;
                    }
                    case "7": {
                        System.out.println("Input a faculty number: ");
                        String fn = scanner.nextLine();
                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber)) {
                                System.out.println(s);
                            } else {
                                System.out.println("Wrong faculty number! \n Input again: ");
                                fn = scanner.nextLine();
                            }
                        }
                        break;
                    }
                    case "8": {
                        for (Student s : studentList) {
                            System.out.println(s);
                        }
                        break;
                    }
                    case "9": {
                        break;
                    }
                    case "10": {
                        System.out.println("Input a faculty number: ");
                        String fn = scanner.nextLine();

                        for (Student s : studentList) {
                            if (Objects.equals(fn, s.facultyNumber) && (!Objects.equals(s.status, "interrupted"))) {
                                System.out.println(s);
                                for (Discipline d : disciplines) {
                                    System.out.println("Which discipline to add a grade to");
                                    String disc = scanner.nextLine();
                                    if (Objects.equals(disc, d.getName())) {
                                        System.out.println("Enter a grade between 2 and 6");
                                        float grade = Float.parseFloat(scanner.nextLine());
                                        if (!(grade < 6 && grade > 2)) {
                                            throw new IllegalArgumentException("Grade not in interval between 2 and 6");
                                        }
                                        s.addGrade(d, grade);
                                        System.out.println("Grade added for Discipline: " + d.getName() + " successfully");
                                        break;
                                    }else{
                                        System.out.println("Discipline does not exist\n Input again:");
                                        return;
                                    }
                                }
                            } else {
                                System.out.println("Wrong faculty number or student has interrupted! \n Input again: ");
                                fn = scanner.nextLine();
                            }
                        }
                        break;
                    }
                    case "help": {
                        menu.showMenu();
                        break;
                    }
                    case "open": {
                        System.out.println("Input the name of file you wish to open");
                        String fName = scanner.nextLine();
                        xmlOperator.setName(fName);
                        xmlOperator.openXMLFile();
                        isFileOpen = true;
                        System.out.println("Successfully opened" + xmlOperator.getName() +"\n");
                        System.out.println("For work with files, write 'help'");
                        break;
                    }
                    case "save":
                    case "close":
                    case "saveas": {
                        System.out.println("No file opened");
                        break;
                    }
                    default:
                        System.out.println("Choice not valid");
                        break;
                }
            }
        } while (!ch.equals("exit"));
        System.out.println("Exiting the program...");
    }

}
