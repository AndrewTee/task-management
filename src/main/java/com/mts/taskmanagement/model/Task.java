package com.mts.taskmanagement.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
@Accessors(chain = true)
public class Task {
    @Id
    String id;
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    @UpdateTimestamp
    Timestamp localDateTime;
    @NotEmpty
    String ticket;
}
