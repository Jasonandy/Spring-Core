package cn.ucaner.analyze.guava.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class GuavaListFuture {

    public static void main(String[] args) throws Exception {

        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

        List<ListenableFuture<String>> result = new ArrayList<>();
        for(int i=0;i<10;i++){
            final int finalI = i;
            result.add(pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" finish");
                    if(finalI==2){
                        throw new RuntimeException();
                    }
                    return "Guava Listening future result " + finalI;
                }
            }));
        }
        ListenableFuture<List<String>> restFutures = Futures.successfulAsList(result);

        Futures.addCallback(restFutures, new FutureCallback<Object>() {

            public void onSuccess(Object result) {
                System.out.printf("success with: %s%n", result);
            }

            public void onFailure(Throwable thrown) {
                System.out.printf("onFailure%s%n", thrown.getMessage());
            }
        });

        System.out.println("main start to get results");
        List<String> resultList = restFutures.get();
        System.out.println("results:");
        for(String str:resultList){
            System.out.println(str);
        }

        Thread.sleep(10000);
    }
}
