package org.work.springbootwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String department;
    private String position;
    private double salary;

}
