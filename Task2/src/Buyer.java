public class Buyer implements Runnable {
    final Carshowroom carshowroom;
    int round = 2;//потоки пройдут 2 круга

    public Buyer(Carshowroom carshowroom) {
        this.carshowroom = carshowroom;
    }

    @Override
    public void run() {
        for (int i = 0; i < round; i++) {
            carshowroom.selCars();
        }
    }
}