import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Map;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String engDepartment;
    private int yearOfEnrollment;
    private double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    public String toString()
    {
        return this.name;
    }

}
class StudentStreamProc {

    private ArrayList<Student> source;

    public StudentStreamProc(ArrayList<Student> source)
    {
        this.source = source;
    }

    private Stream<Student> newStream()
    {
        return source.stream();
    }

    public void printAllDepartments()
    {
        Stream<Student> studentStream = newStream();

        Stream<String> uniqueDepts = studentStream.map(Student::getEngDepartment).distinct();
        uniqueDepts.forEach(p -> System.out.println(p));
    }

    public void printEnrolledAfter(int year)
    {
        Stream<Student> studentStream = newStream();

        Stream<Integer> enrolledAfterYear = studentStream.map(Student::getYearOfEnrollment).filter(y -> y > year);

        enrolledAfterYear.forEach(i -> System.out.println(i));
    }

    public void printGenderInDept(String gender, String dept)
    {
        Stream<Student> genderInDept = newStream().filter(p -> p.getGender().equals(gender) &&
                p.getEngDepartment().equals(dept));

        genderInDept.forEach(student -> System.out.println(student.getName()));
    }

    public void countMaleAndFemaleStudents()
    {
        int maleCount = countStudentsByGender("Male");
        int femaleCount = countStudentsByGender("Female");
        System.out.println("Males: " + maleCount);
        System.out.println("Females: " + femaleCount);
    }

    public void averageMaleAndFemaleAge()
    {
        int maleCount = countStudentsByGender("Male");
        int maleAge = countAgeByGender("Male");
        double maleAvg = (double) maleAge/maleCount;

        int femaleCount = countStudentsByGender("Female");
        int femaleAge = countAgeByGender("Female");
        double femaleAvg = (double) femaleAge/femaleCount;

        System.out.println("Male average: (" + maleCount + " " + maleAge + ") " + maleAvg);
        System.out.println("Female average: (" + femaleCount + " " + femaleAge + ") " + femaleAvg);
    }

    private int countAgeByGender(String gender) {
        Stream<Student> studentGender = newStream().filter(p -> p.getGender().equals(gender));

        Stream<Integer> studentAges = studentGender.map(Student::getAge);

        return studentAges.reduce(0, Integer::sum);
    }

    private int countStudentsByGender(String gender) {
        Stream<Student> studentGender = newStream().filter(p -> p.getGender().equals(gender));

        return (int) studentGender.count();
    }

    public void printHighestPercentStudent()
    {
        Student newStudent = new Student(0, null, 0, null,
                null, 0, 0);

        Student highestStudent = newStream().reduce(newStudent,
                (p, q) -> (p.getPerTillDate() > q.getPerTillDate()) ? p : q);

        System.out.println(highestStudent.getName());
    }

    public void printDeptCount()
    {
        System.out.println(newStream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting())));
    }

    public void youngestMaleStudent(String dept)
    {
        Stream<Student> deptStream= newStream().filter(p -> p.getEngDepartment().equals(dept));
        Student youngest = deptStream.min(Comparator.comparing(Student::getAge)).get();
        System.out.println(youngest.getName());
    }

    public void averagePerInDepts()
    {
        Map<String, Double> deptAvgPer = newStream().collect(Collectors.groupingBy(Student::getEngDepartment,
                Collectors.averagingDouble(Student::getPerTillDate)));

        for (String dept :
                deptAvgPer.keySet()) {
            System.out.println(dept + " average percentage: " + deptAvgPer.get(dept));
        }
    }

    public void printGenderCountInDept(String dept)
    {

        Stream<Student> males = getDeptStream(dept).filter(p -> p.getGender().equals("Male"));
        Stream<Student> females = getDeptStream(dept).filter(p -> p.getGender().equals("Male"));

        System.out.println("Males: " + males.count() + "\nFemales: " + females.count());
    }

    private Stream<Student> getDeptStream(String dept) {
        return newStream().filter(p -> p.getEngDepartment().equals(dept));
    }
}
public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students = getStudentList();

        StudentStreamProc streamProc = new StudentStreamProc(students);

        // Each line answers the respective question in the Classroom assignment
        streamProc.printAllDepartments();
        streamProc.printEnrolledAfter(2018);
        streamProc.printGenderInDept("Male", "Computer Science");
        streamProc.countMaleAndFemaleStudents();
        streamProc.averageMaleAndFemaleAge();
        streamProc.printHighestPercentStudent();
        streamProc.printDeptCount();
        streamProc.averagePerInDepts();
        streamProc.youngestMaleStudent("Electrical");
        streamProc.printGenderCountInDept("Computer Science");
    }

    public static ArrayList<Student> getStudentList()
    {
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student(111, "Jiya Brein", 17, "Female",
                "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male",
                "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male",
                "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male",
                "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female",
                "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male",
                "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male",
                "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male",
                "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female",
                "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male",
                "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female",
                "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male",
                "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female",
                "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male",
                "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male",
                "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female",
                "Electrical", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male",
                "Computer Science", 2017, 57.5));

        return studentList;
    }
}