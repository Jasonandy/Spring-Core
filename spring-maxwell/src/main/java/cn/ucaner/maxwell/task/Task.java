package cn.ucaner.maxwell.task;

import org.springframework.scheduling.annotation.Async;

/**
 * 测试Spring Task.
 */
public class Task {

    @Async("executor")
    public void print() {
        System.out.println("print执行");
    }

}
