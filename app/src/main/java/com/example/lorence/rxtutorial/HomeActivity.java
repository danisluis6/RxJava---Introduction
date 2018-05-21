package com.example.lorence.rxtutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Observable<Node> observable = Observable.create(new ObservableOnSubscribe<Node>() {
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
