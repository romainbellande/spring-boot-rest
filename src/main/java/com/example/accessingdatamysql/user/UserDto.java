package com.example.accessingdatamysql.user;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
  @NotBlank
  @Size(min=2, max=30)
  private String name;

  @NotBlank(message = "Email is mandatory")
  @Email
  private String email;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
