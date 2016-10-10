package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideIsLoggerEnabledFactory implements Factory<Boolean> {
  private final ApiModule module;

  public ApiModule_ProvideIsLoggerEnabledFactory(ApiModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Boolean get() {
    return Preconditions.checkNotNull(
        module.provideIsLoggerEnabled(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Boolean> create(ApiModule module) {
    return new ApiModule_ProvideIsLoggerEnabledFactory(module);
  }
}
