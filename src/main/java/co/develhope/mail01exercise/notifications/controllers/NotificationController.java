package co.develhope.mail01exercise.notifications.controllers;

import co.develhope.mail01exercise.notifications.entities.NotificationDTO;
import co.develhope.mail01exercise.notifications.services.NotificationService;
import co.develhope.mail01exercise.users.entities.Student;
import co.develhope.mail01exercise.users.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class NotificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification")
    public ResponseEntity<String> sendEmailToStudent(@RequestBody NotificationDTO notificationDTO){
        try {
            Student student = studentService.getStudentById(notificationDTO.getContactId());
            System.out.println("Getting the student: " + student);
            if(student == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not finder the student");
            }
            notificationService.sendTo(student.getEmail(), notificationDTO.getTitle(), notificationDTO.getText());
            return ResponseEntity.status(HttpStatus.OK).body("Send mail successful!");
        }catch (Exception e){
            System.err.println("Error in notification controller: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
