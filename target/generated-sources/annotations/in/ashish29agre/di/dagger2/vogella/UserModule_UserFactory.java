package in.ashish29agre.di.dagger2.vogella;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserModule_UserFactory implements Factory<User> {
  private final UserModule module;

  public UserModule_UserFactory(UserModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public User get() {
    return Preconditions.checkNotNull(
        module.user(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<User> create(UserModule module) {
    return new UserModule_UserFactory(module);
  }
}
