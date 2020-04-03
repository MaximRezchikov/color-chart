package com.mr13.colorchart.components.auth.controller;

import com.mr13.colorchart.components.auth.domain.ColorChartUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

  @GetMapping
  public String main(Model model, @AuthenticationPrincipal ColorChartUserDetails user) {

    HashMap<Object, Object> data = new HashMap<>();
    data.put("profile", user);

    model.addAttribute("frontendData", data);
    return "index";
  }
}
