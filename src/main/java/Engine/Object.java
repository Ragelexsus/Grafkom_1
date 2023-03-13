package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class Object extends ShaderProgram {
    List<Vector3f> vertices;

    List<Vector3f> curveVertices;
    Vector4f color;
    UniformsMap uniformsMap;

    int vao;
    int vbo;
    List<Vector3f> verticesColor;
    int vbocolor;

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        setupVAOVBO();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOVerticesColor();
    }


    public void setupVAOVBO() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);


    }

    public void setupVAOVBOVerticesColor() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
        //set vbocolor
        vbocolor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbocolor);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupWithVerticesColor() {
        bind();

        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        //bind vbocolor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vbocolor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

    public void drawline() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }


    public void drawCurve() {
        if (vertices.size() < 3) {
            if (vertices.size() == 2) drawline();
            return;
        }
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
    public void updateCurve(){
        setupVAOVBO();
        if(vertices.size() < 2) return;
        curveVertices.clear();
        curveVertices.add(vertices.get(0));
        int size = vertices.size();
        double interval = 0.02;
        for (double i = 0; i <= 1; i += interval) {
            double j = 1-i;
            float tempx = 0, tempy = 0;
            for(int p=0; p<=size-1; p+=1){
                tempx += C(size-1,p) * Math.pow(i,p) * Math.pow(j,size-p-1) * vertices.get(p).x;
                tempy += C(size-1,p) * Math.pow(i,p) * Math.pow(j,size-p-1) * vertices.get(p).y;
            }
            curveVertices.add(new Vector3f(tempx, tempy, 0));
        }
        curveVertices.add(vertices.get(vertices.size()-1));

    }
    public void update(float x, float y, int index){
        vertices.set(index-1,new Vector3f(x,y,0));
        setupVAOVBO();
    }
    public int C(int n, int k){
        int ans = fact(n);
        ans /= fact(k);
        ans /= fact(n-k);
        return ans;
    }
    public void addVertices(double firstX, double firstY, double secondX, double secondY, double thirdX, double thirdY)
    {
        vertices.clear();
        vertices.add(new Vector3f((float)firstX, (float)firstY, 0));
        double newX, newY;

        for(double i = 0; i <=1; i+= 0.01)
        {
            //p(t) = ((1-t) * v1) + (t * v2)
            //p(t) = ((1-t)^2 * v1) + (2(1-t) * t * v2) + (t^2 * v3)
//            newX = ((1-i) * prevX) + (i * nextX);
//            newY = ((1-i) * prevY) + (i * nextY);
            newX = (Math.pow((1-i), 2) * firstX) + (2 * (1-i) * i * secondX) + (Math.pow(i, 2) * thirdX);
            newY = (Math.pow((1-i), 2) * firstY) + (2 * (1-i) * i * secondY) + (Math.pow(i, 2) * thirdY);
//            System.out.println(newX + "                " + newY);
            vertices.add(new Vector3f((float)newX, (float)newY, 0));
        }

        vertices.add(new Vector3f((float)thirdX, (float)thirdY, 0));
        setupVAOVBO();
    }
    public int fact(int x){
        int ans = 1;
        for(int i=1; i<=x; i++) ans *= x;
        return ans;
    }
    public List<Vector3f> getVertices() {
        return vertices;
    }
    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
    }
}