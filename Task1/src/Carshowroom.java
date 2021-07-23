import java.util.ArrayList;
import java.util.List;

public class Carshowroom {
    private List<Car> carList = new ArrayList<>(1);
    final int selling = 1000;
    final int delivering = 3000;

    public synchronized void selCars() {

        System.out.println(Thread.currentThread().getName() + " " + " пришел в салон");
        while (carList.size() == 0) {
            try {
                System.out.println("Машин в наличии нет");
                Thread.sleep(selling);
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        carList.remove(0);
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        notify();
    }

    public synchronized void resiveCar() {
        while (carList.size() != 0) {
            try {
                Thread.sleep(delivering);
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        carList.add(new Car());
        System.out.println("Производитель Toyota поставил 1 авто");
        notifyAll();
    }
}
