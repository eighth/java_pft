package ru.stqa.pft.mantis.model;

/**
 * Created by i.nechepurenko on 30.05.2017.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
