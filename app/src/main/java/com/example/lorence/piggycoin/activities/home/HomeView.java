package com.example.lorence.piggycoin.activities.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;

import com.example.lorence.piggycoin.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/**
 *
 * Created by lorence on 19/12/2017.
 *
 * https://www.youtube.com/watch?v=e2y0bbhTwNU
 */

public class HomeView extends AppCompatActivity {

    /**
     * Android Studio Tutorial
     *
     *
     * 1. Basic Structure:
     * - Observable released item
     * - Subscriber use this item
     *
     * One Observable can create 0 or many item, after that, it will finish because of completion or due to an error
     * For each subscriber it has, Observable will call onNext() corresponding to the number of items it has, then
     * call onCompleted() or onError() in the result of the end.
     *
     * 2. How to create?
     * RxJava gives us 10 functions to create an Observable. In this tutorial I would like to mention only basic
     * functions, partly because of limited knowledge, the other is to avoid the tutorial becomes too long boring.
     *
     *
     */

    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mButton = findViewById(R.id.btnRxDemo);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 *
                 * 1. Observable.From() method
                 * Observable.from method takes on an unlimited number of parameters and can be type any type
                 * (Here we pass an array of 3 numbers(1, 2, 3)).
                 *
                 * Observable.subscribe() method will create a subscriber with three onCompleted(), onError() and onNext()
                 * functions to use the item passed in above!
                 *
                 */
                demoObservableFrom();


                /**
                 * 1. Observable.Just() method
                 * Observable.from method takes on an unlimited number of parameters and can be type any type
                 * (Here we pass 3 numbers(1, 2, 3)).
                 *
                 * Observable.subscribe() method will create a subscriber with three onCompleted(), onError() and onNext()
                 * functions to use the item passed in above!
                 */
                demoObservableJust();

                /**
                 * The result is same with From() method!
                 * But, what is different between From and Just ?
                 *
                 * - From: When we pass into an array or list item, it will issue an array and list that item and the subscriber
                 * will also take the parameter as an array or list.
                 *
                 * - Just: It will issue each item in the list (will call onNext times the size of the list in error condition don't available)
                 *
                 */

                demoObservableDeferVer1();

                /**
                 * 4. Observable.interval()
                 * We will create task with call after 2 seconds and after 6 times it will finish!
                 * Interval will be useful when we want to schedule update data
                 * Ex: Update data after 2 seconds
                 */
                demoObservableInterval();

                /**
                 *
                 * 5. Observable.create()
                 * DEMO
                 */
                demoObservableCreate();
                /**
                 * SUMMARIZE
                 *
                 * 5. Observable.create()
                 * It give us result same to Observable.just(1, 2, 3)
                 *
                 * Create() method also provides behavior as defer() - stores the value of the item
                 * when subscribe, not initialized
                 * However, In most cases. You shouldn't use this function because it has some rules
                 * That we must follow as only called Subscriber.onCompleted() or Subscriber.onError()
                 * only once and are not.
                 */
            }
        });
    }

    private void demoObservableCreate() {
        Observable.create(new Observable.OnSubscribe<Integer>(){

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("onNext-Create", String.valueOf(integer));
            }
        });
    }

    private void demoObservableInterval() {
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                if (aLong == 5) {
                    unsubscribe();
                }
                Log.i("onNext", String.valueOf(aLong));
            }
        });
    }

    private void demoObservableFrom() {
        Observable.from(new Integer[]{1, 2, 3}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer i) {
                // Log.i("onNext", String.valueOf(i));
            }
        });
    }

    private void demoObservableJust() {
        Observable.just(1, 2, 3).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("onNext", String.valueOf(integer));
            }
        });
    }

    /**
     *
     * 3. Observable.defer()
     * - Let see below codes
     *
     * Why it don't show "Guardian of Galaxy"? It is a new data so we will want to show
     * newest data
     *
     * It shows "Fast & Furious 8" because this is value is created when just() method be called.
     * All other method will save value of item when Observable is created, not when Observable
     * is subscribe by one Subscriber.
     *
     * In many case, we will want to our data is newest, so if we don't subscribe as soon as create
     * the we have data is not newest
     * So what is answer or solution for this case ? Defer will help us
     *
     */

    private void demoObservableDefer() {
        Movie movie = new Movie("Fast and Furious 8");
        Observable<Movie> movieObservable = Observable.just(movie);
        movie = new Movie("Guardian of Galaxy");
        movieObservable.subscribe(new Subscriber<Movie>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Movie movie) {
                Log.i("onNext", movie.getName());
            }
        });
    }

    private void demoObservableDeferVer1() {
        Movie movie = new Movie("Fast and Furious 8");
        final Movie finalMovie = movie;
        Observable<Movie> movieObservable = Observable.defer(new Func0<Observable<Movie>>() {
            @Override
            public Observable<Movie> call() {
                return Observable.just(finalMovie);
            }
        });
        movie = new Movie("Guardian of Galaxy");
        movieObservable.subscribe(new Subscriber<Movie>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Movie movie) {
                Log.i("onNext", movie.getName());
            }
        });
    }

     class Movie {
        public String name;

        public Movie(String s) {
            name = s;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
