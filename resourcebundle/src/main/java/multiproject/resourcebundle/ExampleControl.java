package multiproject.resourcebundle;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ExampleControl
 */
public class ExampleControl extends ResourceBundle.Control {
  /**
   * Get candidate locales for base name and desired locale
   * @param s      the base name of the resource bundle, a fully
   *               qualified class name
   * @param locale the locale for which a resource bundle is desired
   * @return list of candidate locales
   */
  @Override
  public List<Locale> getCandidateLocales(String s, Locale locale) {
    return Arrays.asList(new Locale("pl", "PL"));
  }
}
