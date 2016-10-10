package in.ashish29agre.di.dagger2.vogella;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TestApp_MembersInjector implements MembersInjector<TestApp> {
  private final Provider<User> userProvider;

  private final Provider<BackendService> backendServiceProvider;

  public TestApp_MembersInjector(
      Provider<User> userProvider, Provider<BackendService> backendServiceProvider) {
    assert userProvider != null;
    this.userProvider = userProvider;
    assert backendServiceProvider != null;
    this.backendServiceProvider = backendServiceProvider;
  }

  public static MembersInjector<TestApp> create(
      Provider<User> userProvider, Provider<BackendService> backendServiceProvider) {
    return new TestApp_MembersInjector(userProvider, backendServiceProvider);
  }

  @Override
  public void injectMembers(TestApp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.user = userProvider.get();
    instance.backendService = backendServiceProvider.get();
  }

  public static void injectUser(TestApp instance, Provider<User> userProvider) {
    instance.user = userProvider.get();
  }

  public static void injectBackendService(
      TestApp instance, Provider<BackendService> backendServiceProvider) {
    instance.backendService = backendServiceProvider.get();
  }
}
