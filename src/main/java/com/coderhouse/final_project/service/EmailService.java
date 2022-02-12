package com.coderhouse.final_project.service;

import com.coderhouse.final_project.model.documents.Orden;


public interface EmailService {

    void sendEmail(Orden orden);

}
