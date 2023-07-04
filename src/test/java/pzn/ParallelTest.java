package pzn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelTest {
  @Test
  @Timeout(value = 5, unit = TimeUnit.SECONDS)
  void test1() throws InterruptedException {
    Thread.sleep(4_000);
  }

  @Test
  @Timeout(value = 5, unit = TimeUnit.SECONDS)
  void test2() throws InterruptedException {
    Thread.sleep(4_000);
  }

  @Test
  @Timeout(value = 5, unit = TimeUnit.SECONDS)
  void test3() throws InterruptedException {
    Thread.sleep(4_000);
  }
}


