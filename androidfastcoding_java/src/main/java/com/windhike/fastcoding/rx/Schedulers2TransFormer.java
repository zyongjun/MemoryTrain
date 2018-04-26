package com.windhike.fastcoding.rx;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gzzyj on 2016/10/27.
 */

public class Schedulers2TransFormer {

    private static final ObservableTransformer computationTransformer =
            new ObservableTransformer() {
                @Override
                public ObservableSource apply(Observable upstream) {
                    return  upstream.subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread());
                }
            };
    private static final ObservableTransformer ioTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final ObservableTransformer newTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final ObservableTransformer trampolineTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.trampoline())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final ObservableTransformer executorTransformer = new ObservableTransformer() {

        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.from(ExecutorManager.eventExecutor))
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    /**
     * Don't break the chain: use RxJava's compose() operator
     */
    public static <T> ObservableTransformer<T, T> applyComputationSchedulers() {
        return (ObservableTransformer<T, T>) computationTransformer;
    }
    public static <T> ObservableTransformer<T, T> applyIoSchedulers() {
        return (ObservableTransformer<T, T>) ioTransformer;
    }
    public static <T> ObservableTransformer<T, T> applyNewSchedulers() {
        return (ObservableTransformer<T, T>) newTransformer;
    }
    public static <T> ObservableTransformer<T, T> applyTrampolineSchedulers() {
        return (ObservableTransformer<T, T>) trampolineTransformer;
    }
    public static <T> ObservableTransformer<T, T> applyExecutorSchedulers() {
        return (ObservableTransformer<T, T>) executorTransformer;
    }
}
