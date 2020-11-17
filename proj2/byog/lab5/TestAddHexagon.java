package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class TestAddHexagon {
    public static int width = 30;
    public static int height =30;
    public static void main(String[] args) {

        TERenderer ter = new TERenderer();
        ter.initialize(width,height);

        TETile[][] world = new TETile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }

        var seed = HexWorld.GenerateSeed();
        HexWorld.DrawHexagon(world,seed);

        ter.renderFrame(world);
    }
}
