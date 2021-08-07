package dev.cookiecode.facegen.api.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Sebastien Vermeille
 */
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class FaceBuilder {

  private final Float confidence;
  private final FaceGender gender;
  private final FaceAge age;
  private final FaceEthnicity ethnicity;
  private final FaceEyeColor eyeColor;
  private final FaceHairColor hairColor;
  private final FaceHairLength hairLength;
  private final FaceEmotion emotion;

}
