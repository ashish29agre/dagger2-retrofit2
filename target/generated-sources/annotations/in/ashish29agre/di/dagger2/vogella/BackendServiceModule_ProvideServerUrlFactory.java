package in.ashish29agre.di.dagger2.vogella;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BackendServiceModule_ProvideServerUrlFactory implements Factory<String> {
  private final BackendServiceModule module;

  public BackendServiceModule_ProvideServerUrlFactory(BackendServiceModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public String get() {
    return Preconditions.checkNotNull(
        module.provideServerUrl(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<String> create(BackendServiceModule module) {
    return new BackendServiceModule_ProvideServerUrlFactory(module);
  }
}
