package dev.cookiecode.facegen.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum FaceHairColor {
  // Keep it sorted alphabetically
  BLACK("black"),
  BLOND("blond"),
  BROWN("brown"),
  GRAY("gray"),
  RED("red");

  private final String restValue;

  @Override
  public String toString() {
    return restValue;
  }
}

