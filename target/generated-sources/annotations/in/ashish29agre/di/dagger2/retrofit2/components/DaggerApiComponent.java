package in.ashish29agre.di.dagger2.retrofit2.components;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule;
import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule_ProvideApiFactory;
import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule_ProvideIsLoggerEnabledFactory;
import in.ashish29agre.di.dagger2.retrofit2.modules.ApiModule_ProvideOkHttpClientFactory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApiComponent implements ApiComponent {
  private Provider<Boolean> provideIsLoggerEnabledProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Api> provideApiProvider;

  private DaggerApiComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideIsLoggerEnabledProvider =
        DoubleCheck.provider(ApiModule_ProvideIsLoggerEnabledFactory.create(builder.apiModule));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            ApiModule_ProvideOkHttpClientFactory.create(
                builder.apiModule, provideIsLoggerEnabledProvider));

    this.provideApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideApiFactory.create(builder.apiModule, provideOkHttpClientProvider));
  }

  @Override
  public Api provideApi() {
    return provideApiProvider.get();
  }

  public static final class Builder {
    private ApiModule apiModule;

    private Builder() {}

    public ApiComponent build() {
      if (apiModule == null) {
        throw new IllegalStateException(ApiModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApiComponent(this);
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }
  }
}
