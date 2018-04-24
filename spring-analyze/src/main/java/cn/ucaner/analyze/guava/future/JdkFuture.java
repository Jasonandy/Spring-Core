package cn.ucaner.analyze.guava.future;

import java.util.concurrent.*;

public class JdkFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":finish");
                return null;
            }
        });
        future.get();
        System.out.println("finish");

    }
}
