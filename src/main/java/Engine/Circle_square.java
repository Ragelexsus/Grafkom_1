package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle_square extends Object {
    double x,y,centerpointX,centerpointY,r;
    public Circle_square(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double centerpointX, double centerpointY, double r) {
        super(shaderModuleDataList, vertices, color);
        this.centerpointX=centerpointX;
        this.centerpointY=centerpointY;
        this.r = r;
        createCircle();
        setupVAOVBO();
    }
    public boolean isPointInside(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - centerpointX, 2) + Math.pow(y - centerpointY, 2));
        return distance <=2* r;
    }

    public void createCircle(){
        vertices.clear();
        for (double i=45; i<360;i+=90){
            x=centerpointX+r*Math.cos(Math.toRadians(i));
            y= centerpointY+r*Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x,(float) y,0.0f));


        }
    }
    public void update(double cpx, double cpy){
        this.centerpointX=cpx;
        this.centerpointY=cpy;
        createCircle();
        setupVAOVBO();

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

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
