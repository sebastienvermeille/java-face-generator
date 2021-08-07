package dev.cookiecode.facegen.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum FaceGender {
  // keep it sorted alphabetically
  FEMALE("female"),
  MALE("male");

  private final String restValue;

  @Override
  public String toString() {
    return restValue;
  }
}
