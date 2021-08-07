package dev.cookiecode.facegen.api.rest;

import dev.cookiecode.facegen.api.model.FaceAge;
import dev.cookiecode.facegen.api.model.FaceEmotion;
import dev.cookiecode.facegen.api.model.FaceEthnicity;
import dev.cookiecode.facegen.api.model.FaceEyeColor;
import dev.cookiecode.facegen.api.model.FaceGender;
import dev.cookiecode.facegen.api.model.FaceHairColor;
import dev.cookiecode.facegen.api.model.FaceHairLength;
import dev.cookiecode.facegen.api.model.FaceOrderBy;
import dev.cookiecode.facegen.api.model.FacesResponse;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Sebastien Vermeille
 */
public interface FaceResource {

  @GET("v1/faces")
  Call<FacesResponse> getFace(
      @Query("version") @Nullable Integer version,
      @Query("confidence") @Nullable Float confidence,
      @Query("emotion") @Nullable FaceEmotion emotion,
      @Query("gender") @Nullable FaceGender gender,
      @Query("age") @Nullable FaceAge age,
      @Query("ethnicity") @Nullable FaceEthnicity ethnicity,
      @Query("eye_color") @Nullable FaceEyeColor eyeColor,
      @Query("hair_color") @Nullable FaceHairColor hairColor,
      @Query("hair_length") @Nullable FaceHairLength hairLength,
      @Query("order_by") @Nullable FaceOrderBy orderBy,
      @Query("page") @Nullable Integer page,
      @Query("per_page") @Nullable Integer itemsPerPage
  );

}
