package tech.finalproject.project.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Feedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*")
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*")
    private String lastName;

    @NotNull
    @NotBlank
    @Pattern (regexp = "(^(.+)@(\\S+)$)")
    private String email;

    @NotNull
    @NotBlank
    private String feedback;


}
