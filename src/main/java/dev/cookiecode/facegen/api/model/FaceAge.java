package dev.cookiecode.facegen.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum FaceAge {

  // Keep it sorted from youngest to oldest
  INFANT("infant"),
  CHILD("child"),
  YOUNG_ADULT("young-adult"),
  ADULT("adult"),
  ELDERLY("elderly");

  private final String restValue;

  @Override
  public String toString() {
    return restValue;
  }
}
