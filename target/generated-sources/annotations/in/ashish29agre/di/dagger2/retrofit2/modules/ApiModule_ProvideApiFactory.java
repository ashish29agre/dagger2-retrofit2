package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideApiFactory implements Factory<Api> {
  private final ApiModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public ApiModule_ProvideApiFactory(
      ApiModule module, Provider<OkHttpClient> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Api get() {
    return Preconditions.checkNotNull(
        module.provideApi(okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Api> create(ApiModule module, Provider<OkHttpClient> okHttpClientProvider) {
    return new ApiModule_ProvideApiFactory(module, okHttpClientProvider);
  }
}
