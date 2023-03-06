//import Engine.*;
//import com.sun.tools.javac.Main;
//import org.joml.Vector2f;
//import org.joml.Vector3f;
//import org.joml.Vector4f;
//import org.lwjgl.glfw.GLFW;
//import org.lwjgl.opengl.GL;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.lwjgl.glfw.GLFW.*;
//import static org.lwjgl.opengl.GL11.glClearColor;
//import static org.lwjgl.opengl.GL30.*;
//
//public class main {
//
//    private Window window = new Window(800, 800, "Hello World");
//    private ArrayList<Object2d> objects = new ArrayList<>();
//    private ArrayList<Object2d> Rectangles = new ArrayList<>();
//
//    private ArrayList<Object2d> objectPointsControl = new ArrayList<>();
//    public void init() {
//        window.init();
//        GL.createCapabilities();
//
////        objects.add(new Object2d(
////                Arrays.asList(
////                        //shaderFile lokasi menyesuaikan objectnya
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/scene.vert"
////                                        , GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/scene.frag"
////                                        , GL_FRAGMENT_SHADER)
////                ),
////                new ArrayList<>(List.of(new Vector3f(0.0f,0.5f,0.0f), new Vector3f(-0.5f,-0.5f,0.0f),
////                                new Vector3f(0.5f,-0.5f,0.0f)
////                        )
////                ),
////                new Vector4f(0.0f,0.0f,1.0f,1.0f)
////        ));
//
//
////        segitiga
////        objects.add(new Object2d(
////                Arrays.asList(
////                        //shaderFile lokasi menyesuaikan objectnya
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/sceneWithVerticesColor.vert"
////                                        , GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/sceneWithVerticesColor.frag"
////                                        , GL_FRAGMENT_SHADER)
////                ),
////                new ArrayList<>(List.of(new Vector3f(0.0f,0.5f,0.0f), new Vector3f(-0.5f,-0.5f,0.0f),
////                        new Vector3f(0.5f,-0.5f,0.0f)
////                )
////                ),
////        new ArrayList<>(List.of(
////                new Vector3f(1.0f,0.0f,0.0f),
////                new Vector3f(0.5f,1.0f,0.0f),
////                new Vector3f(0.0f,0.0f,1.0f)
////        )) ));
//
//                Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(1.0f,-0.5f,0.0f),
//                        new Vector3f(-1.0f,-1.0f,0.0f),
//                        new Vector3f(1.0f,-1.0f,0.0f),
//                        new Vector3f(-1.0f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                        Arrays.asList(0,3,1,0,1,2)
//        ));
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(0.45f,0.15f,0.0f),
//                        new Vector3f(-0.6f,-0.2f,0.0f),
//                        new Vector3f(0.6f,-0.2f,0.0f),
//                        new Vector3f(-0.45f,0.15f,0.0f)
//                )
//                ),
//                new Vector4f(1.0f,0.0f,0.0f,0.0f),
//                Arrays.asList(0,3,1,0,1,2)
//        ));
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(0.5f,-0.1f,0.0f),
//                        new Vector3f(-0.5f,-0.6f,0.0f),
//                        new Vector3f(0.5f,-0.6f,0.0f),
//                        new Vector3f(-0.5f,-0.1f,0.0f)
//                )
//                ),
//                new Vector4f(1.0f,0.5f,0.0f,0.0f),
//                Arrays.asList(0,3,1,0,1,2)
//        ));
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(0.37f,0.13f,0.0f),
//                        new Vector3f(-0.5f,-0.1f,0.0f),
//                        new Vector3f(0.5f,-0.1f,0.0f),
//                        new Vector3f(-0.4f,0.13f,0.0f)
//                )
//                ),
//                new Vector4f(1.0f,0.5f,0.0f,0.0f),
//                Arrays.asList(0,3,1,0,1,2)
//        ));
//
//
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(0.45f,0.15f,0.0f),
//                        new Vector3f(-0.3f,-0.2f,0.0f),
//                        new Vector3f(0.6f,-0.2f,0.0f),
//                        new Vector3f(-0.45f,0.15f,0.0f)
//                )
//                ),
//                new Vector4f(1.0f,0.0f,0.0f,0.0f),
//                Arrays.asList(0,3,1,0,1,2)
//        ));
//        Rectangles.add(new Circle(
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
//                new Vector4f(1f,1f,0.0f,1.0f),-0.8,0.8,0.1
//        ));
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(0.35f,0.3f,0.0f),
//                        new Vector3f(0.25f,0.1f,0.0f),
//                        new Vector3f(0.35f,0.1f,0.0f),
//                        new Vector3f(0.25f,0.3f,0.0f)
//                )
//                ),
//                new Vector4f(1.0f,0.5f,0.0f,0.0f),
//                Arrays.asList(0,3,1,0,1,2)
//        ));
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(List.of(
//                        new Vector3f(0.38f,0.35f,0.0f),
//                        new Vector3f(0.22f,0.3f,0.0f),
//                        new Vector3f(0.38f,0.3f,0.0f),
//                        new Vector3f(0.22f,0.35f,0.0f)
//                )
//                ),
//                new Vector4f(1.0f,0.0f,0.0f,0.0f),
//                Arrays.asList(0,3,1,0,1,2)
//        ));
//        Rectangles.add(new Circle(
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
//                new Vector4f(0.1f,0.1f,0.1f,0.0f),0.3,0.4,0.05,0.03
//        ));
//        Rectangles.add(new Circle(
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
//                new Vector4f(0.1f,0.1f,0.1f,0.0f),0.32,0.43,0.05,0.03
//        ));
//        Rectangles.add(new Circle(
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
//                new Vector4f(0.0f,0.0f,1.0f,0.0f),-0.75,0.8,0.1
//        ));
//        Rectangles.add(new Circle_Star(
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
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),-0.3,0.65,0.05,
//                Arrays.asList(0,3,3,1,1,4,4,2,2,0)
//        ));
//        Rectangles.add(new Circle_Star(
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
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),-0.3,0.65,0.05,
//                Arrays.asList(0,3,3,1,1,4,4,2,2,0)
//        ));
//        Rectangles.add(new Circle_Star(
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
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),0.09,0.8,0.05,
//                Arrays.asList(0,3,3,1,1,4,4,2,2,0)
//        ));
//
//        Rectangles.add(new Circle_Star(
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
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),0.6,0.7,0.05,
//                Arrays.asList(0,3,3,1,1,4,4,2,2,0)
//        ));
//
//
////        Rectangles.add(new Circle_triangle(
////                Arrays.asList(
////                        //shaderFile lokasi menyesuaikan objectnya
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/scene.vert"
////                                        , GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/scene.frag"
////                                        , GL_FRAGMENT_SHADER)
////                ),
////                new ArrayList<>(),
////                new Vector4f(1.0f,1.0f,1.0f,0.0f),-0.75,0.8,0.1
////        ));
////
////
////        Rectangles.add(new Circle_square(
////                Arrays.asList(
////                        //shaderFile lokasi menyesuaikan objectnya
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/scene.vert"
////                                        , GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData
////                                ("resources/shaders/scene.frag"
////                                        , GL_FRAGMENT_SHADER)
////                ),
////                new ArrayList<>(),
////                new Vector4f(0.0f,1.0f,0.0f,0.0f),-0.75,0,0.3
////        ));
////
//        objectPointsControl.add(new Object2d(
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f)
//        ));
//    }
////    public void input(){
////        if (window.isKeyPressed(GLFW_KEY_W)){
////            System.out.printf("w");
////        }
////        if (window.getMouseInput().isLeftButtonPressed()){
////            Vector2f pos= window.getMouseInput().getCurrentPos();
////
////            pos.x=(pos.x-(window.getWidth())/2.0f) / (window.getWidth()/2.0f);
////            pos.y=(pos.y-(window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
//////            System.out.printf("x: "+pos.x +"y: "+pos.y);
////            if ((!(pos.x>1 || pos.x<-97)&& !(pos.y>0.97||pos.y<-1))){
////                System.out.println("x: "+pos.x +" y: "+pos.y);
////                objectPointsControl.get(0).addvertices(new Vector3f(pos.x,pos.y,0));
////            }
////
////        }
////    }
//public void input() {
//    if (window.isKeyPressed(GLFW_KEY_W)) {
//        System.out.println("W");
//    }
//    if (window.getMouseInput().isLeftButtonPressed()) {
//        Vector2f pos = window.getMouseInput().getCurrentPos();
//
//        pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//        pos.y = ((pos.y - (window.getHeight()) / 2.0f) / (window.getHeight() / 2.0f))*-1;
//
//
//        Rectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f((float) (pos.x+0.07),(float) (pos.y+0.07),0.0f),
//                                new Vector3f((float) (pos.x+0.07),(float) (pos.y-0.07),0.0f),
//                                new Vector3f((float) (pos.x-0.07),(float) (pos.y+0.07),0.0f),
//                                new Vector3f((float) (pos.x-0.07),(float) (pos.y-0.07),0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.0f, 2.0f, 1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//        // System.out.println("x: "+pos.x + "y: " + pos.y);
//        if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
////                System.out.println("x : " + pos.x + " y : " + pos.y);
//            System.out.println("x : " + pos.x + "y: " + pos.y);
//            objectPointsControl.get(0).addvertices(new Vector3f(pos.x, pos.y, 0));
//        }
//
//    }
//}
//    public void loop() {
//        while (window.isOpen()) {
//            window.update();
//            input();
//            glClearColor(0.0f, 0.0f,1.0f, 0.0f);
//            GL.createCapabilities();
//
//
//            glDisableVertexAttribArray(0);
//
//            for(Object2d object: objects){
//                object.drawWithVerticesColor();
//            }
//            for(Object2d object: Rectangles){
//                object.draw();
//            }
//            for(Object2d object: objectPointsControl){
//                object.drawline();
//            }
//
//            // Restore state
//            glDisableVertexAttribArray(0);
//
//            // Poll for window events.
//            // The key callback above will only be
//            // invoked during this call.
//            glfwPollEvents();
//        }
//    }
//
//    public void run() {
//        init();
//        loop();
//
//        glfwTerminate();
//        glfwSetErrorCallback(null).free();
//    }
//    public static void main (String[] args) {
//        new main().run();
//    }
//}