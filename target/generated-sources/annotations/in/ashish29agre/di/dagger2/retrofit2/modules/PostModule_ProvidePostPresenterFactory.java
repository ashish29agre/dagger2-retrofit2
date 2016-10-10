package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.ashish29agre.di.dagger2.retrofit2.PostPresenter;
import in.ashish29agre.di.dagger2.retrofit2.PostService;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PostModule_ProvidePostPresenterFactory implements Factory<PostPresenter> {
  private final PostModule module;

  private final Provider<PostService> serviceProvider;

  public PostModule_ProvidePostPresenterFactory(
      PostModule module, Provider<PostService> serviceProvider) {
    assert module != null;
    this.module = module;
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public PostPresenter get() {
    return Preconditions.checkNotNull(
        module.providePostPresenter(serviceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PostPresenter> create(
      PostModule module, Provider<PostService> serviceProvider) {
    return new PostModule_ProvidePostPresenterFactory(module, serviceProvider);
  }
}
