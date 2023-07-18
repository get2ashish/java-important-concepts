package ashish.examples.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExecutorsExample {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    String getValue1() throws InterruptedException {
        Thread.sleep(1000);
        return "Ashish";
    }

    String getValue2() throws InterruptedException {
        Thread.sleep(1000);
        return "Shukla";
    }

    String makeCallUsingCompletableFuture() throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfResp1 = CompletableFuture.supplyAsync(()-> {
            try {
                return getValue1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> cfResp2 = CompletableFuture.supplyAsync(()-> {
            try {
                return getValue2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        //Combining Completable futures
        Future<String> re =  CompletableFuture.supplyAsync(()-> {
            try {
                return getValue2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(item->item.repeat(2));

        System.out.println(re.get());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(cfResp1,cfResp2);
        allFutures.get();

        System.out.println(cfResp1.isDone());
        System.out.println(cfResp2.isDone());

        return cfResp1.get()+"-"+cfResp2.get();
    }

    String makeCallUsingExecutorService() throws ExecutionException, InterruptedException {
        Future<String> resp1 = executorService.submit(() -> getValue1());
        Future<String> resp2 = executorService.submit(() -> getValue2());

        System.out.println(resp1.isDone());
        System.out.println(resp2.isDone());

        executorService.shutdown();
        return resp1.get()+"-"+resp2.get();
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFutureExecutorsExample obj = new CompletableFutureExecutorsExample();
        //String value = obj.makeCallUsingCompletableFuture();
        String value = obj.makeCallUsingExecutorService();
        System.out.println(value);
    }
}
