package com.bootcamp.events.customEvents;

import org.springframework.stereotype.Component;

/**
 * Created by priyanka on 31/3/17.
 */

public class Email {

    String tomail;
    String fromMail;
    String subject;
    String body;

    public String getTomail() {
        return tomail;
    }

    public void setTomail(String tomail) {
        this.tomail = tomail;
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "tomail='" + tomail + '\'' +
                ", fromMail='" + fromMail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public void setBody(String body) {
        this.body = body;
    }
}
