import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.joml.sampling.UniformSampling;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

import Engine.Circle_square;

public class main2 {

    private Window window = new Window(800, 800, "Hello World");

    private ArrayList<Object> objects = new ArrayList<>();

    private ArrayList<Object> objectsRectangle = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl = new ArrayList<>();
    private ArrayList<Object> curve = new ArrayList<>();
    private ArrayList<Object> sphare = new ArrayList<>();

    private ArrayList<Sphare> sphares=new ArrayList<>();

    private Circle_square objectduar;

    ArrayList<Circle_square> rectangleArray = new ArrayList<>();

    public void init() {

        window.init();
        GL.createCapabilities();
//       //matahari
        objects.add(new Sphare(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.99f, 0.05f, 1.0f), 0.05, 0.05, 0.05, 0, 0, 0, 0
        ));
        objects.get(0).translateObject(0.0f, 0.0f, 0.0f);
        objects.get(0).scaleObject(0.3f, 0.3f, 0.3f);
//        objects.get(0).getChildObjet().get(0).translateObject(0.25f,0.0f,0.0f);


//merkurius
        objects.add(new Sphare(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.86f, 0.86f, 0.86f, 0.86f), 0.05, 0.05, 0.05, 0, 0, 0, 0
        ));
        objects.get(1).translateObject(-2.5f, 0.0f, 0.0f);
        objects.get(1).scaleObject(0.1f, 0.1f, 0.1f);

        //venus
        objects.add(new Sphare(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.75f, 0.591f, 0.0150f, 0f), 0.05, 0.05, 0.05, 0, 0, 0, 0
        ));
        objects.get(2).translateObject(-2.3f, 0.0f, 0.0f);
        objects.get(2).scaleObject(0.2f, 0.2f, 0.2f);

        //bumi
        objects.add(new Sphare(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.177f, 0.252f, 0.930f, 0f), 0.05, 0.05, 0.05, 0, 0, 0, 0
        ));
        objects.get(3).translateObject(-3.5f, 0.0f, 0.0f);
        objects.get(3).scaleObject(0.2f, 0.2f, 0.2f);

        //mars
        objects.add(new Sphare(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)

        ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 0f, 0f), 0.05, 0.05, 0.05, 0, 0, 0, 0
        ));
        objects.get(4).translateObject(-7f, 0.0f, 0.0f);
        objects.get(4).scaleObject(0.13f, 0.13f, 0.13f);
        //bulan
        objects.add(new Sphare(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.590f, 0.598f, 0.670f, 0f), 0.05, 0.05, 0.05, 0, 0, 0, 0
        ));
        objects.get(5).translateObject(-14f, 4f, 0.0f);
        objects.get(5).scaleObject(0.05f, 0.05f, 0.05f);

//        // Baru
//        objectsPointsControl.add(new Object(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 1f, 1f, 1f)
//        ));
//
//
//    }
//
//    public void input() {
//
//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            System.out.println("W");
//        }
//
//        if (window.getMouseInput().isLeftButtonPressed()) {
//
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//            //System.out.println("X: " + pos.x + " Y: " + pos.y);
//            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
//            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getWidth()/2.0f);
//
//            // Memastikan kita membuat dalam range tersebut
//            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//                System.out.println("X:" + pos.x + "    Y:" + pos.y);
//
//
////                while (!window.getMouseInput().isLeftButtonReleased()) {
////                    System.out.println();
////                    System.out.println("        X: " + pos.x + " Y: " + pos.y);
////                    System.out.println();
////                }

//
//                boolean BelumPernah = false;
//                boolean collapsed = false;
//
//
//                // Cek apakah saat kita click collapse dengan rectangle yg pernah dibuat
//
//
//                // Jika Rectangle Belum pernah sama sekali dibuat, maka lgsg generate rectangle
//                if (rectangleArray.size() == 0) {
//                    // Simpan Objek Rectangle
//                    rectangleArray.add(new Circle_square(
//                            Arrays.asList(
//                                    //shaderFile lokasi menyesuaikan objectnya
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.vert"
//                                                    , GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.frag"
//                                                    , GL_FRAGMENT_SHADER)
//                            ),
//                            new ArrayList<>(),
//                            new Vector4f(1f, 0f, 0.8f, 0f),pos.x,pos.y,0.05
//                    ));
//
//                    // Untuk Buat Vertices
//                    objectsPointsControl.get(0).addvertices(new Vector3f(pos.x, pos.y, 0));
//
//                } else {
//                    // Jika sudah ada rectangle yang pernah dibuat, maka akan di check
//                    int index = 0;
//                    for (Circle_square j : rectangleArray) {
////                    System.out.println("index: " + index);
////                    System.out.println("x: " + j.get_centerX());
////                    System.out.println("y: " + j.get_centerY());
////                    System.out.println("collpased: " + collpased);
//                        collapsed = j.isPointInside(pos.x, pos.y);
//                        index++;
//                        if (collapsed) {
////                        System.out.println("===========");
////                        System.out.println("Collapse With");
////                        System.out.println("x: " + j.get_centerX());
////                        System.out.println("y: " + j.get_centerY());
////                        System.out.println("==========");
//                        objectduar=j;
//                            break;
//                        }
//                    }
//
//                    // Saat menemukan rectangle yg collapse, maka geser kotak tersebut
//                    System.out.println(collapsed);
//                    if (collapsed && window.getMouseInput().isLeftButtonPressed()) {
//                        objectduar.update(pos.x,pos.y);
//                        objectsPointsControl.get(0).update(pos.x,pos.y,index);
//
//
//                    }
//                    else {
//                        // Simpan Objek Rectangle
//                        rectangleArray.add(new Circle_square(
//                                Arrays.asList(
//                                        //shaderFile lokasi menyesuaikan objectnya
//                                        new ShaderProgram.ShaderModuleData
//                                                ("resources/shaders/scene.vert"
//                                                        , GL_VERTEX_SHADER),
//                                        new ShaderProgram.ShaderModuleData
//                                                ("resources/shaders/scene.frag"
//                                                        , GL_FRAGMENT_SHADER)
//                                ),
//                                new ArrayList<>(),
//                                new Vector4f(1f, 0f, 0.8f, 0f), pos.x, pos.y, 0.05
//                        ));
//
//                        // Untuk Buat Vertices
//                        objectsPointsControl.get(0).addvertices(new Vector3f(pos.x, pos.y, 0));
//                    }
//                }
//
//                if (rectangleArray.size()%3==0){
//                    curve.add(new Object(
//                            Arrays.asList(
//                                    //shaderFile lokasi menyesuaikan objectnya
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.vert"
//                                                    , GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.frag"
//                                                    , GL_FRAGMENT_SHADER)
//                            ),
//                            new ArrayList<>(),
//                            new Vector4f(0f, 1f, 1f, 1f)
//                    ));
//                    curve.get(curve.size()-1).addVertices(rectangleArray.get(rectangleArray.size()-3).getX(),rectangleArray.get(rectangleArray.size()-3).getY(),rectangleArray.get(rectangleArray.size()-2).getX(),rectangleArray.get(rectangleArray.size()-2).getY(),rectangleArray.get(rectangleArray.size()-1).getX(),rectangleArray.get(rectangleArray.size()-1).getY());
//
//                }

        // Loop Semua Rectangle
        objectsRectangle.addAll(rectangleArray);

//                for(RectangleFromCircle j : rectangleArray) {
//                    objectsRectangle.add(j);
//                }

