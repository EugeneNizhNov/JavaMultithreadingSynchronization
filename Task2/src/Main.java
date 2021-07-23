/**Задача 2. Продвинутый автосалон**/

public class Main {
    public static void main(String[] args) {
        Carshowroom carshowroom = new Carshowroom();
        Buyer buyer = new Buyer(carshowroom);
        Buyer buyer1 = new Buyer(carshowroom);
        Buyer buyer2 = new Buyer(carshowroom);
        Buyer buyer3 = new Buyer(carshowroom);
        Buyer buyer4 = new Buyer(carshowroom);
        Provider provider = new Provider(carshowroom);
        new Thread(buyer,"Пользователь 1").start();
        new Thread(buyer1,"Пользователь 2").start();
        new Thread(buyer2,"Пользователь 3").start();
        new Thread(buyer3,"Пользователь 4").start();
        new Thread(buyer4,"Пользователь 5").start();
        new Thread(provider).start();
    }
}
