package guru.sf.sfgid.configurations;

import guru.sf.sfgid.services.CustomProps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppProps {
    @Value("${guru.test.user}")
    private String user;

    @Value("${guru.test.pwd}")
    private String pwd;

    @Value("${guru.test.url}")
    private String url;

    @Bean
    public CustomProps getCustProps() {
        CustomProps props = new CustomProps();
        props.setUser(this.user);
        props.setPwd(this.pwd);
        props.setUrl(this.url);
        return props;
    }
}
