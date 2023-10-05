package com.yoandroide.schooldashboard.model;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NotEmpty
    private String name;
    @NotNull
    @OneToOne
    private Identification dni;
    @NotEmpty
    private String lastName;
    private Integer age;
    @NotEmpty
    private String address;
    @Email
    private String email;
}
