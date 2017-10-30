
package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Scale;


public class Symbol {
    
    private Letter letras=new Letter();
    
    private CubicCurve configurarCurva(CubicCurve c){
        c.setStroke(Color.FORESTGREEN);
        c.setStrokeWidth(4);
        c.setStrokeLineCap(StrokeLineCap.ROUND);
        c.setFill(null);
        c.setFocusTraversable(false);
        return c;
    }
    
    private CubicCurve crearCurva(int inicioX, int inicioY, int punto1X, int punto1Y, int punto2X, int punto2Y, int finX, int finY){
        if(letras.getCursiva()){// hacer la cursiva
            if(inicioY<=100){
                inicioX+=25;
            }
            
            if(punto1Y<=100){
                punto1X+=25;
            }
            
            if(punto2Y<=100){
                punto2X+=25;
            }
            
            if(finY<=100){
                finX+=25;
            }
            if(inicioY>150){
                inicioX-=25;
            }
            
            if(punto1Y>150){
                punto1X-=25;
            }
            
            if(punto2Y>150){
                punto2X-=25;
            }
            
            if(finY>150){
                finX-=25;
            }
        }
        
        CubicCurve curve= new CubicCurve(inicioX,inicioY,punto1X,punto1Y,punto2X,punto2Y,finX,finY);
        
        if(letras.getNegra()) //hacer la negrita
            curve = letras.negrita(curve);
       
        else curve = configurarCurva(curve);
        
        return curve;
    }
    
    public Pane configurarPane(Pane letter,int finX){
        letter.setStyle("-fx-background-color: white;");
        Line linea= new Line(1, 155, finX, 155);
        linea.setStroke(Color.MEDIUMVIOLETRED);
        linea.setStrokeWidth(5);
        
        if(letras.getSubrayado())
        {
            letter.getChildren().add(linea);
        }
        Scale scale =new Scale();
        scale.setPivotY(150);
        if(letras.getMuyEnano()) {
            scale.setY(0.2);
            letter.getTransforms().add(scale);}
         if(letras.getEnano()) {
            scale.setY(0.5);
            letter.getTransforms().add(scale);}
         if(letras.getGrande()) {
            scale.setY(1.5);  
            letter.getTransforms().add(scale);}
        if(letras.getMuyGrande()) {
            scale.setY(2);
            letter.getTransforms().add(scale);}
        
        return letter;
    }
    
