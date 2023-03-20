package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Sphare extends Circle
{
    List<Integer> index;

    int ibo, stackCount, sectorCount;
    double cpz;
    float radiusX, radiusY, radiusZ;

    public Sphare(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double rx, double ry, double rz, double cpx, double cpy, double cpz, int option) {
        super(shaderModuleDataList, vertices, color, rx, cpx, cpy, option);
        this.cpz = cpz;
        this.radiusX = (float) rx;
        this.radiusY = (float) ry;
        this.radiusZ = (float) rz;

        this.stackCount = 18;
        this.sectorCount = 36;
//
createElipsoid();
//        createHyperboloid1();
//        createHyperboloid2();
//        ellipticcone();
//        paraboloid();
        setupVAOVBO();
    }

    public Sphare(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double centerpointX, double centerpointY, double r) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, r);
    }

    public Sphare(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double centerpointX, double centerpointY, double r, double ry) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, r, ry);
    }

    public void createBox()
    {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        //titik 1 kiri atas belakang
        temp.x = (float)centerpointX - radiusX/2;
        temp.y = (float)centerpointY + radiusY/2;
        temp.z = (float)cpz - radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 2 kiri bawah belakang
        temp.x = (float)centerpointX - radiusX/2;
        temp.y = (float)centerpointY - radiusY/2;
        temp.z = (float)cpz - radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 3 kanan bawah belakang
        temp.x = (float)centerpointX + radiusX/2;
        temp.y = (float)centerpointY - radiusY/2;
        temp.z = (float)cpz - radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 4 kanan atas belakang
        temp.x = (float)centerpointX + radiusX/2;
        temp.y = (float)centerpointY + radiusY/2;
        temp.z = (float)cpz - radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 5 kiri atas depan
        temp.x = (float)centerpointX - radiusX/2;
        temp.y = (float)centerpointY+ radiusY/2;
        temp.z = (float)cpz + radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 6 kiri bawah depan
        temp.x = (float)centerpointX - radiusX/2;
        temp.y = (float)centerpointY - radiusY/2;
        temp.z = (float)cpz + radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 7 kanan bawah depan
        temp.x = (float)centerpointX + radiusX/2;
        temp.y = (float)centerpointY- radiusY/2;
        temp.z = (float)cpz + radiusZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 8 kanan atas depan
        temp.x = (float)centerpointX + radiusX/2;
        temp.y = (float)centerpointY + radiusY/2;
        temp.z = (float)cpz + radiusZ/2;
        tempVertices.add(temp);

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void createSphereGitHub() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid1() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }
    public void createHyperboloid2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI / 2; u <= Math.PI / 2; u += Math.PI / 60) {
                float x = 0.5f * (float) ((Math.tan(v)) * Math.cos(u));
                float y = 0.5f * (float) ((Math.tan(v)) * Math.sin(u));
                float z = 0.5f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));

            }
        }
        vertices=temp;
    }
    public void ellipticcone() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v*Math.cos(u) );
                float y = 0.5f * (float)(v* Math.sin(u));
                float z = 0.5f * (float)(v);
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }
    public void paraboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = 0.5f * (float) (v * Math.tan(u));
                float z = 0.5f * (float) (v * (1/Math.cos(u)));
                float y = 0.5f * (float) (v * v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }
    public void createElipsoid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

    }
    @Override
    public void draw()
    {
        drawSetup();
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }}