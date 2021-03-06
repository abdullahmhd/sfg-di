package guru.sf.sfgid.configurations;

import guru.sf.sfgid.services.CustomJmsProps;
import guru.sf.sfgid.services.CustomProps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource({"classpath:custom.properties", "classpath:jms-props.properties"})
@PropertySources({
        @PropertySource("classpath:jms-props.properties")
})
public class PropertyConfig {

    @Value("${guru.jms.jmsUser}")
    private String jmsUser;

    @Value("${guru.jms.jmsPwd}")
    private String jmsPwd;

    @Value("${guru.jms.jmsUrl}")
    private String jmsUrl;

    @Bean
    public CustomJmsProps getCustomJmsProps() {
        CustomJmsProps jmsProps = new CustomJmsProps();
        jmsProps.setJmsUser(this.jmsUser);
        jmsProps.setJmsPwd(this.jmsPwd);
        jmsProps.setJmsUrl(this.jmsUrl);

        return jmsProps;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
