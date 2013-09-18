/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

/**
 *
 * @author AnarH
 */
public class Map {

    private int[][] map;

    public Map(int mapSizeX) {
        this.map = new int[mapSizeX][mapSizeX];
    }

    public Map(int mapSizeX, int mapSizeY) {
        this.map = new int[mapSizeX][mapSizeY];
    }

    public boolean addObject(int x, int y, int width, int length, int height) {
        if ((x - width) > 0 || (x + width) < map.length || (y - length) > 0 || (y + length) < map[0].length) {
            for (int i = x - (width / 2); i < x + (width / 2); i++) {
                for (int j = y - (length / 2); j < y + (length / 2); j++) {
                    try{
                        this.map[i][j] = height;
                    }catch(Exception e){
                        System.err.println("Object is outside this map.");
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int[][] getMap() {
        return this.map;
    }
}
