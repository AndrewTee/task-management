package com.mts.taskmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
public class Task {
    @Id
    String id;
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    @UpdateTimestamp
    LocalDateTime localDateTime;
    @NotBlank
    String ticket;
}
