package lambdas.java8inaction.chapter11_completebleFuture;

import org.apache.http.client.utils.DateUtils;

import java.util.Date;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                System.out.printf("1:%s%s%n", Thread.currentThread(), DateUtils.formatDate(new Date(), DateUtils.PATTERN_RFC1123));
                Thread.sleep(3000);
                System.out.println("2:" + Thread.currentThread() +  DateUtils.formatDate(new Date(), DateUtils.PATTERN_RFC1123));
                return 0.1;
            }
        });
        System.out.println("3:" + Thread.currentThread() + DateUtils.formatDate(new Date(), DateUtils.PATTERN_RFC1123));
        //Thread.sleep(1000);
        System.out.println("24");
        System.out.println("4:" + Thread.currentThread() + DateUtils.formatDate(new Date(), DateUtils.PATTERN_RFC1123));

        try {
            System.out.println("start.");
            System.out.println("5:" + Thread.currentThread() +  DateUtils.formatDate(new Date(), DateUtils.PATTERN_RFC1123));
            Double result = future.get(4, TimeUnit.SECONDS);
            System.out.println("6:" + Thread.currentThread() +  DateUtils.formatDate(new Date(), DateUtils.PATTERN_RFC1123));
            System.out.println(result);
            System.out.println("end.");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

}