    public Pane getUpCorcheteClose(){
        Pane letter =new Pane();
        letter.setMinSize(20,200);
        letter.setMaxSize(20,200);
        
        letter=configurarPane(letter, 20);
        
        CubicCurve curve1 =crearCurva(0, 150, 0, 150, 20, 150, 20, 150);
         letter= letras.puntoControlVisible(curve1, letter);

         CubicCurve curve2 =crearCurva(0, 50, 0, 50, 20, 50, 20, 50);
         letter= letras.puntoControlVisible(curve2, letter);
        
         CubicCurve curve3 =crearCurva(19, 50, 19, 50, 19, 150, 19, 150);
         letter= letras.puntoControlVisible(curve3, letter);
        
         if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2,curve3);
         }
        return letter;
    }

    public Pane getUpCorcheteOpen(){
        Pane letter =new Pane();
        letter.setMinSize(20,200);
        letter.setMaxSize(20,200);
        letter=configurarPane(letter, 20);

        CubicCurve curve1 =crearCurva(0, 150, 0, 150, 20, 150, 20, 150);
         letter= letras.puntoControlVisible(curve1, letter);

         CubicCurve curve2 =crearCurva(0, 50, 0, 50, 20, 50, 20, 50);
         letter= letras.puntoControlVisible(curve2, letter);
        
         CubicCurve curve3 =crearCurva(1, 50, 1, 50, 1, 150, 1, 150);
         letter= letras.puntoControlVisible(curve3, letter);
        
         if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2,curve3);
         }
        return letter;
    }
    
     public Pane getUpGuion(){
        Pane letter =new Pane();
        letter.setMinSize(30,200);
        letter.setMaxSize(30,200);
        letter=configurarPane(letter, 30);

        CubicCurve curve1 =crearCurva(0, 120, 0, 120, 30, 120, 30, 120);
         letter= letras.puntoControlVisible(curve1, letter);

       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1);
         }
        return letter;
    }
     
     public Pane getUpRaya(){
        Pane letter =new Pane();
        letter.setMinSize(40,200);
        letter.setMaxSize(40,200);
        letter=configurarPane(letter, 40);

        CubicCurve curve1 =crearCurva(0, 150, 0, 150, 40, 150, 40, 150);
         letter= letras.puntoControlVisible(curve1, letter);

       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1);
         }
        return letter;
    }

    public Pane getUpLlaveClose(){
        Pane letter =new Pane();
        letter.setMinSize(30,200);
        letter.setMaxSize(30,200);
        letter=configurarPane(letter, 30);

        CubicCurve curve1 =crearCurva(0,50,30,50,0,100,30,100);
         letter= letras.puntoControlVisible(curve1, letter);
         
         CubicCurve curve2 =crearCurva(30,100,0,100,30,150,0,150);
         letter= letras.puntoControlVisible(curve2, letter);

       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }
        return letter;
    }

    public Pane getUpLlaveOpen(){
        Pane letter =new Pane();
        letter.setMinSize(30,200);
        letter.setMaxSize(30,200);
        letter=configurarPane(letter, 30);

        CubicCurve curve1 =crearCurva(30,50,0,50,30,100,0,100);
         letter= letras.puntoControlVisible(curve1, letter);
         
         CubicCurve curve2 =crearCurva(0,100,30,100,0,150,30,150);
         letter= letras.puntoControlVisible(curve2, letter);

       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }

        return letter;
    }

    public Pane getUpParentesisClose(){
        Pane letter =new Pane();
        letter.setMinSize(26,200);
        letter.setMaxSize(26,200);
        letter=configurarPane(letter, 26);

        CubicCurve curve1 =crearCurva(1,150,25,140,25,60,1,50);
         letter= letras.puntoControlVisible(curve1, letter);
         
       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1);
         }
        return letter;
    }

    public Pane getUpParentesisOpen(){
        Pane letter =new Pane();
        letter.setMinSize(26,200);
        letter.setMaxSize(26,200);
        letter=configurarPane(letter, 26);

        CubicCurve curve1 =crearCurva(25,150,0,140,0,60,25,50);
         letter= letras.puntoControlVisible(curve1, letter);
         
       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1);
         }

        return letter;
    }

    public Pane getUpComillasEspClose(){
        Pane letter =new Pane();
        letter.setMinSize(40,200);
        letter.setMaxSize(40,200);
        letter=configurarPane(letter, 40);

        CubicCurve curve1 =crearCurva(0,140,35,110,35,140,0,110);
         letter= letras.puntoControlVisible(curve1, letter);
         
         CubicCurve curve2 =crearCurva(10,140,50,110,50,140,10,110);
         letter= letras.puntoControlVisible(curve2, letter);
         
       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }

        return letter;
    }

    public Pane getUpComillasEspOpen(){
        Pane letter =new Pane();
        letter.setMinSize(40,200);
        letter.setMaxSize(40,200);
        letter=configurarPane(letter, 40);

        CubicCurve curve1 =crearCurva(25,140,-10,110,-10,140,25,110);
         letter= letras.puntoControlVisible(curve1, letter);
         
         CubicCurve curve2 =crearCurva(35,140,5,110,5,140,35,110);
         letter= letras.puntoControlVisible(curve2, letter);
         
       if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }

        return letter;
    }

    public Pane getUpComillasSimples(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);
        
        CubicCurve curve1 =crearCurva(5,90,5,90,5,90,5,90);
         letter= letras.puntoControlVisible(curve1, letter);


        CubicCurve curve2= crearCurva(5,90,5,95,5,95,5,101);        
         letter= letras.puntoControlVisible(curve2, letter);

        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }

        return letter;
    }

    
    public Pane getUpComillasInglesas(){
        Pane letter =new Pane();
        letter.setMinSize(22,200);
        letter.setMaxSize(22,200);
        letter=configurarPane(letter, 22);
        
        CubicCurve curve1 =crearCurva(5,90,5,90,5,90,5,90);
         letter= letras.puntoControlVisible(curve1, letter);

        CubicCurve curve2= crearCurva(5,90,5,95,5,95,5,101);
         letter= letras.puntoControlVisible(curve2, letter);

        CubicCurve curve3 =crearCurva(17,90,17,90,17,90,17,90);
         letter= letras.puntoControlVisible(curve1, letter);

        CubicCurve curve4= crearCurva(17,90,17,95,17,95,17,101);
         letter= letras.puntoControlVisible(curve2, letter);

        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2,curve3,curve4);
         }
        
        return letter;
    }

    public Pane getUpDosPuntos(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);
        //punto bot
        CubicCurve curve1 =crearCurva(5,145,5,145,5,145,5,145);
         letter= letras.puntoControlVisible(curve1, letter);

