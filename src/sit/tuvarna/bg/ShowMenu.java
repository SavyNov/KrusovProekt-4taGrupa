package sit.tuvarna.bg;

public class ShowMenu {

    String choice;

    String showMenu(){
        System.out.println(
                "1.Enroll \n" +
                "2.Advance\n" +
                "3.Change\n" +
                "4.Graduate\n" +
                "5.Interrupt\n" +
                "6.Resume\n" +
                "7.Print student (FN)\n" +
                "8.Print all students \n" +
                "9.Enroll in a discipline(WIP) \n" +
                "10.Add grade \n" +
                "'help to see available commands \n" +
                "'exit'" + " to exit the application");

        return choice;
    }
}
