package com.mr13.colorchart.components.auth.controller;

import com.mr13.colorchart.components.auth.domain.ColorChartUserDetails;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {

  private final ProducerService producerService;

  @Value("${spring.profiles.active}")
  private String profile;

  @GetMapping
  public String main(Model model, @AuthenticationPrincipal ColorChartUserDetails user) {

    List<Producer> allProducers = producerService.getAllProducer();

    HashMap<Object, Object> data = new HashMap<>();

    data.put("profile", user);
    data.put("producers", allProducers);

    model.addAttribute("frontendData", data);
    model.addAttribute("isDevMode", "dev".equals(profile));

    return "index";
  }
}