//            }
//
//        }


    }
    public void input(){
        if(window.isKeyPressed(GLFW_KEY_F)){
            objects.get(0).rotateObject((float) Math.toRadians(0.9f),0.0f,0.0f,1.0f);
            objects.get(1).rotateObject((float) Math.toRadians(0.9f),0.0f,0.0f,1.0f);
            objects.get(2).rotateObject((float) Math.toRadians(0.6f),0.0f,0.0f,1.0f);
            objects.get(3).rotateObject((float) Math.toRadians(0.4f),0.0f,0.0f,1.0f);
            objects.get(4).rotateObject((float) Math.toRadians(0.3f),0.0f,0.0f,1.0f);
            objects.get(5).rotateObject((float) Math.toRadians(0.4f),0.0f,0.0f,1.0f);

        }
        if(window.isKeyPressed(GLFW_KEY_G)){
            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,1.0f,
                    0.0f);

            Vector3f planetMerk = objects.get(1).Model.transformPosition(new Vector3f(0f,0f,0f));
            objects.get(1).translateObject(-planetMerk.x,-planetMerk.y,0.0f);
            objects.get(1).rotateObject((float)Math.toRadians(0.7f),0.0f,0.0f,
                    1.0f);
            objects.get(1).translateObject(planetMerk.x,planetMerk.y,0.0f);

            Vector3f planetVenus= objects.get(2).Model.transformPosition(new Vector3f(0f,0f,0f));
            objects.get(2).translateObject(-planetVenus.x,-planetVenus.y,0.0f);
            objects.get(2).rotateObject((float)Math.toRadians(0.9f),0.0f,0.0f,
                    1.0f);
            objects.get(2).translateObject(planetVenus.x,planetVenus.y,0.0f);

            Vector3f planetBumi=objects.get(3).Model.transformPosition(new Vector3f(0f,0f,0f));
            objects.get(3).translateObject(-planetBumi.x,-planetBumi.y,0.0f);
            objects.get(3).rotateObject((float)Math.toRadians(1f),0.0f,0.0f,
                    1.0f);
            objects.get(3).translateObject(planetBumi.x,planetBumi.y,0.0f);

            Vector3f planetMars =objects.get(4).Model.transformPosition(new Vector3f(0f,0f,0f));
            objects.get(4).translateObject(-planetMars.x,-planetMars.y,0.0f);
            objects.get(4).rotateObject((float)Math.toRadians(0.9f),0.0f,0.0f,
                    1.0f);
            objects.get(4).translateObject(planetMars.x,planetMars.y,0.0f);

            Vector3f planetBulan = objects.get(5).Model.transformPosition(new Vector3f(0f,0f,0f));
            objects.get(5).translateObject(-planetBulan.x,-planetBulan.y,0.0f);
            objects.get(5).rotateObject((float)Math.toRadians(1f),0.0f,0.0f,
                    1.0f);
            objects.get(5).translateObject(planetBulan.x,planetBulan.y,0.0f);
        }
        if(window.isKeyPressed(GLFW_KEY_H)){
            Vector3f planetBumi = objects.get(3).Model.transformPosition(new Vector3f(0f,0f,0f));
            objects.get(5).translateObject(-planetBumi.x,-planetBumi.y,0.0f);
            objects.get(5).rotateObject((float)Math.toRadians(4f),0.0f,0.0f,1.0f);
            objects.get(5).translateObject(planetBumi.x,planetBumi.y,0.0f);
        }
    }



    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
//            input();

            //code
            for(Object object: objects){
                object.draw();
//                object.drawWithVerticesColor();
            }
            for(Object object: objectsRectangle){
                object.draw();
            }
            for(Object object: objectsPointsControl){
                object.drawline();
            }
            for(Object object: curve){
                object.drawline();
            }
            for(Object object: sphare){
                object.drawline();
            }

            //restore state
            glDisableVertexAttribArray(0);
            //Poll for window events. The key callback above will only be
            //invoked during this call.
            glfwPollEvents();
            input();
        }

    }


    public void run() {

        init();
        loop();

        //Terminate GLFW andgi
        //free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }


    public static void main(String[] args){
        new main2().run();
    }
}