//punto top
        CubicCurve curve2= crearCurva(5,110,5,110,5,110,5,110);
         letter= letras.puntoControlVisible(curve2, letter);

        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }

        return letter;
    }

    public Pane getUpPuntoComa(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);
        //coma
        CubicCurve curve1 =crearCurva(5,145,5,145,5,145,5,145);
        letter= letras.puntoControlVisible(curve1, letter);
         
        CubicCurve curve2 =crearCurva(5,145,10,150,10,150,5,156);
         letter= letras.puntoControlVisible(curve2, letter);
        
        //punto
        CubicCurve curve3 =crearCurva(5,110,5,110,5,110,5,110);
        letter= letras.puntoControlVisible(curve3, letter);
         
        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2,curve3);
         }
        return letter;
    }

    public Pane getUpComa(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);
        //coma
        CubicCurve curve1 =crearCurva(5,150,5,150,5,150,5,150);
        letter= letras.puntoControlVisible(curve1, letter);
         
        CubicCurve curve2 =crearCurva(5,150,10,155,10,155,5,161);
         letter= letras.puntoControlVisible(curve2, letter);

        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2);
         }
        return letter;
    }

    public Pane getUpPunto(){
        Pane letter =new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);

        CubicCurve curve1 =crearCurva(5,150,5,150,5,150,5,150);
        letter= letras.puntoControlVisible(curve1, letter);
         
        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1);
         }
        return letter;
    }
     
    public Pane getUpExOpen(){
        Pane letter= new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);

        CubicCurve curve1 =crearCurva(5,60,5,60,5,150,5,150);
        letter= letras.puntoControlVisible(curve1, letter);
         
        CubicCurve curve2 =crearCurva(5,45,5,45,5,45,5,45);
        letter= letras.puntoControlVisible(curve2, letter);
        
        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1, curve2);
         }
        return letter;
    }

    public Pane getUpExClose(){
        Pane letter= new Pane();
        letter.setMinSize(10,200);
        letter.setMaxSize(10,200);
        letter=configurarPane(letter, 10);

        CubicCurve curve1 =crearCurva(5,50,5,50,5,140,5,140);
        letter= letras.puntoControlVisible(curve1, letter);
         
        CubicCurve curve2 =crearCurva(5,155,5,155,5,155,5,155);
        letter= letras.puntoControlVisible(curve2, letter);
        
        if (letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1, curve2);
         }

        return letter;
    }

    public Pane getUPPreguntaClose(){

        Pane letter= new Pane();
        letter.setMinSize(45,200);
        letter.setMaxSize(45,200);
        letter=configurarPane(letter, 45);

        CubicCurve curve1=crearCurva(0,60,50,25,60,110,5,100);
        letter= letras.puntoControlVisible(curve1, letter);
        
        CubicCurve curve2=crearCurva(5,100,5,100,5,145,5,145);
        letter= letras.puntoControlVisible(curve2, letter);
        
        CubicCurve curve3=crearCurva(5,155,5,155,5,155,5,155);
        letter= letras.puntoControlVisible(curve3, letter);
        
        if(letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2,curve3);
        }

        return letter;
    }

    public Pane getUPPreguntaOpen(){

        Pane letter= new Pane();
        letter.setMinSize(45,200);
        letter.setMaxSize(45,200);
        letter=configurarPane(letter, 45);

        CubicCurve curve1=crearCurva(40,100,-15,110,-5,160,45,150);
        letter= letras.puntoControlVisible(curve1, letter);
        
        CubicCurve curve2=crearCurva(40,100,40,100,40,55,40,55);
        letter= letras.puntoControlVisible(curve2, letter);
        
        CubicCurve curve3=crearCurva(40,45,40,45,40,45,40,45);
        letter= letras.puntoControlVisible(curve3, letter);
        
        if(letras.PuntosControl()==false){
            letter.getChildren().addAll(curve1,curve2,curve3);
        }   

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
