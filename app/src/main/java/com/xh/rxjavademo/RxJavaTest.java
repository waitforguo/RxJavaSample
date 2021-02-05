package com.xh.rxjavademo;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.xh.rxjavademo.bean.ExtendConfigResponseBean;
import com.xh.rxjavademo.bean.ResponseBean2;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author FuZhiXue(Fran)
 * @date 2021/1/20 10:27 AM
 */
public class RxJavaTest {
    private final static String TAG = RxJavaTest.class.getSimpleName();

    public static void rxJavaTest() {
        Log.i(TAG, "rxJavaTest");
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "开始采用onSubscribe连接");
            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.i(TAG, "对Next事件" + value + "作出响应");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "对Complete事件作出响应");
            }
        };
        observable.subscribe(observer);
    }

    public static void rxJavaTestIO() {
        Log.i(TAG, "rxJavaTestIO");
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "开始采用onSubscribe连接");
            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.i(TAG, "对Next事件" + value + "作出响应");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "对Complete事件作出响应");
            }
        });
    }

    public static void rxJavaJust() {
        Log.i(TAG, "rxJavaJust");
        Observable.just(1, 2, 3, 4)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.i(TAG, "对Next事件" + value + "作出响应");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaArray() {
        Log.i(TAG, "rxJavaArray");
        Integer[] items = new Integer[]{1, 2, 3, 4};
        Observable.fromArray(items)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.i(TAG, "对Next事件" + value + "作出响应");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });


        Log.i(TAG, "rxJavaArrayList");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Observable.fromArray(list)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull List<Integer> values) {
                        Log.i(TAG, "对Next事件" + values.toString() + "作出响应");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });

        Log.i(TAG, "fromIterable");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        Observable.fromIterable(list1)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.i(TAG, "对Next事件" + value + "作出响应");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaTime() {
        Log.i(TAG, "rxJavaTime");
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Long value) {
                        Log.i(TAG, "对Next事件" + value + "作出响应");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaInterval() {
        Log.i(TAG, "rxJavaInterval");
        Observable.intervalRange(1, 10, 2, 1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Long value) {
                        Log.i(TAG, "对Next事件" + value + "作出响应");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaTestMap1() {
        Disposable disposable = Observable.just(1)
                .map(new Function<Integer, Integer>() {
                    @NonNull
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        Log.i(TAG, "初始化数据库");
                        return 1;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer value) throws Exception {
                        Log.i(TAG, "处理事件：value = " + value);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.i(TAG, "抛出异常：throwable = " + throwable.getMessage());
                    }
                });
//        disposable.dispose();
    }

    public static void rxJavaMap2() {
        Disposable disposable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @NonNull
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "使用 Map变换操作符 将事件" + integer + "的参数从 整型" + integer + " 变换成 字符串类型" + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i(TAG, s);
            }
        });
    }

    public static void rxJavaFlatMap() {
        Log.i(TAG, "\r\n\r\nflatMap");
        Disposable disposable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @NonNull
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i(TAG, s);
            }
        });
    }

    public static void rxJavaConcatMap() {
        Log.i(TAG, "\r\n\r\nconcatMap");
        Disposable disposable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @NonNull
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i(TAG, s);
            }
        });
    }

    public static void rxJavaBuffer() {
        Log.i(TAG, "\r\n\r\nBuffer");
        Observable.just(1, 2, 3, 4, 5)
                .buffer(3, 1)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "开始采用onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull List<Integer> stringList) {
                        Log.d(TAG, " 缓存区里的事件数量 = " + stringList.size());
                        for (Integer value : stringList) {
                            Log.d(TAG, " 事件 = " + value);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaConcat() {
        Log.d(TAG, "\r\n\r\nconcat");
        Observable.concat(Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });

        Log.d(TAG, "\r\n\r\nconcatArray");
        Observable.concatArray(Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12),
                Observable.just(13, 14, 15))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaMerge() {
        Log.d(TAG, "\r\n\r\nmerge");
        Observable.merge(Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaConcatDelayError() {
        Log.i(TAG, "没使用concatDelayError");
        Observable.concat(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }), Observable.just(4, 5, 6))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });

        Log.i(TAG, "使用concatDelayError");
        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }), Observable.just(4, 5, 6))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaMergeArrayDelayError() {
        Log.i(TAG, "没使用mergeArrayDelayError");
        Observable.merge(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }), Observable.just(4, 5, 6))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });

        Log.i(TAG, "使用mergeArrayDelayError");
        Observable.mergeArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }), Observable.just(4, 5, 6))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaZip() {
        Log.i(TAG, "\r\n\r\nzip");
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "被观察者1发送了事件1");
                emitter.onNext(1);
                // 为了方便展示效果，所以在发送事件后加入1s的延迟
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者1发送了事件2");
                emitter.onNext(2);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者1发送了事件3");
                emitter.onNext(3);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者1发送了onComplete");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()); // 设置被观察者1在工作线程1中工作

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                Log.d(TAG, "被观察者2发送了事件A");
                emitter.onNext("A");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者2发送了事件B");
                emitter.onNext("B");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者2发送了事件C");
                emitter.onNext("C");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者2发送了事件D");
                emitter.onNext("D");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                Log.d(TAG, "被观察者2发送了onComplete");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @NonNull
            @Override
            public String apply(@NonNull Integer value1, @NonNull String value2) throws Exception {
                return value1 + value2;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String value) {
                Log.d(TAG, "最终接收到的事件 =  " + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });
    }

    public static void rxJavaCombineLatest() {
        Log.i(TAG, "\r\ncombineLatest");
        Disposable disposable = Observable.combineLatest(Observable.just(1L, 2L, 3L),
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                new BiFunction<Long, Long, Long>() {
                    @NonNull
                    @Override
                    public Long apply(@NonNull Long aLong, @NonNull Long aLong2) throws Exception {
                        Log.e(TAG, "合并的数据是： " + aLong + " " + aLong2);
                        return aLong + aLong2;
                    }
                }).subscribe(new Consumer<Long>() {
            @Override
            public void accept(@NonNull Long aLong) throws Exception {
                Log.e(TAG, "合并的结果是： " + aLong);
            }
        });
    }

    public static void rxJavaReduce() {
        Disposable disposable = Observable.just(1, 2, 3, 4)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @NonNull
                    @Override
                    public Integer apply(@NonNull Integer s1, @NonNull Integer s2) throws Exception {
                        Log.e(TAG, "本次计算的数据是： " + s1 + " 乘 " + s2);
                        // 原理：第1次取前2个数据相乘，之后每次获取到的数据 = 返回的数据x原始下1个数据
                        return s1 * s2;
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "最终计算的结果是： " + integer);
                    }
                });
    }

    public static void rxJavaCollect() {
        Disposable disposable = Observable.just(1, 2, 3, 4, 5, 6).collect(new Callable<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> call() throws Exception {
                return new ArrayList<>();
            }
        }, new BiConsumer<ArrayList<Integer>, Integer>() {
            @Override
            public void accept(ArrayList<Integer> list, Integer integer) throws Exception {
                list.add(integer);
            }
        }).subscribe(new BiConsumer<ArrayList<Integer>, Throwable>() {
            @Override
            public void accept(ArrayList<Integer> integers, Throwable throwable) throws Exception {
                Log.e(TAG, "本次发送的数据是： " + integers);
            }
        });
    }

    public static void rxJavaStartWithArray() {
        Log.i(TAG, "\r\nstartWithArray");
        Observable.just(4, 5, 6)
                .startWith(0)
                .startWithArray(1, 2, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });

        Log.i(TAG, "\r\n\r\nstartWithArray222");
        Disposable disposable = Observable.just(4, 5, 6)
                .startWith(0)
                .startWithArray(1, 2, 3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer value) throws Exception {
                        Log.d(TAG, "接收到了事件" + value);
                    }
                });

        Log.d(TAG, "\r\n\r\n\r\n startWith ===>Observable ");
        Observable.just(4, 5, 6)
                .startWith(Observable.just(1, 2, 3))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaCount() {
        Disposable disposable = Observable.just(1, 2, 3, 4)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "发送的事件数量 =  " + aLong);
                    }
                });
    }

    public static void rxJavaDoAction() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Throwable("发生错误了"));
            }
        }).doOnEach(new Consumer<Notification<Integer>>() {
            @Override
            public void accept(@NonNull Notification<Integer> integerNotification) throws Exception {
                Log.d(TAG, "doOnEach: " + integerNotification.getValue());
            }
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d(TAG, "doOnNext: " + integer);
            }
        }).doAfterNext(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d(TAG, "doAfterNext: " + integer);
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "doOnComplete: ");
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Log.d(TAG, "doOnError: " + throwable.getMessage());
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(@NonNull Disposable disposable) throws Exception {
                Log.e(TAG, "doOnSubscribe: ");
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "doAfterTerminate: ");
            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "doFinally: ");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }

    public static void rxJavaOnErrorReturn() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("发生错误了"));
            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            @NonNull
            @Override
            public Integer apply(@NonNull Throwable throwable) throws Exception {
                // 捕捉错误异常
                Log.e(TAG, "在onErrorReturn处理了错误: " + throwable.toString());
                return 666;
                // 发生错误事件后，发送一个"666"事件，最终正常结束
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }

    public static void rxJavaOnErrorResumeNext() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("发生错误了"));
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @NonNull
            @Override
            public ObservableSource<? extends Integer> apply(@NonNull Throwable throwable) throws Exception {
                // 1. 捕捉错误异常
                Log.e(TAG, "在onErrorReturn处理了错误: " + throwable.toString());

                // 2. 发生错误事件后，发送一个新的被观察者 & 发送事件序列
                return Observable.just(11, 22);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }

    public static void rxJavaOnExceptionResumeNext() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
            }
        }).onExceptionResumeNext(new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {
                observer.onNext(11);
                observer.onNext(22);
                observer.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }

    public static void rxJavaRetry() {
        Log.e(TAG, "\r\nretry");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
            }
        }).retry().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });

        Log.e(TAG, "\r\nretry（long time）");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        }).retry(3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });

        Log.e(TAG, "\r\nretry（Predicate predicate）");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        }).retry(new Predicate<Throwable>() {
            @Override
            public boolean test(@NonNull Throwable throwable) throws Exception {
                // 捕获异常
                Log.e(TAG, "retry错误: " + throwable.toString());

                //返回false = 不重新重新发送数据 & 调用观察者的onError结束
                //返回true = 重新发送请求（若持续遇到错误，就持续重新发送）
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });

        Log.e(TAG, "\r\nretry（new BiPredicate<Integer, Throwable>）");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        }).retry(new BiPredicate<Integer, Throwable>() {
            @Override
            public boolean test(@NonNull Integer integer, @NonNull Throwable throwable) throws Exception {
                // 捕获异常
                Log.e(TAG, "异常错误 =  " + throwable.toString());

                // 获取当前重试次数
                Log.e(TAG, "当前重试次数 =  " + integer);

                //返回false = 不重新重新发送数据 & 调用观察者的onError结束
                //返回true = 重新发送请求（若持续遇到错误，就持续重新发送）
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });

        Log.e(TAG, "\r\nretry（long time,Predicate predicate）");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        }).retry(3, new Predicate<Throwable>() {
            @Override
            public boolean test(@NonNull Throwable throwable) throws Exception {
                // 捕获异常
                Log.e(TAG, "retry错误: " + throwable.toString());

                //返回false = 不重新重新发送数据 & 调用观察者的onError（）结束
                //返回true = 重新发送请求（最多重新发送3次）
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer value) {
                Log.d(TAG, "接收到了事件" + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "对Error事件作出响应，e:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }

    public static void rxJavaRetryWhen() {
        Log.e(TAG, "\r\nretryWhen");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NotNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        })
                // 遇到error事件才会回调
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {

                    @Override
                    public ObservableSource<?> apply(@NonNull Observable<Throwable> throwableObservable) throws Exception {
                        // 参数Observable<Throwable>中的泛型 = 上游操作符抛出的异常，可通过该条件来判断异常的类型
                        // 返回Observable<?> = 新的被观察者 Observable（任意类型）
                        // 此处有两种情况：
                        // 1. 若 新的被观察者 Observable发送的事件 = Error事件，那么 原始Observable则不重新发送事件：
                        // 2. 若 新的被观察者 Observable发送的事件 = Next事件 ，那么原始的Observable则重新发送事件：
                        return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {

                                // 1. 若返回的Observable发送的事件 = Error事件，则原始的Observable不重新发送事件
                                // 该异常错误信息可在观察者中的onError（）中获得
                                return Observable.error(new Throwable("retryWhen终止啦"));

                                // 2. 若返回的Observable发送的事件 = Next事件，则原始的Observable重新发送事件（若持续遇到错误，则持续重试）
//                                 return Observable.just(1);
                            }
                        });

                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应" + e.toString());
                        // 获取异常错误信息
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    public static void rxJavaRepeat() {
        Log.e(TAG, "\r\nrepeat");
        Observable.just(1, 2, 3, 4)
                .repeat(3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应：" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });

        Log.e(TAG, "\r\nrepeatWhen");
        Observable.just(1, 2, 4)
                .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
                    // 在Function函数中，必须对输入的 Observable<Object>进行处理，这里我们使用的是flatMap操作符接收上游的数据
                    @NonNull
                    @Override
                    public ObservableSource<?> apply(@NonNull Observable<Object> objectObservable) throws Exception {
                        // 将原始 Observable 停止发送事件的标识（Complete（） /  Error（））转换成1个 Object 类型数据传递给1个新被观察者（Observable）
                        // 以此决定是否重新订阅 & 发送原来的 Observable
                        // 此处有2种情况：
                        // 1. 若新被观察者（Observable）返回1个Complete（） /  Error（）事件，则不重新订阅 & 发送原来的 Observable
                        // 2. 若新被观察者（Observable）返回其余事件，则重新订阅 & 发送原来的 Observable
                        return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {
                            @NonNull
                            @Override
                            public ObservableSource<?> apply(@NonNull Object o) throws Exception {
                                // 情况1：若新被观察者（Observable）返回1个Complete（） /  Error（）事件，则不重新订阅 & 发送原来的 Observable
                                return Observable.empty();
                                // Observable.empty() = 发送Complete事件，但不会回调观察者的onComplete（）

//                                return Observable.error(new Throwable("不再重新订阅事件"));
                                // 返回Error事件 = 回调onError（）事件，并接收传过去的错误信息。

                                // 情况2：若新被观察者（Observable）返回其余事件，则重新订阅 & 发送原来的 Observable
//                                return Observable.just(3);
                                // 仅仅是作为1个触发重新订阅被观察者的通知，发送的是什么数据并不重要，只要不是Complete（） /  Error（）事件
                            }
                        });
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应：" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    /**
     * （无条件）网络请求轮询
     */
    public static void rxJavaIntervalRetrofit() {
        /*
         * 步骤1：采用interval（）延迟发送
         * 注：此处主要展示无限次轮询，若要实现有限次轮询，仅需将interval（）改成intervalRange（）即可
         **/
        Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS)
                // 参数说明：
                // 参数1 = 第1次延迟时间；
                // 参数2 = 间隔时间数字；
                // 参数3 = 时间单位；
                // 该例子发送的事件特点：延迟2s后发送事件，每隔1秒产生1个数字（从0开始递增1，无限个）

                /*
                 * 步骤2：每次发送数字前发送1次网络请求（doOnNext（）在执行Next事件前调用）
                 * 即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
                 **/
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.d(TAG, "第 " + aLong + " 次轮询");

                        /**
                         * 步骤3：通过Retrofit发送网络请求
                         */
                        // a. 创建Retrofit对象
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://dict.xh.com:8087") // 设置 网络请求 Url
                                .addConverterFactory(GsonConverterFactory.create()) // 设置使用Gson解析(记得加入依赖)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                                .build();

                        // b. 创建 网络请求接口 的实例
                        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

                        // c. 采用Observable<...>形式 对 网络请求 进行封装
                        Observable<ExtendConfigResponseBean> observable = request.getCall();

                        // d. 通过线程切换发送网络请求
                        observable.subscribeOn(Schedulers.io()) // 切换到IO线程进行网络请求
                                .observeOn(AndroidSchedulers.mainThread()) // 切换回到主线程 处理请求结果
                                .subscribe(new Observer<ExtendConfigResponseBean>() {
                                    @Override
                                    public void onSubscribe(@NonNull Disposable d) {
                                        Log.i(TAG, "request 里面的onSubscribe");
                                    }

                                    @Override
                                    public void onNext(@NonNull ExtendConfigResponseBean bean) {
                                        // e.接收服务器返回的数据
                                        bean.show();
                                    }

                                    @Override
                                    public void onError(@NonNull Throwable e) {
                                        Log.d(TAG, "请求失败");
                                    }

                                    @Override
                                    public void onComplete() {
                                        Log.i(TAG, "request 里面的 onComplete");
                                    }
                                });
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Log.i(TAG, "事件onNext：" + aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    // 设置变量 = 模拟轮询服务器次数
    private static int i = 0;

    /**
     * （有条件）网络请求轮询
     */
    public static void rxJavaRepeatWhenRetrofit() {
        i = 0;
        // 步骤1：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dict.xh.com:8087") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) // 设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .build();

        // 步骤2：创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        // 步骤3：采用Observable<...>形式 对 网络请求 进行封装
        Observable<ExtendConfigResponseBean> observable = request.getCall();

        // 步骤4：发送网络请求 & 通过repeatWhen（）进行轮询
        observable.repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {

            // 在Function函数中，必须对输入的 Observable<Object>进行处理，此处使用flatMap操作符接收上游的数据
            @NonNull
            @Override
            public ObservableSource<?> apply(@NonNull Observable<Object> objectObservable) throws Exception {
                // 将原始 Observable 停止发送事件的标识（Complete（） /  Error（））转换成1个 Object 类型数据传递给1个新被观察者（Observable）
                // 以此决定是否重新订阅 & 发送原来的 Observable，即轮询
                // 此处有2种情况：
                // 1. 若返回1个Complete（） /  Error（）事件，则不重新订阅 & 发送原来的 Observable，即轮询结束
                // 2. 若返回其余事件，则重新订阅 & 发送原来的 Observable，即继续轮询
                return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {
                    @NonNull
                    @Override
                    public ObservableSource<?> apply(@NonNull Object o) throws Exception {
                        // 加入判断条件：当轮询次数 = 5次后，就停止轮询
                        if (i > 3) {
                            // 此处选择发送onError事件以结束轮询，因为可触发下游观察者的onError（）方法回调
                            return Observable.error(new Throwable("轮询结束"));
                        }
                        // 若轮询次数＜4次，则发送1Next事件以继续轮询
                        // 注：此处加入了delay操作符，作用 = 延迟一段时间发送（此处设置 = 2s），以实现轮询间间隔设置
                        return Observable.just(1).delay(2000, TimeUnit.MILLISECONDS);
                    }
                });
            }
        }).subscribeOn(Schedulers.io()) // 切换到IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread()) // 切换回到主线程 处理请求结果
                .subscribe(new Observer<ExtendConfigResponseBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "onSubscribe连接");
                    }

                    @Override
                    public void onNext(@NonNull ExtendConfigResponseBean bean) {
                        // e.接收服务器返回的数据
                        bean.show();
                        i++;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        // 获取轮询结束信息
                        Log.d(TAG, e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    /**
     * 网络请求嵌套回调
     */
    public static void rxJavaNestedRetrofit() {
        // 定义Observable接口类型的网络请求对象
        Observable<ExtendConfigResponseBean> observable1;
        Observable<ResponseBean2> observable2;

        // 步骤1：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                // 设置 网络请求 Url
                .baseUrl("http://dict.xh.com:8087")
                // 设置使用Gson解析(记得加入依赖)
                .addConverterFactory(GsonConverterFactory.create())
                //  支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        // 步骤2：创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        // 步骤3：采用Observable<...>形式 对 2个网络请求 进行封装
        observable1 = request.getCall();
        observable2 = request.getCall2();

        // （初始被观察者）切换到IO线程进行网络请求1
        Disposable disposable = observable1.subscribeOn(Schedulers.io())
                // （新观察者）切换到主线程 处理网络请求1的结果
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<ExtendConfigResponseBean>() {
                    @Override
                    public void accept(@NonNull ExtendConfigResponseBean bean) throws Exception {
                        Log.d(TAG, "第1次网络请求成功");
                        bean.show();
                    }
                })
                // （新被观察者，同时也是新观察者）切换到IO线程去发起 第二个请求
                .observeOn(Schedulers.io())
                // 特别注意：因为flatMap是对初始被观察者作变换，所以对于旧被观察者，它是新观察者，所以通过observeOn切换线程
                // 但对于初始观察者，它则是新的被观察者
                .flatMap(new Function<ExtendConfigResponseBean, ObservableSource<ResponseBean2>>() {
                    // 作变换，即作嵌套网络请求
                    @NonNull
                    @Override
                    public ObservableSource<ResponseBean2> apply(@NonNull ExtendConfigResponseBean bean) throws Exception {
                        Log.i(TAG, "flatMap中的第一个请求先打印后变换为第二个请求");
                        bean.show();
                        // 将网络请求1转换成网络请求2，即发送网络请求2
                        return observable2;
                    }
                })
                // （初始观察者）切换到主线程 处理网络请求2的结果
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBean2>() {
                    @Override
                    public void accept(@NonNull ResponseBean2 responseBean2) throws Exception {
                        Log.d(TAG, "第2次网络请求成功");
                        responseBean2.show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "第二次请求失败");
                    }
                });
    }

    /**
     * 通过Merge合并网络数据
     */
    public static void rxJavaMergeData() {
        List<String> result = new ArrayList<>();
        /*
         * 设置第1个Observable：通过网络获取数据
         * 此处仅作网络请求的模拟
         **/
        Observable<String> observableNetwork = Observable.just("网络");

        /*
         * 设置第2个Observable：通过本地文件获取数据
         * 此处仅作本地文件请求的模拟
         **/
        Observable<String> observableLocal = Observable.just("本地");

        // 通过merge（）合并事件 & 同时发送事件
        Observable.merge(observableNetwork, observableLocal)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String value) {
                        Log.d(TAG, "数据源有： " + value);
                        result.add(value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "获取数据完成");
                        Log.d(TAG, result.toString());
                    }
                });
    }

    /**
     * Zip合并数据
     */
    public static void rxJavaZipMergeData() {
        // 定义Observable接口类型的网络请求对象
        Observable<ExtendConfigResponseBean> observable1;
        Observable<ResponseBean2> observable2;

        // 步骤1：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                // 设置 网络请求 Url
                .baseUrl("http://dict.xh.com:8087")
                // 设置使用Gson解析(记得加入依赖)
                .addConverterFactory(GsonConverterFactory.create())
                // 支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        // 步骤2：创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        // 步骤3：采用Observable<...>形式 对 2个网络请求 进行封装
        observable1 = request.getCall()
                // 新开线程进行网络请求1
                .subscribeOn(Schedulers.io());
        observable2 = request.getCall2()
                // 新开线程进行网络请求2
                .subscribeOn(Schedulers.io());
        // 即2个网络请求异步 & 同时发送

        // 步骤4：通过使用Zip（）对两个网络请求进行合并再发送
        Disposable disposable = Observable.zip(observable1, observable2, new BiFunction<ExtendConfigResponseBean, ResponseBean2, List<String>>() {
            // 注：创建BiFunction对象传入的第3个参数 = 合并后数据的数据类型
            @NonNull
            @Override
            public List<String> apply(@NonNull ExtendConfigResponseBean extendConfigResponseBean, @NonNull ResponseBean2 responseBean2) throws Exception {
                List<String> list = new ArrayList<>();
                list.add("第一条请求数据： " + extendConfigResponseBean.show());
                list.add("第二条请求数据： " + responseBean2.show());
                return list;
            }
        })
                // 在主线程接收 & 处理数据
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    // 成功返回数据时调用
                    @Override
                    public void accept(@NonNull List<String> strings) throws Exception {
                        // 结合显示2个网络请求的数据结果
                        Log.d(TAG, "最终接收到的数据是：" + strings.toString());
                    }
                }, new Consumer<Throwable>() {
                    // 网络请求错误时调用
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.d(TAG, "请求失败，" + throwable.getMessage());
                    }
                });

    }

    /**
     * 从磁盘 / 内存缓存中 获取数据
     */
    public static void rxJavaGetData() {
        // 该2变量用于模拟内存缓存 & 磁盘缓存中的数据
        String memoryCache = null;
        String diskCache = "从磁盘缓存中获取数据";

        // 设置第1个Observable：检查内存缓存是否有该数据的缓存
        Observable<String> observableMemory = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                // 先判断内存缓存有无数据
                if (null != memoryCache) {
                    // 若有该数据，则发送
                    emitter.onNext(memoryCache);
                } else {
                    // 若无该数据，则直接发送结束事件
                    emitter.onComplete();
                }
            }
        });

        // 设置第2个Observable：检查磁盘缓存是否有该数据的缓存
        Observable<String> observableDisk = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                // 先判断磁盘缓存有无数据
                if (null != diskCache) {
                    emitter.onNext(diskCache);
                } else {
                    emitter.onComplete();
                }
            }
        });

        // 设置第3个Observable：通过网络获取数据
        Observable<String> observableNetwork = Observable.just("从网络中获取数据");
        // 此处仅作网络请求的模拟

        /**
         * 通过concat（） 和 firstElement（）操作符实现缓存功能
         * 1. 通过concat（）合并memory、disk、network 3个被观察者的事件（即检查内存缓存、磁盘缓存 & 发送网络请求）
         * 并将它们按顺序串联成队列
         */
        Disposable disposable = Observable.concat(observableMemory, observableDisk, observableNetwork)
                .subscribeOn(Schedulers.io())
                // 2. 通过firstElement()，从串联队列中取出并发送第1个有效事件（Next事件），即依次判断检查memory、disk、network
                /**
                 * 即本例的逻辑为：
                 * a. firstElement()取出第1个事件 = memory，即先判断内存缓存中有无数据缓存；由于memoryCache = null，即内存缓存中无数据，所以发送结束事件（视为无效事件）
                 * b. firstElement()继续取出第2个事件 = disk，即判断磁盘缓存中有无数据缓存：由于diskCache ≠ null，即磁盘缓存中有数据，所以发送Next事件（有效事件）
                 * c. 即firstElement()已发出第1个有效事件（disk事件），所以停止判断。
                 */
                .firstElement()
                .observeOn(AndroidSchedulers.mainThread())
                // 3. 观察者订阅
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.d(TAG, "最终获取的数据来源 =  " + s);
                    }
                });
    }

    /**
     * rxJava线程切换
     */
    public static void rxJavaThreadChanged() {
        Retrofit retrofit = new Retrofit.Builder()
                // 设置 网络请求 Url
                .baseUrl("http://dict.xh.com:8087")
                // 设置使用Gson解析(记得加入依赖)
                .addConverterFactory(GsonConverterFactory.create())
                // 支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        // 步骤5：创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        // 步骤6：采用Observable<...>形式 对 网络请求 进行封装
        Observable<ExtendConfigResponseBean> observable = request.getCall();

        // 步骤7：发送网络请求
        Disposable disposable = observable.subscribeOn(Schedulers.io()) // 在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread()) // 回到主线程 处理请求结果
                .subscribe(new Consumer<ExtendConfigResponseBean>() {
                    @Override
                    public void accept(@NonNull ExtendConfigResponseBean bean) throws Exception {
                        // 步骤8：对返回的数据进行处理
                        bean.show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.d(TAG, "请求失败");
                    }
                });
    }

    public static void rxJavaSchedulers() {
        // 步骤1：创建被观察者 Observable & 发送事件
        // 在主线程创建被观察者 Observable 对象
        // 所以生产事件的线程是：主线程

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

                Log.d(TAG, " 被观察者 Observable的工作线程是: " + Thread.currentThread().getName());
                // 打印验证
                emitter.onNext(1);
                emitter.onComplete();
            }
        });

        // 步骤2：创建观察者 Observer 并 定义响应事件行为
        // 在主线程创建观察者 Observer 对象
        // 所以接收 & 响应事件的线程是：主线程
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
                Log.d(TAG, " 观察者 Observer的工作线程是: " + Thread.currentThread().getName());
                // 打印验证
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "对Next事件" + value + "作出响应");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        };

        // 步骤3：通过订阅（subscribe）连接观察者和被观察者
