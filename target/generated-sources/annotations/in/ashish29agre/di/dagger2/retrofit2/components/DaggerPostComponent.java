package in.ashish29agre.di.dagger2.retrofit2.components;

import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import in.ashish29agre.di.dagger2.retrofit2.NetworkTest;
import in.ashish29agre.di.dagger2.retrofit2.NetworkTest_MembersInjector;
import in.ashish29agre.di.dagger2.retrofit2.PostPresenter;
import in.ashish29agre.di.dagger2.retrofit2.PostService;
import in.ashish29agre.di.dagger2.retrofit2.modules.PostModule;
import in.ashish29agre.di.dagger2.retrofit2.modules.PostModule_ProvidePostPresenterFactory;
import in.ashish29agre.di.dagger2.retrofit2.modules.PostModule_ProvidePostServiceFactory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerPostComponent implements PostComponent {
  private Provider<Api> provideApiProvider;

  private Provider<PostService> providePostServiceProvider;

  private Provider<PostPresenter> providePostPresenterProvider;

  private MembersInjector<NetworkTest> networkTestMembersInjector;

  private DaggerPostComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApiProvider =
        new Factory<Api>() {
          private final ApiComponent apiComponent = builder.apiComponent;

          @Override
          public Api get() {
            return Preconditions.checkNotNull(
                apiComponent.provideApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.providePostServiceProvider =
        DoubleCheck.provider(
            PostModule_ProvidePostServiceFactory.create(builder.postModule, provideApiProvider));

    this.providePostPresenterProvider =
        DoubleCheck.provider(
            PostModule_ProvidePostPresenterFactory.create(
                builder.postModule, providePostServiceProvider));

    this.networkTestMembersInjector =
        NetworkTest_MembersInjector.create(providePostPresenterProvider);
  }

  @Override
  public PostPresenter providePostPresenter() {
    return providePostPresenterProvider.get();
  }

  @Override
  public void inject(NetworkTest networkTest) {
    networkTestMembersInjector.injectMembers(networkTest);
  }

  public static final class Builder {
    private PostModule postModule;

    private ApiComponent apiComponent;

    private Builder() {}

    public PostComponent build() {
      if (postModule == null) {
        throw new IllegalStateException(PostModule.class.getCanonicalName() + " must be set");
      }
      if (apiComponent == null) {
        throw new IllegalStateException(ApiComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerPostComponent(this);
    }

    public Builder postModule(PostModule postModule) {
      this.postModule = Preconditions.checkNotNull(postModule);
      return this;
    }

    public Builder apiComponent(ApiComponent apiComponent) {
      this.apiComponent = Preconditions.checkNotNull(apiComponent);
      return this;
    }
  }
}
