public class Provider implements Runnable {
    final Carshowroom carshowroom;
    final int deliver = 4;

    public Provider(Carshowroom carshowroom) {
        this.carshowroom = carshowroom;
    }

    @Override
    public void run() {
        for (int i = 0; i < deliver; i++) {
            carshowroom.resiveCar();
        }
    }
}
