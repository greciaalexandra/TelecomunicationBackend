package comunication.model;

import lombok.Data;

import java.util.List;

@Data
public class SpeechDto {
    private String speech;
    private List<String> keys;
}
