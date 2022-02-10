package com.coderhouse.final_project.service;

import com.coderhouse.final_project.model.documents.Orden;

import javax.mail.MessagingException;

public interface EmailService {

    void sendEmail(Orden orden);
    //void sendEmailWithAttachment() throws MessagingException;

}
