package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jbzm
 * @date 12/22/20 3:33 PM
 **/
public class PrintInOrder {
    class Foo {

        private Object lol = new Object();
        private volatile int flag = 1;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (lol) {
                while (flag != 1) {
                    // printFirst.run() outputs "first". Do not change or remove this line.
                    lol.wait();
                }
                printFirst.run();
                flag = 2;
                lol.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lol) {
                while (flag != 2) {
                    lol.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                flag = 3;
                lol.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lol) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();

            }
        }
    }
}