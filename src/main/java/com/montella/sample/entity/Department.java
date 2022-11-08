package com.montella.sample.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add the department name")
//    @Email
//    @Positive
//    @PositiveOrZero
//    @FutureOrPresent
//    @Past// you can validate any field in the controller
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
