package com.google.gfx.services.mail;

/**
 * Sends email to users or mailing lists.
 */
public interface MailService {

  /**
   * Sends an email.
   *
   * @param emailAddress a user's or mailing list email address
   * @param title the email title
   * @param body the email message body
   */
  void sendMail(String emailAddress, String title, String body);
}
