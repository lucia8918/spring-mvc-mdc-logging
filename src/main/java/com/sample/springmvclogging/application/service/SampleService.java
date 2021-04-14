package com.sample.springmvclogging.application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleService {

  public String doSomething(int id) {
    String result = "User Id is " + id;
    log.info("IN Service, result is {}", result);

    return result;

  }
}
