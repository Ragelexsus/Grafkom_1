package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Circle extends Object2d{
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }
//    public void createCircle(){
//        //vertices -> clear
//        int degree=45;
//        for (double i=0; i<360;i+=0.01f){
//            x=centerpoint.x+r*cos(teta);
//            y= centerpoint.y+r*sin(teta);
//            vertices.add(new Vector3f(x,y,0.0f));
//            degree+=90;
//        }
//    }
}
