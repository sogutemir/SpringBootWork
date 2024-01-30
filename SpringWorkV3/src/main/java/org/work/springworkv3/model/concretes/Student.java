package org.work.springworkv3.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="student_name")
    private String name;

    @Column(name="student_surname")
    private String surname;

    @NaturalId(mutable = true)
    @Column(name="student_email")
    private String email;

    @Column(name="student_department")
    private String department;
}
