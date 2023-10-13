package multiproject.app;

import java.util.Locale;
import java.util.ResourceBundle;

public class Labels {
  private final ResourceBundle labels;

  public Labels() {
    this.labels = ResourceBundle.getBundle("labels", new XMLResourceBundleControl());
  }

  public Labels(Locale targetLocale) {
    this.labels = ResourceBundle.getBundle("labels", targetLocale, new XMLResourceBundleControl());
  }

  public String myKey1() {
    return this.labels.getString("myKey1");
  }

  public String myKey2() {
    return this.labels.getString("myKey2");
  }

  public String myKey3() {
    return this.labels.getString("myKey3");
  }
}
