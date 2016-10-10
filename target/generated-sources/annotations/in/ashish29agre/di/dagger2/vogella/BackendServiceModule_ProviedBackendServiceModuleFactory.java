package in.ashish29agre.di.dagger2.vogella;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BackendServiceModule_ProviedBackendServiceModuleFactory
    implements Factory<BackendService> {
  private final BackendServiceModule module;

  private final Provider<String> serverUrlProvider;

  private final Provider<User> userProvider;

  public BackendServiceModule_ProviedBackendServiceModuleFactory(
      BackendServiceModule module,
      Provider<String> serverUrlProvider,
      Provider<User> userProvider) {
    assert module != null;
    this.module = module;
    assert serverUrlProvider != null;
    this.serverUrlProvider = serverUrlProvider;
    assert userProvider != null;
    this.userProvider = userProvider;
  }

  @Override
  public BackendService get() {
    return Preconditions.checkNotNull(
        module.proviedBackendServiceModule(serverUrlProvider.get(), userProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<BackendService> create(
      BackendServiceModule module,
      Provider<String> serverUrlProvider,
      Provider<User> userProvider) {
    return new BackendServiceModule_ProviedBackendServiceModuleFactory(
        module, serverUrlProvider, userProvider);
  }
}
