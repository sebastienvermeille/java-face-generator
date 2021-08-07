package dev.cookiecode.facegen.api.rest;

import static lombok.AccessLevel.NONE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.cookiecode.facegen.api.FaceImageDeserializer;
import dev.cookiecode.facegen.api.model.FaceImage;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Sebastien Vermeille
 */
@NoArgsConstructor(access = NONE)
public class ApiClient {

  private static final String FACE_API_BASE_URL = "https://api.generated.photos/api/";

  private static Converter.Factory createGsonConverter() {
    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(FaceImage.class, new FaceImageDeserializer());
    final Gson gson = gsonBuilder.create();
    return GsonConverterFactory.create(gson);
  }

  private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(FACE_API_BASE_URL)
      .addConverterFactory(createGsonConverter());

  private static final HttpLoggingInterceptor logging
      = new HttpLoggingInterceptor()
      .setLevel(HttpLoggingInterceptor.Level.BASIC);

  public static Retrofit retrofit = builder.build();

  private static final OkHttpClient.Builder httpClient
      = new OkHttpClient.Builder();

  public static <S> S createService(@NonNull final Class<S> serviceClass) {

    if (!httpClient.interceptors().contains(logging)) {
      httpClient.addInterceptor(logging);
      builder.client(httpClient.build());
      retrofit = builder.build();
    }
    return retrofit.create(serviceClass);
  }

  public static <S> S createService(@NonNull final Class<S> serviceClass,
      @NonNull final String apiToken) {

    httpClient.interceptors().clear();
    httpClient.addInterceptor(chain -> {
      final var original = chain.request();
      final var request = original.newBuilder()
          .header("Authorization", "API-Key " + apiToken)
          .build();
      return chain.proceed(request);
    });
    return createService(serviceClass);
  }

}
