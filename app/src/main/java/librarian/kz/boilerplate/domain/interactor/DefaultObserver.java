package librarian.kz.boilerplate.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class DefaultObserver<T> extends DisposableObserver<T>
{
    @Override public void onNext(T t) {
        // no-op by default.
    }

    @Override public void onComplete() {
        // no-op by default.
    }

    @Override public void onError(Throwable exception) {
        // no-op by default.
    }
}