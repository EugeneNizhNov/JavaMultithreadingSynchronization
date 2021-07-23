import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Carshowroom {

    private List<Car> carList = new ArrayList<>(1);
    final int selling = 1000;
    final int delivering = 3000;
    ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void selCars() {
       lock.lock();
        System.out.println(Thread.currentThread().getName() + " " + " пришел в салон");
        try {
            while (carList.size() == 0) {
                System.out.println("Машин в наличии нет ");
                condition.await();
                //wait();
            }
            Thread.sleep(selling);
            carList.remove(0);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            condition.signalAll();
            //notify();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void resiveCar() {
      lock.lock();
        try {
          while (carList.size() != 0) {
                 condition.await();
                //wait();
            }
            Thread.sleep(delivering);
            carList.add(new Car());
            System.out.println("Производитель Toyota поставил 1 авто");
            condition.signalAll();
            //notifyAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}