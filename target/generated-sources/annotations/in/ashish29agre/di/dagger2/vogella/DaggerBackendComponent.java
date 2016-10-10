package in.ashish29agre.di.dagger2.vogella;

import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBackendComponent implements BackendComponent {
  private Provider<String> provideTestUrlProvider;

  private Provider<User> userProvider;

  private Provider<BackendService> proviedBackendServiceModuleProvider;

  private MembersInjector<TestApp> testAppMembersInjector;

  private DaggerBackendComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static BackendComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideTestUrlProvider =
        BackendServiceModule_ProvideTestUrlFactory.create(builder.backendServiceModule);

    this.userProvider = DoubleCheck.provider(UserModule_UserFactory.create(builder.userModule));

    this.proviedBackendServiceModuleProvider =
        DoubleCheck.provider(
            BackendServiceModule_ProviedBackendServiceModuleFactory.create(
                builder.backendServiceModule, provideTestUrlProvider, userProvider));

    this.testAppMembersInjector =
        TestApp_MembersInjector.create(userProvider, proviedBackendServiceModuleProvider);
  }

  @Override
  public BackendService proviedBackendServiceModule() {
    return proviedBackendServiceModuleProvider.get();
  }

  @Override
  public void inject(TestApp app) {
    testAppMembersInjector.injectMembers(app);
  }

  public static final class Builder {
    private BackendServiceModule backendServiceModule;

    private UserModule userModule;

    private Builder() {}

    public BackendComponent build() {
      if (backendServiceModule == null) {
        this.backendServiceModule = new BackendServiceModule();
      }
      if (userModule == null) {
        this.userModule = new UserModule();
      }
      return new DaggerBackendComponent(this);
    }

    public Builder userModule(UserModule userModule) {
      this.userModule = Preconditions.checkNotNull(userModule);
      return this;
    }

    public Builder backendServiceModule(BackendServiceModule backendServiceModule) {
      this.backendServiceModule = Preconditions.checkNotNull(backendServiceModule);
      return this;
    }
  }
}
