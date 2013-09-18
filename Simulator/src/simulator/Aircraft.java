/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

/**
 *
 * @author AnarH
 */
public class Aircraft {
    
    private int id;
    private int width = 30;
    private int height = 10;
    private int length = 40;
    private int speed = 100;
    
    public Vector3D vector3d;
    
    public Aircraft(int id, Vector3D vector3d){
        this.id = id;
        this.vector3d = vector3d;
    }
    
    public int getID(){
        return this.id;
    }
    
}