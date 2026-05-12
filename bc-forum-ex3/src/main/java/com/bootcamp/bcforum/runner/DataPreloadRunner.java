package com.bootcamp.bcforum.runner;

import com.bootcamp.bcforum.service.ForumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataPreloadRunner implements CommandLineRunner {

  private final ForumService forumService;

  public DataPreloadRunner(ForumService forumService) {
    this.forumService = forumService;
  }

  @Override
  public void run(String... args) {
    forumService.preloadData();
  }
}
