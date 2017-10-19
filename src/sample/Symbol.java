
package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;


public class Symbol {
    
    private CubicCurve configurarCurva(CubicCurve c){
        c.setStroke(Color.FORESTGREEN);
        c.setStrokeWidth(4);
        c.setStrokeLineCap(StrokeLineCap.ROUND);
        c.setFill(null);
        c.setFocusTraversable(false);
        return c;
    }
    
    public Pane getUpCorcheteClose(){
        Pane letter =new Pane();
        letter.setMinSize(20,200);
        letter.setMaxSize(20,200);
        letter.setStyle("-fx-background-color: white;");

        Line linea =new Line();
        linea.setStartX(0) ;
        linea.setStartY(150) ;
        linea.setEndX(20) ;
        linea.setEndY(150) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        Line linea1 =new Line();
        linea1.setStartX(0) ;
        linea1.setStartY(50) ;
        linea1.setEndX(20) ;
        linea1.setEndY(50) ;
        linea1.setStroke(Color.FORESTGREEN);
        linea1.setStrokeWidth(4);
        linea1.setStrokeLineCap(StrokeLineCap.ROUND);

        Line linea2 =new Line();
        linea2.setStartX(19) ;
        linea2.setStartY(50) ;
        linea2.setEndX(19) ;
        linea2.setEndY(150) ;
        linea2.setStroke(Color.FORESTGREEN);
        linea2.setStrokeWidth(4);
        linea2.setStrokeLineCap(StrokeLineCap.ROUND);


        letter.getChildren().addAll(linea,linea1,linea2);

        return letter;
    }

    public Pane getUpCorcheteOpen(){
        Pane letter =new Pane();
        letter.setMinSize(20,200);
        letter.setMaxSize(20,200);
        letter.setStyle("-fx-background-color: white;");

        Line linea =new Line();
        linea.setStartX(0) ;
        linea.setStartY(150) ;
        linea.setEndX(20) ;
        linea.setEndY(150) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        Line linea1 =new Line();
        linea1.setStartX(0) ;
        linea1.setStartY(50) ;
        linea1.setEndX(20) ;
        linea1.setEndY(50) ;
        linea1.setStroke(Color.FORESTGREEN);
        linea1.setStrokeWidth(4);
        linea1.setStrokeLineCap(StrokeLineCap.ROUND);

        Line linea2 =new Line();
        linea2.setStartX(1) ;
        linea2.setStartY(50) ;
        linea2.setEndX(1) ;
        linea2.setEndY(150) ;
        linea2.setStroke(Color.FORESTGREEN);
        linea2.setStrokeWidth(4);
        linea2.setStrokeLineCap(StrokeLineCap.ROUND);


        letter.getChildren().addAll(linea,linea1,linea2);

        return letter;
    }
    
     public Pane getUpGuion(){
        Pane letter =new Pane();
        letter.setMinSize(30,200);
        letter.setMaxSize(30,200);
        letter.setStyle("-fx-background-color: white;");

        Line linea =new Line();
        linea.setStartX(0) ;
        linea.setStartY(120) ;
        linea.setEndX(30) ;
        linea.setEndY(120) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);


        letter.getChildren().addAll(linea);

