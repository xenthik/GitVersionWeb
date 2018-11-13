package shared.util.common;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This class provides application-wide access to the Application Context. Should be used only in
 * exceptional scenarios.
 *
 * @author Vivek
 */
public class ApplicationContextProvider implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    // Wiring the ApplicationContext into a static field.
    context = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return context;
  }

  /**
   * Convenience method to directly retrieve the bean from the application context.
   */
  public static <T> T getBean(Class<T> type) throws BeansException {
    return context.getBean(type);
  }

  /**
   * Convenience method to directly retrieve all beans of a given type from the application context.
   */
  public static <T> Map<String, T> getBeans(Class<T> type) throws BeansException {
    return context.getBeansOfType(type);
  }

}