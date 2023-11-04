package HomeWork.Lesson_11.Model;

public class Teacher extends User {
    protected int teacherId;

    public Teacher(String firstName, String lastName, String patronymic, int teacherId) {
        super(firstName, lastName, patronymic);
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }


    @Override
    public String toString() {
        return "Teacher" + "[" + super.toString() + ", id = " + teacherId + "]";
    }

}
