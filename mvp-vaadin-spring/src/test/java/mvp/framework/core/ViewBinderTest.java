package mvp.framework.core;

import mvp.framework.Presenter;
import mvp.framework.View;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;


/**
 * Created by robertsikora on 01.11.15.
 */

@RunWith(MockitoJUnitRunner.class)
public class ViewBinderTest {

    @InjectMocks
    private ViewBinder          viewBinder = new ViewBinder();
    @Mock
    private ApplicationContext  applicationContextMock;
    @Mock
    private View                mvpViewMock;
    @Mock
    private Presenter           presenterMock;

    @Test(expected = NullPointerException.class)
    public void testBindToPresenterWhenViewNull() throws Exception {
        viewBinder.bindToPresenter(null, Presenter.class);
        Mockito.verifyZeroInteractions(applicationContextMock);
    }

    @Test(expected = NullPointerException.class)
    public void testBindToPresenterWhenPresenterClassNull() throws Exception {
        viewBinder.bindToPresenter(mvpViewMock, null);
        Mockito.verifyZeroInteractions(applicationContextMock);
    }

    @Test(expected = MVPInitializeException.class)
    public void testBindToPresenterWhenThrowsException() throws Exception {
        Mockito.when(applicationContextMock.getBean(Presenter.class)).thenThrow(new RuntimeException());
        viewBinder.bindToPresenter(mvpViewMock, Presenter.class);
    }

    @Test
    public void testBindToPresenter() throws Exception {
        Mockito.when(applicationContextMock.getBean(Presenter.class)).thenReturn(presenterMock);

        viewBinder.bindToPresenter(mvpViewMock, Presenter.class);

        Mockito.verify(presenterMock).bindView(mvpViewMock);
        Mockito.verify(presenterMock).init();
    }
}