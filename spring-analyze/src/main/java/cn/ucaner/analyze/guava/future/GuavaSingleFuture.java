package cn.ucaner.analyze.guava.future;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class GuavaSingleFuture {

    public static void main(String[] args) throws InterruptedException {

        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

        ListenableFuture<String> listenableFuture1 = pool.submit(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":finish");
                throw new RuntimeException("aa");
//                return "Guava Listening future result";
            }
        });

        Futures.addCallback(listenableFuture1, new FutureCallback<String>() {
            public void onSuccess(String s) {
                System.out.println(s);
            }

            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });

        Thread.sleep(10000);
    }
}
