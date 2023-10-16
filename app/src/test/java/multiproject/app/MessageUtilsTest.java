package multiproject.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MessageUtilsTest
 */
class MessageUtilsTest {
  /**
   * Test getting message
   */
  @Test void testGetMessage() {
    assertEquals("Hello      World!", MessageUtils.getMessage());
  }
}