        return letter;

    }
     
     public Pane getUpRaya(){
        Pane letter =new Pane();
        letter.setMinSize(40,200);
        letter.setMaxSize(40,200);
        letter.setStyle("-fx-background-color: white;");

        Line linea =new Line();
        linea.setStartX(0) ;
        linea.setStartY(150) ;
        linea.setEndX(40) ;
        linea.setEndY(150) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);


        letter.getChildren().addAll(linea);

        return letter;

    }

    public Pane getUpLlaveClose(){
        Pane letter =new Pane();
        letter.setMinSize(30,200);
        letter.setMaxSize(30,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve= new CubicCurve(0,50,30,50,0,100,30,100);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        CubicCurve curve1= new CubicCurve(30,100,0,100,30,150,0,150);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        letter.getChildren().addAll(curve, curve1);

        return letter;
    }

    public Pane getUpLlaveOpen(){
        Pane letter =new Pane();
        letter.setMinSize(30,200);
        letter.setMaxSize(30,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve= new CubicCurve(30,50,0,50,30,100,0,100);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        CubicCurve curve1= new CubicCurve(0,100,30,100,0,150,30,150);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        letter.getChildren().addAll(curve, curve1);

        return letter;
    }

    public Pane getUpParentesisClose(){
        Pane letter =new Pane();
        letter.setMinSize(26,200);
        letter.setMaxSize(26,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve= new CubicCurve(1,150,25,140,25,60,1,50);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        letter.getChildren().add(curve);

        return letter;
    }

    public Pane getUpParentesisOpen(){
        Pane letter =new Pane();
        letter.setMinSize(26,200);
        letter.setMaxSize(26,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve= new CubicCurve(25,150,0,140,0,60,25,50);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        letter.getChildren().add(curve);

        return letter;
    }

    public Pane getUpComillasEspClose(){
        Pane letter =new Pane();
        letter.setMinSize(40,200);
        letter.setMaxSize(40,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve= new CubicCurve(0,140,35,110,35,140,0,110);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        CubicCurve curve1= new CubicCurve(10,140,50,110,50,140,10,110);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        letter.getChildren().addAll(curve, curve1);

        return letter;
    }

    public Pane getUpComillasEspOpen(){
        Pane letter =new Pane();
        letter.setMinSize(40,200);
        letter.setMaxSize(40,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve= new CubicCurve(25,140,-10,110,-10,140,25,110);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        CubicCurve curve1= new CubicCurve(35,140,5,110,5,140,35,110);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        letter.getChildren().addAll(curve, curve1);

        return letter;
    }

    public Pane getUpComillasSimplesClose(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(90);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        CubicCurve curve= new CubicCurve(5,90,10,95,10,95,5,101);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        letter.getChildren().addAll(circle,curve);

        return letter;
    }

    public Pane getUpComillasSimplesOpen(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(90);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        CubicCurve curve= new CubicCurve(5,90,0,85,0,85,5,79);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        letter.getChildren().addAll(circle,curve);

        return letter;
    }

    public Pane getUpComillasInglesasClose(){
        Pane letter =new Pane();
        letter.setMinSize(22,200);
        letter.setMaxSize(22,200);
        letter.setStyle("-fx-background-color: white;");

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(90);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        CubicCurve curve= new CubicCurve(5,90,10,95,10,95,5,101);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        CubicCurve curve1= new CubicCurve(17,90,22,95,22,95,17,101);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        Circle circle1 = new Circle();
        circle1.setCenterX(17);
        circle1.setCenterY(90);
        circle1.setFill(Color.FORESTGREEN);
        circle1.setRadius(5);

        letter.getChildren().addAll(circle,circle1,curve,curve1);

        return letter;
    }

    public Pane getUpComillasInglesasOpen(){
        Pane letter =new Pane();
        letter.setMinSize(22,200);
        letter.setMaxSize(22,200);
        letter.setStyle("-fx-background-color: white;");

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(90);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        CubicCurve curve= new CubicCurve(5,90,0,85,0,85,5,79);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(3);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(null);
        curve.setFocusTraversable(false);

        CubicCurve curve1= new CubicCurve(17,90,12,85,12,85,17,79);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        Circle circle1 = new Circle();
        circle1.setCenterX(17);
        circle1.setCenterY(90);
        circle1.setFill(Color.FORESTGREEN);
        circle1.setRadius(5);

        letter.getChildren().addAll(circle,circle1,curve,curve1);

        return letter;
    }

    public Pane getUpDosPuntos(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");
        //punto1
        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(145);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        //punto2
        Circle circle1 = new Circle();
        circle1.setCenterX(5);
        circle1.setCenterY(110);
        circle1.setFill(Color.FORESTGREEN);
        circle1.setRadius(5);

        letter.getChildren().addAll(circle,circle1);

        return letter;
    }

    public Pane getUpPuntoComa(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");
        //coma
        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(145);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        CubicCurve curve1= new CubicCurve(5,145,10,150,10,150,5,156);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        //punto
        Circle circle1 = new Circle();
        circle1.setCenterX(5);
        circle1.setCenterY(110);
        circle1.setFill(Color.FORESTGREEN);
        circle1.setRadius(5);

        letter.getChildren().addAll(circle,circle1, curve1);

        return letter;
    }

    public Pane getUpComa(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(150);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        CubicCurve curve1= new CubicCurve(5,150,10,155,10,155,5,161);
        curve1.setStroke(Color.FORESTGREEN);
        curve1.setStrokeWidth(3);
        curve1.setStrokeLineCap(StrokeLineCap.ROUND);
        curve1.setFill(null);
        curve1.setFocusTraversable(false);

        letter.getChildren().addAll(circle, curve1);

        return letter;
    }

    public Pane getUpPunto(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(150);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        letter.getChildren().add(circle);

        return letter;
    }
     
    public Pane getUpExOpen(){
        Pane letter= new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");

        Line linea =new Line();
        linea.setStartX(5) ;
        linea.setStartY(60) ;
        linea.setEndX(5) ;
        linea.setEndY(150) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(45);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        letter.getChildren().addAll(linea,circle);

        return letter;
    }

    public Pane getUpExClose(){
        Pane letter= new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter.setStyle("-fx-background-color: white;");

        Line linea =new Line();
        linea.setStartX(5) ;
        linea.setStartY(50) ;
        linea.setEndX(5) ;
        linea.setEndY(140) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(155);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        letter.getChildren().addAll(linea,circle);

        return letter;
    }

    public Pane getUPPreguntaClose(){

        Pane letter= new Pane();
        letter.setMinSize(45,200);
        letter.setMaxSize(45,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve1= new CubicCurve(0,60,50,25,60,110,5,100);
        curve1 = this.configurarCurva(curve1);
        Line linea =new Line();
        linea.setStartX(5) ;
        linea.setStartY(100) ;
        linea.setEndX(5) ;
        linea.setEndY(145) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(155);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        letter.getChildren().addAll(curve1,linea,circle);

        return letter;
    }

    public Pane getUPPreguntaOpen(){

        Pane letter= new Pane();
        letter.setMinSize(45,200);
        letter.setMaxSize(45,200);
        letter.setStyle("-fx-background-color: white;");

        CubicCurve curve1= new CubicCurve(40,100,-15,110,-5,160,45,150);
        curve1 = this.configurarCurva(curve1);
        Line linea =new Line();
        linea.setStartX(40) ;
        linea.setStartY(100) ;
        linea.setEndX(40) ;
        linea.setEndY(55) ;
        linea.setStroke(Color.FORESTGREEN);
        linea.setStrokeWidth(4);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        Circle circle = new Circle();
        circle.setCenterX(40);
        circle.setCenterY(45);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);

        letter.getChildren().addAll(curve1,linea,circle);

        return letter;
    }
    public Pane getUpEspacio() {

        Pane letter = new Pane();
        letter.setMinSize(100, 200);
        letter.setMaxSize(100, 200);
        letter.setStyle("-fx-background-color: white;");

        letter.toFront();
        letter.setRotate(180);

        return letter;

    }

}
