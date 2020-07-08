package com.example.accessingdatamysql.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springdoc.core.annotations.RouterOperation;

import javax.validation.Valid;

import com.example.accessingdatamysql.utils.ResponsePage;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public @ResponseBody ResponsePage<User> getAllUsers(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "name") String sort) {
    Sort sortValue = Sort.by(Order.asc(sort));
    Pageable paging = PageRequest.of(page, size, sortValue);
    // This returns a JSON or XML with the users
    Page<User> userPage = this.userService.findAll(paging);
    return new ResponsePage<User>(userPage);
  }
}
