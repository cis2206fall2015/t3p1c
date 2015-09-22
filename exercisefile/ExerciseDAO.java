package exercisefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brett Burley-Inners
 */
public class ExerciseDAO {

    private final String fileName;
    protected final List<Exercise> myList;

    public ExerciseDAO() {
        this("exdata.txt");
    }

    public ExerciseDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(Exercise exercise) {
        myList.add(Exercise);
        writeList();
    }

    public Exercise retrieveRecord(int id) {
        for (Exercise exercise : myList) {
            if (exercise.getDbId() == id) {
                return exercise;
            }
        }
        return null;
    }

    public void updateRecord(Exercise updatedExercise) {
        for (Exercise exercise : myList) {
            if (exercise.getDbId() == updatedExercise.getDbId()) {
		exercise.setMemId (updatedExercise.getMemId());
                exercise.setTimeStamp(updatedExercise.getTimeStamp());
                exercise.setExerciseType(updatedExercise.getExerciseType());
                exercise.setExerciseLength(updatedExercise.getExerciseLength());
                exercise.setExerciseComments(updatedExercise.getExerciseComments());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (Exercise exercise : myList) {
            if (exercise.getDbId() == id) {
                myList.remove(exercise);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(Exercise exercise) {
        myList.remove(exercise);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
		int mId = Integer.parseInt(data[1]);
		String ts = data[2];
                String type = data[3];
                int time = Integer.parseInt(data[4]);
		String comment = data[5];
                Exercise exercise = new Employee(id, mId, ts, type, time, comment);
                myList.add(exercise);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Exercise exercise : myList) {
                writer.write(String.format("%d,%d,%s,%s,%d,%s\n",
                        exercise.getDbId(),
			exercise.getMemId(),
                        exercise.getTimeStamp(),
                        exercise.getExerciseType(),
                        exercise.getExerciseLength(),
                        exercise.getExerciseComments()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((exercise) -> {
            sb.append(String.format("%5d : %d, %s, %s, %d, %s\n", exercise.getDbId(), exercise.getMemId(),
                    exercise.getTimeStamp(), employee.getExerciseType(),
                    exercise.getExerciseLength(), employee.getExerciseComments()));
        });

        return sb.toString();
    }
}
