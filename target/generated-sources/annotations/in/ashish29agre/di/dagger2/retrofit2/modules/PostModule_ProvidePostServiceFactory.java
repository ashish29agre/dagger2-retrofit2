package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import in.ashish29agre.di.dagger2.retrofit2.PostService;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PostModule_ProvidePostServiceFactory implements Factory<PostService> {
  private final PostModule module;

  private final Provider<Api> apiProvider;

  public PostModule_ProvidePostServiceFactory(PostModule module, Provider<Api> apiProvider) {
    assert module != null;
    this.module = module;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public PostService get() {
    return Preconditions.checkNotNull(
        module.providePostService(apiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PostService> create(PostModule module, Provider<Api> apiProvider) {
    return new PostModule_ProvidePostServiceFactory(module, apiProvider);
  }
}
