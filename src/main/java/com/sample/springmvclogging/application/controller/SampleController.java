package com.sample.springmvclogging.application.controller;


import com.sample.springmvclogging.application.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/samples")
public class SampleController {

  private final SampleService sampleService;

  @GetMapping("/{id}")
  public String get(@PathVariable int id) {
    log.info("IN Controller, Do something....");
    return sampleService.doSomething(id);
  }

}
