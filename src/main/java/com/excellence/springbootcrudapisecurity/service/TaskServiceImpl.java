package com.excellence.springbootcrudapisecurity.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.excellence.springbootcrudapisecurity.models.Task;
import com.excellence.springbootcrudapisecurity.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskEmailService {
    private final TaskRepository taskRepository;
    private final EmailService emailService;

    public TaskServiceImpl(TaskRepository taskRepository, EmailService emailService) {
        this.taskRepository = taskRepository;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 */1 * * * *")
    @Override
    public void sendTaskDueReminders() {
        List<Task> dueTasks = taskRepository.dueDate(LocalDateTime.now());
        for (Task task : dueTasks) {
            String subject = "Task Due Reminder";
            String content = "Your task '" + task.getTitle() + "' is due soon!";
            emailService.sendEmail(task.getAssignedUser().getEmail(), subject, content);
        }
    }
}
