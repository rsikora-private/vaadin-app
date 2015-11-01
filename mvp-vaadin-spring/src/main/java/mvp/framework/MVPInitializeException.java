package mvp.framework;

/**
 * Occurs due to failure during MVP pattern initialization.
 *
 * Created by robertsikora on 01.11.15.
 */
public class MVPInitializeException extends RuntimeException {

    public MVPInitializeException(final String message) {
        super(message);
    }

    public MVPInitializeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
