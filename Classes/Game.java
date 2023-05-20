package Classes;

public class Game implements Runnable {
    public int FPS = 60;
    public long maxLoopTime = 1000 / FPS;
    public boolean running = true;

    public void Game(String[] args) {
        Game game = new Game();
        new Thread(game).start();
    }

    @Override
    public void run() {
        long time;
        long oldTime;
        while(running) {
            oldTime = System.currentTimeMillis();
            //update game
            time = System.currentTimeMillis();
            if(time-oldTime > maxLoopTime) {

                continue;
            }
            //render
            System.out.println(time);
            time = System.currentTimeMillis();
            if(time-oldTime <= maxLoopTime) {
                try {
                    Thread.sleep(maxLoopTime - (time-oldTime) );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}