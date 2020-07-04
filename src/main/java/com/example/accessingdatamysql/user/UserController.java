package com.example.accessingdatamysql.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springdoc.core.annotations.RouterOperation;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller // This means that this class is a Controller
@Validated
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping(path="") // Map ONLY POST Requests
  public @ResponseBody User addNewUser (@Valid @RequestBody UserDto userDto) {
    return this.userService.create(userDto);
  }

  @GetMapping(path="")
  public @ResponseBody Collection<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return this.userService.findAll();
  }
}
