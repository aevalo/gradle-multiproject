package multiproject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Enumeration;

/**
 * Xml resource bundle control
 */
public class XMLResourceBundleControl extends ResourceBundle.Control {
  /**
   * Format for this resource bundle
   */
  private static final String XML = "xml";
  /**
   * List of supported formats
   */
  private static final List<String> SINGLETON_LIST = Collections.singletonList(XML);

  /**
   * Create new resource bundle
   * @param baseName the base bundle name of the resource bundle, a fully
   *                 qualified class name
   * @param locale   the locale for which the resource bundle should be
   *                 instantiated
   * @param format   the resource bundle format to be loaded
   * @param loader   the <code>ClassLoader</code> to use to load the bundle
   * @param reload   the flag to indicate bundle reloading; <code>true</code>
   *                 if reloading an expired resource bundle,
   *                 <code>false</code> otherwise
   * @return new resource bundle
   * @throws IOException if resource reading fails
   */
  @Override
  public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
    throws IOException {
    if ((baseName == null) || (locale == null) || (format == null) || (loader == null)) {
      throw new IllegalArgumentException("baseName, locale, format and loader cannot be null");
    }
    if (!format.equals(XML)) {
      throw new IllegalArgumentException("format must be xml");
    }

    final String bundleName = toBundleName(baseName, locale);
    final String resourceName = toResourceName(bundleName, format);
    final URL url = loader.getResource(resourceName);
    if (url == null) {
      return null;
    }

    final URLConnection urlconnection = url.openConnection();
    if (urlconnection == null) {
      return null;
    }

    if (reload) {
      urlconnection.setUseCaches(false);
    }

    try (final InputStream stream = urlconnection.getInputStream();
         final BufferedInputStream bis = new BufferedInputStream(stream)) {
      return new XMLResourceBundle(bis);
    }
  }

  /**
   * Get list of supported formats
   * @param baseName the base name of the resource bundle, a fully qualified class
   *                 name
   * @return list of supported formats
   */
  @Override
  public List<String> getFormats(String baseName) {
    return SINGLETON_LIST;
  }
}
