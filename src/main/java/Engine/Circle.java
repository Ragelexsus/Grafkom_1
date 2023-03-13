package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object {
    double x,y,centerpointX,centerpointY,r,ry;
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double centerpointX,double centerpointY,double r) {
        super(shaderModuleDataList, vertices, color);
        this.centerpointX=centerpointX;
        this.centerpointY=centerpointY;
        this.r = r;
        createCircle();
        setupVAOVBO();
    }
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double centerpointX,double centerpointY,double r,double ry) {
        super(shaderModuleDataList, vertices, color);
        this.centerpointX=centerpointX;
        this.centerpointY=centerpointY;
        this.r = r;
        this.ry=ry;
        createElipse();
        setupVAOVBO();
    }


    public void createCircle(){
        vertices.clear();
        for (double i=0; i<360;i+=0.1f){
            x=centerpointX+r*Math.cos(Math.toRadians(i));
            y= centerpointY+r*Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x,(float) y,0.0f));


        }
    }
    public void createElipse(){
        vertices.clear();
        for (double i=0; i<360;i+=0.1f){
            x=centerpointX+r*Math.cos(Math.toRadians(i));
            y= centerpointY+ry*Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x,(float) y,0.0f));
//

        }
    }
    public void draw(){
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON,0,vertices.size());
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
