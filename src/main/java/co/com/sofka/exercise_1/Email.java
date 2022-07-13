package co.com.sofka.exercise_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    private Integer id;
    private String domain;
    private Boolean status;

}
