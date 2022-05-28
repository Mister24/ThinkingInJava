package lambdas.java8inaction.chapter11_completebleFuture;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTest {

    private static ExecutorService threadPool = new ThreadPoolExecutor(
            2,
            5,
            20,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {
            System.out.println(Thread.currentThread() + ":" + getPrice("23"));
            System.out.println(Thread.currentThread() + ":" + getPriceAsync("23").get(10, TimeUnit.SECONDS));
            System.out.println(Thread.currentThread() + ":" + getPriceSupplyAsync("23").get(10, TimeUnit.SECONDS));
            System.out.println(Thread.currentThread() + ":" + getPriceSupplyAsyncWithThreadPool("23", threadPool).get(10, TimeUnit.SECONDS));
            System.out.println("end");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    public static Future<Double> getPriceSupplyAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static Future<Double> getPriceSupplyAsyncWithThreadPool(String product, Executor executor) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product), threadPool);
    }

    public static Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                // 如果正确结束，完成Future操作并设置商品价格
                completableFuture.complete(price);
            } catch (Exception e) {
                // 如果发生异常，抛出
                completableFuture.completeExceptionally(e);
            }
        }).start();

        return completableFuture;
    }

    public static double getPrice(String product) {
        return calculatePrice(product);
    }

    public static double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
