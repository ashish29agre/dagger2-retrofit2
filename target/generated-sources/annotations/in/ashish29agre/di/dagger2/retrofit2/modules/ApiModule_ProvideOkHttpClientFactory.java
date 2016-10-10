package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<Boolean> logEnabledProvider;

  public ApiModule_ProvideOkHttpClientFactory(
      ApiModule module, Provider<Boolean> logEnabledProvider) {
    assert module != null;
    this.module = module;
    assert logEnabledProvider != null;
    this.logEnabledProvider = logEnabledProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClient(logEnabledProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(
      ApiModule module, Provider<Boolean> logEnabledProvider) {
    return new ApiModule_ProvideOkHttpClientFactory(module, logEnabledProvider);
  }
}
