public class Buyer implements Runnable{
    final Carshowroom carshowroom;
    public Buyer(Carshowroom carshowroom){
        this.carshowroom = carshowroom;
    }

    @Override
    public void run() {
      //for (int i =0; i <3; i++){
            carshowroom.selCars();
      //  }
    }
}
