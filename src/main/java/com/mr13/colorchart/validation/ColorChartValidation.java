package com.mr13.colorchart.validation;

import org.springframework.stereotype.Component;

@Component
public class ColorChartValidation {

  public String checkPigmentIndex(String pigmentIndex) {

    if (pigmentIndex.contains("R")||pigmentIndex.contains("K")) {

      String letterToChange = pigmentIndex.substring(2, 3);
      String letterToReplace = letterToChange.toLowerCase();
      return pigmentIndex.replace(letterToChange, letterToReplace);
    } else {
      return pigmentIndex;
    }
  }
}
