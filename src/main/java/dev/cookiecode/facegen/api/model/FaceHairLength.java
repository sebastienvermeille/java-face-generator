package dev.cookiecode.facegen.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum FaceHairLength {

  // Keep it sorted from shortest to longest
  SHORT("short"),
  MEDIUM("medium"),
  LONG("long");

  private final String restValue;

  @Override
  public String toString() {
    return restValue;
  }
}
