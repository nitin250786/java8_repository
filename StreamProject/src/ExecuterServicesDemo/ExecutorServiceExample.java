package ExecuterServicesDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Create executorService using ThreadPoolExecutor implementation of
//ExecutorService.

        ExecutorService executorService = new ThreadPoolExecutor(1, 5, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
//Create callable tasks using lambda implementation of call method of
//Callable Interface

        Callable<String> callableTask = () -> {
            System.out.println("Call method called.");
            TimeUnit.MILLISECONDS.sleep(2000);
            return "Task execution in call method";
        };

//submit single callable task to executorService, that is returning a Future
        Future<String> future = executorService.submit(callableTask);
        System.out.println(future.get());

//Create list of callable tasks
        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

//submit the list of callable tasks to invokeAny method that returns a result.
        String result = executorService.invokeAny(callableTasks);
        System.out.println(result);

//submit the list of callable tasks to invokeAll method that returns a list
// of futures representing results of asynchronous tasks.
        List<Future<String>> futures = executorService.invokeAll(callableTasks);

//shutdown the executorService after completing all tasks to reclaim memory.
        executorService.shutdown();
    }
}