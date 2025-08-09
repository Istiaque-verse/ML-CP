package com.mlcp.mlcp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "problems")
public class Problem {
    @Id
    private Long id;

    private String title;
    private String description;
    private String link;
    private String topics;

    // Getters and Setters


}
