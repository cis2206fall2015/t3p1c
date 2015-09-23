package exercisefile;

import java.util.Scanner;
import exercisefile.Validator;
/**
 *
 * @author Team 3 */
public class ExerciseApp {

    ExerciseDAO exList = new ExerciseDAO();
    Scanner sc = new Scanner(System.in);

    public ExerciseApp() {
        menuLoop();
    }

    private void menuLoop() {
        int dbId, memId, exerciseLength;
        String timeStamp, exerciseType, exerciseComments;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nExercise App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(exList.toString());
                    break;
                case "2":
                    dbId = Validator.getInt(sc, "New exercise ID: ");
                    memId = Validator.getInt(sc, "Member ID: ");
                    timeStamp = Validator.getLine(sc, "Date/Time: ");
                    exerciseType = Validator.getLine(sc, "Exercise Type: ");
                    exerciseLength = Validator.getInt(sc, "Exercise Length: ");
                    exerciseComments = Validator.getLine(sc, "Exercise Comments: ");
                    exList.createRecord(new Exercise(dbId, memId, timeStamp, exerciseType, exerciseLength, exerciseComments));
                    break;
                case "3":
                    dbId = Validator.getInt(sc, "Exercise ID to retrieve: ");
                    System.out.println(exList.retrieveRecord(dbId));
                    break;
                case "4":
                    dbId = Validator.getInt(sc, "Exercise ID to update: ");
                    memId = Validator.getInt(sc, "Member ID: ");
                    timeStamp = Validator.getLine(sc, "Date/Time: ");
                    exerciseType = Validator.getLine(sc, "Exercise Type: ");
                    exerciseLength = Validator.getInt(sc, "Exercise Length: ");
                    exerciseComments = Validator.getLine(sc, "Exercise Comments: ");
                    exList.updateRecord(new Exercise(dbId, memId, timeStamp, exerciseType, exerciseLength, exerciseComments));
                    break;
                case "5":
                    dbId = Validator.getInt(sc, "Exercise ID to delete: ");
                    System.out.println(exList.retrieveRecord(dbId));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        exList.deleteRecord(dbId);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ExerciseApp();
    }
}
