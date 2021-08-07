package dev.cookiecode.facegen.api.model;

/**
 * @author Sebastien Vermeille
 */
public enum FaceOrderBy {
  LATEST,
  OLDEST,
  RANDOM;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
