package mvp.framework.core;

import com.vaadin.navigator.ViewChangeListener;
import mvp.framework.MVPView;
import mvp.framework.Presenter;
import mvp.framework.View;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Created by robertsikora on 01.11.15.
 */

@RunWith(MockitoJUnitRunner.class)
public class BindPostProcessorTest {

    @InjectMocks
    private BindPostProcessor   bindPostProcessor = new BindPostProcessor();
    @Mock
    private ViewBinder          viewBinder;
    @Mock
    private Presenter           presenterMock;

    @Test
    public void testPostProcessAfterInitializationForFailureCase() throws Exception {
        bindPostProcessor.postProcessAfterInitialization(new FailureCase(), "");
        Mockito.verifyZeroInteractions(viewBinder);
    }

    @Test
    public void testPostProcessAfterInitializationForPositiveCaseAndNullPresenter() throws Exception {
        final PositiveCase positiveMvpView = new PositiveCase();

        bindPostProcessor.postProcessAfterInitialization(positiveMvpView, "");

        Mockito.verify(viewBinder).bindToPresenter(positiveMvpView, Presenter.class);
    }

    @MVPView(presenter = Presenter.class)
    private final static class PositiveCase implements View{
        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
        }
    }

    @Deprecated
    private final static class FailureCase implements View {
        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
        }
    }
}