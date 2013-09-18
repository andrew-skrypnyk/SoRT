package simulator;

import java.awt.Color;
import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;

// An Egyptian pyramid
// Base divided into two triangles
public class Graphics {

    public Graphics(float[][] objectMap) {

        SimpleUniverse universe = new SimpleUniverse();

        BranchGroup group = new BranchGroup();

        float size = 30;
        // X axis made of spheres

        for (float x = .0f; x <= size; x = x + 1f) {

            Sphere sphere = new Sphere(0.05f);

            TransformGroup tg = new TransformGroup();

            Transform3D transform = new Transform3D();

            Vector3f vector = new Vector3f(x, .0f, .0f);

            transform.setTranslation(vector);

            tg.setTransform(transform);

            tg.addChild(sphere);

            group.addChild(tg);

        }

        // Y axis made of cones

        for (float y = .0f; y <= size; y = y + 1f) {

            TransformGroup tg = new TransformGroup();

            Transform3D transform = new Transform3D();

            Cone cone = new Cone(0.05f, 0.1f);

            Vector3f vector = new Vector3f(.0f, y, .0f);

            transform.setTranslation(vector);

            tg.setTransform(transform);

            tg.addChild(cone);

            group.addChild(tg);

        }

        // Z axis made of cylinders

        for (float z = .0f; z <= size; z = z + 1f) {

            TransformGroup tg = new TransformGroup();

            Transform3D transform = new Transform3D();

            Cylinder cylinder = new Cylinder(0.05f, 0.1f);

            Vector3f vector = new Vector3f(.0f, .0f, z);

            transform.setTranslation(vector);

            tg.setTransform(transform);

            tg.addChild(cylinder);

            group.addChild(tg);

        }

        for (int i = 0; i < objectMap.length; i++) {
            
            float posX = objectMap[i][0];
            float posZ = objectMap[i][1];
            float width = objectMap[i][2];
            float length = objectMap[i][3];
            float height = objectMap[i][4];
            
            for (float x = posX; x <= posX + width; x += .1f) {
                for (float y = 0; y <= height; y += .1f) {
                    for (float z = posZ; z <= posZ + length; z += .1f) {
                        TransformGroup tg = new TransformGroup();

                        Transform3D transform = new Transform3D();

                        ColorCube cube = new ColorCube(0.05);

                        Vector3f vector = new Vector3f(x, y, z);

                        transform.setTranslation(vector);

                        tg.setTransform(transform);

                        tg.addChild(cube);

                        group.addChild(tg);
                    }
                }
            }
        }

        Color3f light1Color = new Color3f(.1f, 1.4f, .1f); // green light

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

        Vector3f light1Direction = new Vector3f(40.0f, -70.0f, -120.0f);

        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);

        light1.setInfluencingBounds(bounds);

        group.addChild(light1);

        universe.getViewingPlatform().setNominalViewingTransform();

        // add the group of objects to the Universe

        universe.addBranchGraph(group);

        // above pyramid
        Vector3f viewTranslation = new Vector3f();
        viewTranslation.z = 36;
        viewTranslation.x = 10;
        viewTranslation.y = -5;
        Transform3D viewTransform = new Transform3D();
        viewTransform.setTranslation(viewTranslation);
        Transform3D rotation = new Transform3D();
        rotation.rotX(-0.5);
        //rotation.rotY(-1.5);
        rotation.mul(viewTransform);

        //group.addChild(new ColorCube(0.3));


        universe.getViewingPlatform().getViewPlatformTransform().setTransform(rotation);
        universe.getViewingPlatform().getViewPlatformTransform().getTransform(viewTransform);

        // lights
        light1.setInfluencingBounds(bounds);
        group.addChild(light1);
        Color3f ambientColor = new Color3f(.4f, .4f, .4f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        group.addChild(ambientLightNode);



        universe.addBranchGraph(group);
    }
}