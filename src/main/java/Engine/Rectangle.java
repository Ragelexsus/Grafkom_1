package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;


import java.util.List;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL15C.*;


public class Rectangle extends Object2d{
    List<Integer> index;
    int ibo;
    //index buffer object|| element buffer object
    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index=index;
        ibo=glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index),GL_STATIC_DRAW);
    }
    public void draw(){
        drawSetup();
//        glLineWidth(1);
//        glPointSize(0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_TRIANGLES,index.size(),GL_UNSIGNED_INT,0);
    }

}
