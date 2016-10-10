package in.ashish29agre.di.dagger2.retrofit2;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkTest_MembersInjector implements MembersInjector<NetworkTest> {
  private final Provider<PostPresenter> presenterProvider;

  public NetworkTest_MembersInjector(Provider<PostPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<NetworkTest> create(Provider<PostPresenter> presenterProvider) {
    return new NetworkTest_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(NetworkTest instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      NetworkTest instance, Provider<PostPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
