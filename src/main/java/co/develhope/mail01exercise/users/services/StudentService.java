package co.develhope.mail01exercise.users.services;

import co.develhope.mail01exercise.users.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1","Mattia","Oleandro","mattiaoleandro@gmail.com"),
            new Student("2","Billie","Banks","billiebanks123isjnaml@gmail.com"),
            new Student("3","Mario","Rossi","mariorossi@gmail.com"),
            new Student("4","Anna","Bianchi","annabianchi@gmail.com")
    );

    public Student getStudentById(String studentId){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(studentId)) return students.get(i);
        }
        return null;
    }
}
