package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by i.nechepurenko on 01.06.2017.
 */
public class NavigationHelper extends HelperBase {
  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void Users() {
    click(By.cssSelector("a[href='/mantisbt-1.2.19/manage_user_page.php']"));
  }

  public void clickUser(int id) {
    click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id + "']"));
  }


  public void resetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }


  public void cheangePassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='UpdateUser']"));
  }

}
