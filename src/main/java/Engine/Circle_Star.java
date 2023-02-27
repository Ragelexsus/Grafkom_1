package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.List;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11C.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11C.glDrawElements;
import static org.lwjgl.opengl.GL15C.*;

public class Circle_Star extends Object2d{
    double x,y,centerpointX,centerpointY,r;
    int ibo;
    List<Integer> index;

    public Circle_Star(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double centerpointX, double centerpointY, double r,List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.centerpointX=centerpointX;
        this.centerpointY=centerpointY;
        this.r = r;
        this.index=index;

        ibo=glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index),GL_STATIC_DRAW);
        createCircle();
        setupVAOVBO();
    }


    public void createCircle(){
        vertices.clear();
        for (double i=36; i<360;i+=72){
            x=centerpointX+r*Math.cos(Math.toRadians(i));
            y= centerpointY+r*Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x,(float) y,0.0f));


        }
    }
    public void draw() {
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_LINES,index.size(),GL_UNSIGNED_INT,0);

    }
}
