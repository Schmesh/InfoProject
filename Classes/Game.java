package Classes;

public class Game implements Runnable {
    Gamestate gamestate = new Gamestate();
    Graphics graphics = new Graphics();

    private int FPS = gamestate.getFPS();
    private long maxLoopTime = 1000 / FPS;
    private boolean running = true;

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
            //update
            gamestate.updateGame();
            time = System.currentTimeMillis();
            if(time-oldTime > maxLoopTime) {

                continue;
            }
            graphics.render();
            //System.out.println(time);
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