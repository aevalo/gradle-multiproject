package multiproject.app;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Map;
import java.util.stream.Stream;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import multiproject.XMLResourceBundleControl;

/**
 * Labels
 */
public class Labels {
  /**
   * Resource bundle for labels
   */
  private final ResourceBundle labels;

  /**
   * Default constructor for Labels, uses default locale
   */
  public Labels() {
    this.labels = ResourceBundle.getBundle("labels", new XMLResourceBundleControl());
  }

  /**
   * Parametrized constructor for Labels, uses specific locale locale
   * @param targetLocale locale used for loading specific labels
   */
  public Labels(Locale targetLocale) {
    this.labels = ResourceBundle.getBundle("labels", targetLocale, new XMLResourceBundleControl());
  }

  /**
   * Get value of myKey1
   * @return value of myKey1
   */
  public String myKey1() {
    return this.labels.getString("myKey1");
  }

  /**
   * Get value of myKey2
   * @return value of myKey2
   */
  public String myKey2() {
    return this.labels.getString("myKey2");
  }

  /**
   * Get value of myKey3
   * @return value of myKey3
   */
  public String myKey3() {
    return this.labels.getString("myKey3");
  }

  /**
   * Get value of myKey4
   * @return value of myKey4
   */
  public String myKey4() {
    return this.labels.getString("myKey4");
  }

  /**
   * Get value of appMessage
   * @return value of appMessage
   */
  public String appMessage() {
    return this.labels.getString("appMessage");
  }

  /**
   * Display information about all root label resources found across sub-projects
   */
  public void showAllRootKeys() {
    try {
      Enumeration<URL> resources = this.getClass().getClassLoader().getResources("labels.xml");
      Stream.Builder<Properties> propertyStreamBuilder = Stream.<Properties>builder();
      while (resources.hasMoreElements()) {
        final URL resource = resources.nextElement();
        final URLConnection urlconnection = resource.openConnection();
        if (urlconnection == null) {
          continue;
        }
        System.out.printf("Found resource: %s%n", resource);
        try (final InputStream stream = urlconnection.getInputStream();
            final BufferedInputStream bis = new BufferedInputStream(stream)) {
          Properties props = new Properties();
          props.loadFromXML(bis);
          propertyStreamBuilder.add(props);
        }
      }
      Stream<Properties> propertiesStream = propertyStreamBuilder.build();
      Properties props = propertiesStream.collect(Properties::new, Map::putAll, Map::putAll);
      Enumeration<?> propertyNames = props.propertyNames();
      while (propertyNames.hasMoreElements()) {
        Object propertyName = propertyNames.nextElement();
        System.out.printf("Property name: %s%n", propertyName);
        Object propertyValue = props.get(propertyName);
        System.out.printf("Property value: %s%n", propertyValue);
      }
    } catch (IOException ioException) {
      System.err.printf("Caught exception: %s%n", ioException);
    }
  }
}
