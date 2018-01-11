package com.crud.tasks.check;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.service.MailCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailCheck {

    @Autowired
    private MailCreatorService mailCreatorService;

    public String checkMail(final Mail mail) {
        String message = null;
        if (mail.getSubject() == "Tasks: New Trello card") {
             message = mailCreatorService.buildTrelloCardEmail(mail.getMessage());
        } else {
           message = mailCreatorService.buildReportEmail(mail.getMessage());
        }
        return message;
    }
}
