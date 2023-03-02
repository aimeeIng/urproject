package com.finalproject.urproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private String gender;
    private String email;
    private String password;
    private String role;

    @OneToMany(targetEntity = Leave.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empname", referencedColumnName ="id")
    private List<Leave> leave;

}
