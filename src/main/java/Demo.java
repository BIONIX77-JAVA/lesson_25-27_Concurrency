/*
    Создать 2000 одновременных задач, которые увеличивают целочисленный счетчик на 1. Подтвердить проблему атомарности. Проверить ее решение с помощью volatile или Atomic классов.
    Выполнить ожидание завершения задач с помощью CountDownLatch.
    Получить доступ к singleton-объекту с “ленивой” (lazy) инициализацией из множества потоков с использованием барьера инициализации при помощи класса CountDownLatch. Подтвердить проблему атомарности. Решить ее одним из известных способов.
    Воспроизвести проблему dead lock любым способом.
    Использовать ScheduledExecutorService для решения задачи:
            Create a simple java program with 2 methods. One method prints “Hello” and the other method prints “World”.
            Call these methods concurrently & asynchronously. That is, both methods are invoked at the same instant, not one after the other.
            So on console you should sometimes see “World Hello” and sometimes “Hello World” depending on which method is invoked first.
            Repeat these calls every 10 seconds and stop after 1 minute.
            Expected Result: On the console you should see 6 combinations, a mix of “Hello World” and “World Hello”.
 */

public class Demo {
    public static void main(String[] args) {
        DeadLockMain.main(args);
        PointAtomicMain.main(args);
        PointMainVolatile.main(args);
        SchedulerExecutorMain.main(args);
        SingletonMain.main(args);
    }
}