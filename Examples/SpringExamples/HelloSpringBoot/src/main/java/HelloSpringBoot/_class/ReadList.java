package HelloSpringBoot._class;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("dbtypes")
@Data
public class ReadList {
    private List<String> name;
}
