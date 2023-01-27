package hexlet.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL", unique = true)

    private String email;

    @NotBlank
    @Column(name="FIRSTNAME")
    private String firstName;

    @NotBlank
    @Column(name="LASTNAME")
    private String lastName;

    @NotBlank
    @JsonIgnore
    @Column(name="PASSWORD")
    private String password;

    @CreationTimestamp
    @Column(name="CREATEDAT")
    private Date createdAt;

    public User(final Long id) {
        this.id = id;
    }

}