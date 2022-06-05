/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.viewables;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 * a flat textured plane in 3d space
 */
public class Plane extends MeshView {
    public Plane (Image tex) {
        setCullFace(CullFace.BACK);

        TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().addAll(
            -1,-1,0,
                1,-1,0,
                -1,1,0,
                1,1,0
        );

        mesh.getTexCoords().addAll (
            0,1,
                1,1,
                0,0,
                1,0
        );

        mesh.getFaces().addAll(
                0,0, 2,2, 1,1,
                2,2, 3,3, 1,1
        );
        setMesh (mesh);

        updateTexture(tex);
    }

    /**
     * update the texture of this plane
     * @param tex
     */
    public void updateTexture(Image tex) {
        PhongMaterial mat = new PhongMaterial();
        mat.setDiffuseMap(tex);
        setMaterial (mat);
    }
}
