package com.university.crud.springbootcrudrest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.university.crud.springbootcrudrest.model.base.BaseEntity;
import lombok.*;


@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    //@SequenceGenerator(sequenceName = "student_seq", allocationSize = 1, name = "student_seq")
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    //@FutureOrPresent
    private LocalDate dob;

    @Email
    private String email;

    @Min(value = 18, message = "Age must be greater than 18 to get admission")
    private int age;

}
