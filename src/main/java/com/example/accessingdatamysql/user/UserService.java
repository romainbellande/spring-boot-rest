package com.example.accessingdatamysql.user;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  private final ModelMapper modelMapper = new ModelMapper();

  public User create(UserDto userDto) {
    User user =  this.modelMapper.map(userDto, User.class);
    return this.userRepository.save(user);
  }

  public Page<User> findAll(Pageable pageable) {
    return this.userRepository.findAll(pageable);
  }
}
