package dev.cookiecode.facegen;

import lombok.Getter;

/**
 * @author Sebastien Vermeille
 */
public class FaceGenerator {

  private final String apiKey;
  private final boolean paidLicense;

  @Getter
  private final FaceService faceService;

  private FaceGenerator(final Builder builder) {
    apiKey = builder.apiKey;
    paidLicense = builder.paidLicense;
    faceService = new FaceService(apiKey, paidLicense);
  }

  public static Builder newBuilder(final FaceGenerator copy) {
    final Builder builder = new Builder();
    builder.paidLicense = copy.paidLicense;
    builder.apiKey = copy.apiKey;
    return builder;
  }

  public static IApiKey builder() {
    return new Builder();
  }


  public interface IBuild {

    FaceGenerator build();
  }

  public interface IPaidLicense {

    IBuild withPaidLicense(boolean val);
  }

  public interface IApiKey {

    IPaidLicense withApiKey(String val);
  }

  public static final class Builder implements IPaidLicense, IApiKey, IBuild {

    private boolean paidLicense;
    private String apiKey;

    private Builder() {
    }

    @Override
    public IBuild withPaidLicense(final boolean val) {
      paidLicense = val;
      return this;
    }

    @Override
    public IPaidLicense withApiKey(final String val) {
      apiKey = val;
      return this;
    }

    @Override
    public FaceGenerator build() {
      return new FaceGenerator(this);
    }
  }
}
