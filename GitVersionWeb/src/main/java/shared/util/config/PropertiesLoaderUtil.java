package shared.util.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesLoaderUtil extends PropertyPlaceholderConfigurer {
  private static final String MY_APP_ID = "my.app.id";
  private Map<String, String> propertiesMap;

  @Override
  @SuppressWarnings({ "deprecation", "rawtypes" })
  protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
      throws BeansException {
    super.processProperties(beanFactory, props);

    propertiesMap = new HashMap<String, String>();
    for (Object key : props.keySet()) {
      String keyStr = key.toString();
      propertiesMap.put(keyStr, parseStringValue(props.getProperty(keyStr), props, new HashSet()));
    }

  }

  public String getProperty(String name) {
    return propertiesMap.get(name);
  }

  public String getMyAppId() {
    return propertiesMap.get(MY_APP_ID);
  }
}
