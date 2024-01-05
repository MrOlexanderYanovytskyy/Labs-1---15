import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
class Student
{
    private String name;
    private int course;
    public Student(String name, int course)
    {
        this.name = name;
        this.course = course;
    }
    public String getName()
    {
        return name;
    }
    public int getCourse()
    {
        return course;
    }
}

public class Main
{
    public static void printStudents(List<Student> students, int targetCourse)
    {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext())
        {
            Student student = iterator.next();
            if (student.getCourse() == targetCourse)
            {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args)
    {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Магур", 1));
        studentList.add(new Student("Данило", 2));
        studentList.add(new Student("Токар", 1));
        studentList.add(new Student("Коля", 3));
        studentList.add(new Student("Тимур", 2));
        studentList.add(new Student("Влада", 1));
        studentList.add(new Student("Віктор", 3));
        studentList.add(new Student("Юлія", 2));
        studentList.add(new Student("Олександр", 1));
        studentList.add(new Student("Тетяна", 3));
        int targetCourse = 2;
        System.out.println("Студенти на " + targetCourse + " курсі:");
        printStudents(studentList, targetCourse);
    }
}
