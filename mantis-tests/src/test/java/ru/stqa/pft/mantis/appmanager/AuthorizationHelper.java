package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by i.nechepurenko on 01.06.2017.
 */
public class AuthorizationHelper extends HelperBase {
  public AuthorizationHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password){
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"),username);
    type(By.name("password"),password);
    click(By.cssSelector("input[value='Login']"));
  }

}
