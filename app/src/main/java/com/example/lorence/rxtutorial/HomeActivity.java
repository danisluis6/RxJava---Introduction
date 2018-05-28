package com.example.lorence.rxtutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Maybe way1 = (Maybe<List<Node>>) testGetNodes();
        Maybe<List<Node>> way2 = Maybe.create(new MaybeOnSubscribe<List<Node>>() {
            @Override
            public void subscribe(MaybeEmitter<List<Node>> emitter) throws Exception {
                try {
                    List<Node> nodes = testGetNodes();
                    if(nodes != null && !nodes.isEmpty()) {
                        emitter.onSuccess(nodes);
                    } else {
                        emitter.onComplete();
                    }
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });

        Observable<Node> observable =Observable.create(new ObservableOnSubscribe<Node>() {
            @Override
            public void subscribe(ObservableEmitter<Node> emitter) throws Exception {
                try {
                    List<Node> nodes = testGetNodes();
                    for (Node node : nodes) {
                        emitter.onNext(node);
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });

        DisposableObserver<Node> disposable = observable.subscribeWith(new DisposableObserver<Node>() {
            @Override
            public void onNext(Node o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        // Dispose the subscription when not interested in the emitted data any more
        disposable.dispose();

    }

    private List<Node> testGetNodes() {
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(1, "Math"));
        list.add(new Node(2, "English"));
        list.add(new Node(3, "Geography"));
        list.add(new Node(4, "History"));
        return list;
    }
}
/**
 * READ MORE:
 * Link 1: http://www.vogella.com/tutorials/RxJava/article.html#disposing-subscriptions-and-using-compositedisposable
 * Link 2: https://android.jlelse.eu/reactive-programming-for-android-d55bdbb438b4
 * Link 3: https://medium.com/@fabioCollini/testing-asynchronous-rxjava-code-using-mockito-8ad831a16877
 * Link 4: https://blog.gojekengineering.com/multi-threading-like-a-boss-in-android-with-rxjava-2-b8b7cf6eb5e2
 */

