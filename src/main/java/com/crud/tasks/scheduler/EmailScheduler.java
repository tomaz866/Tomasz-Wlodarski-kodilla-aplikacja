package com.crud.tasks.scheduler;

import com.crud.tasks.check.Report;
import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private Report report;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Tasks: Once a day email";

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        String t = " tasks.";
        if(report.countTasks() == 1) { t = " task."; }
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                "Currently in database you got: " + report.countTasks() + t, null));
    }
}
