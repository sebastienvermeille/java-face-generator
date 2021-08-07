package dev.cookiecode.facegen.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum FaceEthnicity {

  // Keep it sorted alphabetically
  ASIAN("asian"),
  BLACK("black"),
  LATINO("latino"),
  WHITE("white");

  private final String restValue;

  @Override
  public String toString() {
    return restValue;
  }
}
