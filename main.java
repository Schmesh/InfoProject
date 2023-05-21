import Classes.*;


class Main{
    public static void main(String[] args) {
        Game game = new Game();
        Window testWindow = new Window();
        Cuboid testCuboid = new Cuboid(new double[]{1,1,1},new double[]{0,2,0});
        Cuboid testCuboid2 = new Cuboid(new double[]{1,1,1},new double[]{1,3,0});
        testWindow.renderObjectWireframe(testCuboid);
        testWindow.renderObjectWireframe(testCuboid2);

        game.run();

    }
}