//        observable.subscribe(observer);

//        // 指定多个被观察者线程，只有第一个指定有效
//        observable.subscribeOn(Schedulers.newThread()) // 第一次指定被观察者线程 = 新线程
//                .subscribeOn(AndroidSchedulers.mainThread()) // 第二次指定被观察者线程 = 主线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        // 指定多个观察者线程，每个都会走、指定一次切换一次
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) // 第一次指定观察者线程 = 主线程
                .doOnNext(new Consumer<Integer>() { // 生产事件
                    @Override
                    public void accept(@NotNull Integer value) throws Exception {
                        Log.i(TAG, "第一次观察者事件是：" + value);
                        Log.d(TAG, "第一次观察者Observer的工作线程是： " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.newThread()) // 第二次指定观察者线程 = 新的工作线程
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer value) throws Exception {
                        Log.i(TAG, "第二次观察者事件是：" + value);
                        Log.d(TAG, "第二次观察者Observer的工作线程是： " + Thread.currentThread().getName());
                    }
                })
                .subscribe(observer); // 生产事件
    }

    // 设置变量
    /**
     * 可重试次数
     */
    private static final int MAX_CONNECT_COUNT = 10;
    // 当前已重试次数
    private static int currentRetryCount = 0;
    // 重试等待时间
    private static int waitRetryTime = 0;

    public static Disposable rxJavaRetryConnect() {
        currentRetryCount = 0;
        waitRetryTime = 0;

        Log.e(TAG, "开始请求网络，如果有网络问题，会重试10次");

        // 步骤1：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                // 设置 网络请求 Url
                .baseUrl("http://dict.xh.com:8087")
                // 设置使用Gson解析(记得加入依赖)
                .addConverterFactory(GsonConverterFactory.create())
                // 支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //  步骤2：创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        // 步骤3：采用Observable<...>形式 对 网络请求 进行封装
        Observable<ExtendConfigResponseBean> observable = request.getCall();

        // 步骤4：发送网络请求 & 通过retryWhen（）进行重试
        // 注：主要异常才会回调retryWhen（）进行重试
        Disposable disposable = observable.retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @NonNull
            @Override
            public ObservableSource<?> apply(@NonNull Observable<Throwable> throwableObservable) throws Exception {
                // 参数Observable<Throwable>中的泛型 = 上游操作符抛出的异常，可通过该条件来判断异常的类型
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @NonNull
                    @Override
                    public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {
                        // 输出异常信息
                        Log.d(TAG, "发生异常 = " + throwable.toString());
                        /**
                         * 需求1：根据异常类型选择是否重试
                         * 即，当发生的异常 = 网络异常 = IO异常 才选择重试
                         */
                        if (throwable instanceof IOException) {
                            Log.d(TAG, "属于IO异常，需重试");
                            /**
                             * 需求2：限制重试次数
                             * 即，当已重试次数 < 设置的重试次数，才选择重试
                             */
                            if (currentRetryCount < MAX_CONNECT_COUNT) {
                                // 记录重试次数
                                currentRetryCount++;
                                Log.d(TAG, "重试次数 = " + currentRetryCount);
                                /**
                                 * 需求2：实现重试
                                 * 通过返回的Observable发送的事件 = Next事件，从而使得retryWhen（）重订阅，最终实现重试功能
                                 *
                                 * 需求3：延迟1段时间再重试
                                 * 采用delay操作符 = 延迟一段时间发送，以实现重试间隔设置
                                 *
                                 * 需求4：遇到的异常越多，时间越长
                                 * 在delay操作符的等待时间内设置 = 每重试1次，增多延迟重试时间1s
                                 */
                                // 设置等待时间
                                waitRetryTime = 1000 + (currentRetryCount * 1000);
                                Log.d(TAG, "等待时间 =" + waitRetryTime);
                                return Observable.just(1).delay(waitRetryTime, TimeUnit.MILLISECONDS);
                            } else {
                                // 若重试次数已 > 设置重试次数，则不重试
                                // 通过发送error来停止重试（可在观察者的onError（）中获取信息）
                                return Observable.error(new Throwable("重试次数已超过设置次数 = " + currentRetryCount + "，即 不再重试"));
                            }
                        } else {
                            // 若发生的异常不属于I/O异常，则不重试
                            // 通过返回的Observable发送的事件 = Error事件 实现（可在观察者的onError（）中获取信息）
                            return Observable.error(new Throwable("发生了非网络异常（非I/O异常）"));
                        }
                    }
                });
            }
        })
                // 切换到IO线程进行网络请求
                .subscribeOn(Schedulers.io())
                // 切换回到主线程 处理请求结果
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExtendConfigResponseBean>() {
                    @Override
                    public void accept(@NonNull ExtendConfigResponseBean bean) throws Exception {
                        // 接收服务器返回的数据
                        Log.d(TAG, "发送成功");
                        bean.show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable e) throws Exception {
                        // 获取停止重试的信息
                        Log.d(TAG, e.toString());
                    }
                });
        return disposable;
    }
} 
