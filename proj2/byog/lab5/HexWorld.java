package byog.lab5;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    public static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * draws hexagon
     * @param world
     * @param p left top position
     * @param size
     * @param t
     */
    public static void addHexagon(TETile[][] world, Position p,int size,TETile t,boolean randomColor){
        var r = new Random();
        for (int i = 0 ;i<=size-1;i++){
            // width = 3*size - 3
            for (int j = size-1-i; j <= 2*size-2+i; j++) {
                world[p.x+j][p.y+i] = randomColor ? TETile.colorVariant(t,40,40,40,r) :t;
            }
        }
        for (int i=size;i<=2*size-1;i++){
            for (int j =2*size -2 + (2*size -1 - i);j>=size-1-(2*size -1-i);j--){
                world[p.x+j][p.y+i]=randomColor ? TETile.colorVariant(t,40,40,40,r) :t;
            }
        }
    }

    public static Map<Position,TETile> GenerateSeed() {
        var m = new HashMap<Position,TETile>();

        var in = new In("./byog/lab5/map.txt");

        int lines = in.readInt();
        for (int i = 0; i < lines; i++) {
            int x = in.readInt();
            int y = in.readInt();
            String s = in.readString();

            var p = new Position(x,y);
            var t = ConvertTile(s);
            m.put(p,t);
        }
        return m;
    }

    private static TETile ConvertTile(String s) {
        TETile t;
        switch (s){
            case "PLAYER":t = Tileset.PLAYER;break;
            case "WALL":t = Tileset.WALL;break;
            case "FLOOR":t = Tileset.FLOOR;break;
            case "NOTHING":t = Tileset.NOTHING;break;
            case "GRASS":t = Tileset.GRASS;break;
            case "WATER":t=Tileset.WATER;break;
            case "FLOWER":t=Tileset.FLOWER;break;
            case "LOCKED_DOOR":t=Tileset.LOCKED_DOOR;break;
            case "UNLOCKED_DOOR":t=Tileset.UNLOCKED_DOOR;break;
            case "SAND":t=Tileset.SAND;break;
            case "MOUNTAIN":t=Tileset.MOUNTAIN;break;
            case "TREE":t=Tileset.TREE;break;
            default:t=Tileset.NOTHING;break;
        }
        return t;
    }

    public static void DrawHexagon(TETile[][] world,Map<Position,TETile> m){
        for (var p : m.keySet()){
            var t = m.get(p);
            if (t==Tileset.MOUNTAIN){
                addHexagon(world,p,3,m.get(p),true);
            }else {
                addHexagon(world,p,3,m.get(p),false);
            }
        }
    }
}

