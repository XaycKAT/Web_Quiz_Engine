package engine.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Question {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String title;
    private String text;
    private List<String> options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer answer;

}
