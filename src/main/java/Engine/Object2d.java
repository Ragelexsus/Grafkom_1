package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class Object2d extends ShaderProgram {
    List<Vector3f> vertices;
    Vector4f color;
    UniformsMap uniformsMap;

    int vao;
    int vbo;
    List<Vector3f> verticesColor;
    int vbocolor;
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.color=color;
        uniformsMap=new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        setupVAOVBO();
    }
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor=verticesColor;
        setupVAOVBOVerticesColor();
    }


    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);


    }
    public void setupVAOVBOVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);
        //set vbocolor
        vbocolor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbocolor);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(verticesColor),GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }
    public void drawSetupWithVerticesColor(){
        bind();

        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);

        //bind vbocolor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER,vbocolor);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
    }

    public void draw(){
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }
    public void drawline(){
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
    }
    public void addvertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }
    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_TRIANGLES,0,vertices.size());
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINE_STRIP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
    }
}