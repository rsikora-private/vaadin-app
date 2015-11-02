# vaadin-app

The project contains 'mvp-vaadin-spring' framework and an example how to use it.

The 'mvp-vaadin-spring' helps create a loosely coupling structure of project based on Vaadin and Spring.
The main benefit is that presenter contains reference to view whilst the view doesn't know anything about presenter.

How to use it:

1. The whole 'mvp.framework' package should be scaned and red by Spring's application context.

2. Example of presenter:

@MVPPresenter
public class UserPresenter extends PresenterImpl<AddUserView> {}

3. Example of view:

@MVPView(presenter = UserPresenter.class)
public class AddUserViewImpl implements AddUserView {}

... that's all. After it we have free access from presenter to view
