package section3_apis.part2_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * YOUR CHALLENGE:
 * Class Course models a teaching course. How are you going to store the students grades in here?
 */
public class Course {
    private int courseId;
    private String courseName;
    private Map<Integer, Integer> grade = new HashMap<Integer, Integer>();

    public Course(final int courseId, String courseName, studentId, int grade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.grade.put(studentId, grade);
    }

    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {return this.courseName;}

    public int getGrade() {return this.grade;}

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Course course = (Course) o;
        return this.courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.courseId);
    }
}
