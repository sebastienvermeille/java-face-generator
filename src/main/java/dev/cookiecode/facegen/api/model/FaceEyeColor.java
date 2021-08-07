package dev.cookiecode.facegen.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum FaceEyeColor {

  // Keep it sorted alphabetically
  BLUE("blue"),
  BROWN("brown"),
  GRAY("gray"),
  GREEN("green");

  private final String restValue;

  @Override
  public String toString() {
    return restValue;
  }
}
