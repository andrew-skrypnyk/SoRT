/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.BranchGroup;

/**
 *
 * @author AnarH
 */
public class Simulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        int mapsize = 2000;
        int aircraftAmmount = 50;
        int objectAmmount = 100;

        //int [][]m = map.getMap();
        float objectMap[][] = new float[objectAmmount][5];

        Map map = new Map(mapsize);

        for (int i = 0; i < objectAmmount; i++) {
            
            float x = (int)(Math.random() * mapsize-1)+1;
            float y = (int)(Math.random() * mapsize-1)+1;
            float width = (int)(Math.random() * 100)+1;
            float height = (int)(Math.random() * 100)+1;
            float length = (int)(Math.random() * 200)+1;
            
            map.addObject((int)x, (int)y, (int)width, (int)height, (int)length);
            
            objectMap[i][0] = x / 100;
            objectMap[i][1] = y / 100;
            objectMap[i][2] = width / 100;
            objectMap[i][3] = height / 100;
            objectMap[i][4] = length / 100;
        }
        
        Graphics graphics = new Graphics(objectMap);
    }
}
