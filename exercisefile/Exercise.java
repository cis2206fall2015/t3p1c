package exercisefile;

/**
 *
 * author Brett Burley-Inners
 *
 * Track exercise for an exercise club
 * id, member number, date/time, exercise type, exercise length, comments
 * 23, 23459223, 2015-09-01T10:15:00, bike, 50, fast ride with a few hills  
 */
public class Exercise {

    private int dbId;
    private int memId;
    private String timeStamp;
    private String exerciseType;
    private int exerciseLength;
    private String exerciseComments;

    public Exercise() {
        dbId = 0;
	memId = 0;
        timeStamp = "";
        exercistType = "";
        exerciseLength = 0;
        exerciseComments = "";
    }

    public Exercise(int dbId, int memId, String timeStamp, String exerciseType, int exerciseLength, String exerciseComments) {
        this.dbId = dbId;
	this.memId = memId;
	this.timeStamp = timeStamp;
        this.exerciseType = exerciseType;
        this.exerciseLength = exerciseLength;
        this.exerciseComments = exerciseComments;
    }

    public int getdbId() {
	return dbId;
    }

    public setDbId(int dbId) {
	this.dbId = dbId;
    }

    public int getMemId() {
	return memId;
    }

    public void setMemId(int memId) {
	this.memId = memId;
    }

    public String getTimeStamp() {
	return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
    }

    public String getExerciseType() {
	return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
	this.exerciseType = exerciseType;
    }

    public int getExerciseLength() {
	return exerciseLength;
    }

    public void setExerciseLength(int exerciseLength) {
	this.exerciseLength = exerciseLength;
    }

    public String getExerciseComments() {
	return exerciseComments;
    }

    public void setExerciseComments(String exerciseComments) {
	this.exerciseComments = exerciseComments;
    }

    @Override
    public String toString() {
        return "Exercise{" + "dbId=" + empId + ", memId=" + memId 
                + ", timeStamp=" + timeStamp + ", exerciseType=" + exerciseType 
                + ", exerciseLength=" + exerciseLength + ", exerciseComments=" + exerciseComments + "}";
    }
}
