package com.siddharth.helios.entity;

import com.siddharth.helios.utility.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Table(name = "Job")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer JobId;
    String name;
    String cronExpr;
    String command;
    @LastModifiedDate
    Timestamp updatedAt;
    @CreatedDate
    Timestamp createdAt;
    Integer retries;
    Integer maxRetries = 3;
    Status status;
}
