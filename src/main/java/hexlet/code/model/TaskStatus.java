package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "task_statuses")
public class TaskStatus extends BaseEntity {
    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 1000)
    private String name;

    public TaskStatus(Long aLong) {
    }
}
