
package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Scale;


public class Letter {
    
    //para señañar en que punto termina cada letra
    private int posicion=150;
    
    // para mostrar puntos de control
    private boolean mostrar=false;
    //validar
    private boolean negra=false;
    private boolean cursiva=false;
    private boolean subrayado=false;
    private boolean muyEnano=false;
    private boolean enano=false;
    private boolean grande=false;
    private boolean muyGrande=false;
    
    public void setPosicion(int posicion) 
    {
        this.posicion = posicion;
    }
    
    public boolean CambiarBoolean(String b){
        
        if (b.equals("S")){
            if (subrayado)
                subrayado=false;
            else subrayado=true;
                return subrayado;
        }
        if (b.equals("K")){
            if (cursiva)
                cursiva=false;
            else cursiva=true;
              return cursiva;    
        }
        if (b.equals("N")){
            if (negra)
                 negra=false;
            else negra=true;
                 return negra;
        }
        if (b.equals("2")){
            if (muyEnano)
                 muyEnano=false;
            else muyEnano=true;
                 return muyEnano;
        }
        if (b.equals("4")){
            if (enano)
                 enano=false;
            else enano=true;
                 return enano;
        }
        if (b.equals("6")){
            if (grande)
                 grande=false;
            else grande=true;
                 return grande;
        }
        if (b.equals("8")){
            if (muyGrande)
                 muyGrande=false;
            else muyGrande=true;
                 return muyGrande;
        }
        return false;
    }

    public boolean getMuyEnano() {
        return muyEnano;
    }

    public boolean getEnano() {
        return enano;
    }

    public boolean getGrande() {
        return grande;
    }

    public boolean getMuyGrande() {
        return muyGrande;
    }
     // obtener si es false o true
    public boolean getSubrayado(){
        return this.subrayado;
    }
    
    
    // obtener si es false o true
    public boolean getCursiva(){
        return this.cursiva;
    }
    
    // obtener si es false o true
    public boolean getNegra(){
        return this.negra;
    }
    
    // obtener si es false o true
    public boolean PuntosControl(){
        return this.mostrar;
    }
    // hace el cambio de false a true y al reves
    public boolean CambiarMostrar(){
        if (mostrar)
            mostrar=false;
        else mostrar=true;
     return mostrar;
    }
    // configurar las curvas a mostrar, grosor, color, etc
    private CubicCurve configurarCurva(CubicCurve c){
        c.setStroke(Color.FORESTGREEN);
        c.setStrokeWidth(4);
        c.setStrokeLineCap(StrokeLineCap.ROUND);
        c.setFill(null);
        c.setFocusTraversable(false);
        return c;
    }
    
    // configurar las curvas a mostrar, grosor, color, etc
    public CubicCurve negrita(CubicCurve c){
        c.setStroke(Color.FORESTGREEN);
        c.setStrokeWidth(8);
        c.setStrokeLineCap(StrokeLineCap.ROUND);
        c.setFill(null);
        c.setFocusTraversable(false);
        return c;
    }
    
    private Line lineSubrayado()
    {
        Line linea= new Line(1, 155, 100, 155);
        linea.setStroke(Color.MEDIUMVIOLETRED);
        linea.setStrokeWidth(5);
        return linea;
    }

    private CubicCurve crearCurva(int inicioX, int inicioY, int punto1X, int punto1Y, int punto2X, int punto2Y, int finX, int finY){
        if(cursiva){// hacer la cursiva
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
        
        if(negra) //hacer la negrita
            curve = negrita(curve);
       
        else curve = configurarCurva(curve);
        
        return curve;
    }
    
    private Pane configurarPane(Pane letter){
        letter.setMinSize(100,200);
        letter.setMaxSize(100,200);
        letter.setStyle("-fx-background-color: white;");
    
        Line linea= lineSubrayado();
        if(subrayado)
        {
            letter.getChildren().add(linea);
        }
        Scale scale =new Scale();
        scale.setPivotY(150);
        if(muyEnano) {
            scale.setY(0.2);
            letter.getTransforms().add(scale);}
         if(enano) {
            scale.setY(0.5);
            letter.getTransforms().add(scale);}
         if(grande) {
            scale.setY(1.5);  
            letter.getTransforms().add(scale);}
        if(muyGrande) {
            scale.setY(2);
            letter.getTransforms().add(scale);}
        
        return letter;
    }
    
    //hace visible los puntos de control de cada curva
    public Pane puntoControlVisible(CubicCurve curve, Pane letra)
    {
        Circle punto= new Circle(curve.getControlX1(), curve.getControlY1(), 5, Color.BLUE); 
        Circle punto1= new Circle(curve.getControlX2(), curve.getControlY2(), 5, Color.BLUE); 
        
        if(mostrar)
            letra.getChildren().addAll(curve,punto,punto1);
        
        return letra;
    }
    
    public Pane getUpA(){
        
        Pane letter= new Pane();
        letter=configurarPane(letter);
        
        CubicCurve curve1= crearCurva(50,30,15,30,20,115,25,130);
        letter= puntoControlVisible(curve1, letter);
                
        CubicCurve curve2= crearCurva(50,30,120,30,50,170,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3 = crearCurva(25,130,30,150,55,160,80,140);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false){
                letter.getChildren().addAll(curve1, curve2, curve3 );
        }
        
        return letter;
       
    }

    public Pane getUpB(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,30,50,0,125,60,55,75);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(35,30,30,150,5,155,70,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(55,75,120,85,95,150,70,150);
        letter= puntoControlVisible(curve3, letter);
        
        if (mostrar==false)
            letter.getChildren().addAll(curve1, curve2, curve3);
        return letter;
    }

    public Pane getUpC(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(85,30,-20,-20,-20,200,100,150);
        letter= puntoControlVisible(curve1, letter);
        if(mostrar==false)
            letter.getChildren().addAll(curve1);
        return letter;
    }

    public Pane getUpD(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,33,30,70,30,125,30,132);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(10,25,80,10,140,125,30,132);
        letter= puntoControlVisible(curve2, letter);
    
        if (mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }

    public Pane getUpE(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(25,10,28,40,0,190,100,115);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(10,15,30,0,75,30,90,5);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve3= crearCurva(10,70,40,50,60,80,80,60);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }

    public Pane getUpF(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(25,10,25,40,25,80,25,132);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(10,15,30,0,75,30,90,5);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(10,70,40,50,60,80,80,60);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }

    public Pane getUpG(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(50,150,10,180,-50,90,60,30);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(20,100,100,80,10,160,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);

        return letter;
    }
    
    public Pane getUpH(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(5,10,20,15,30,15,40,10);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(40,10,40,60,50,170,25,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(25,150,-5,65,120,50,90,10);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve4= crearCurva(90,10,70,5,70,170,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3, curve4);

        return letter;
    }

    public Pane getUpI() {

        Pane letter = new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1 = crearCurva(20, 20, 55, 25, 70, 25, 80, 20);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2 = crearCurva(80, 20, 80, 90, 95, 185, 25, 150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2);

        return letter;
    }

    public Pane getUpJ(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,120,-10,200,110,230,90,30);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,120,50,100,90,140,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(40,80,60,60,70,40,90,30);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)  
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpK(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,100,-10,150,30,220,30,30);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,100,70,80,80,110,80,30);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(30,100,90,100,70,150,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }
    
    public Pane getUpL(){
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,150,-10,130,10,230,90,15);
        letter= puntoControlVisible(curve1, letter);

        CubicCurve curve2= crearCurva(30,150,50,170,70,140,100,150);
        letter= puntoControlVisible(curve2, letter);

        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }

    public Pane getUpM(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,65,10,40,30,20,25,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(25,55,75,30,50,100,60,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(55,55,110,30,80,100,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpN(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,65, 10,50,30,20,10,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(20,60,100,10,35,150,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }

    public Pane getUpEnie(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,65, 20,50,30,20,10,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(20,65,110,-10,35,150,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(20,40,40,10,20,50,70,30);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3); 
        return letter;
    }
    
    public Pane getUpO(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(70,150, 0,200,-10,40,45,50);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(45,50,90,50,90,130,70,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(15,75,40,95,75,95,100,85);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        
        return letter;
    }

    public Pane getUpP(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,105, 30,200,30,200,20,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(20,150,0,10,50,20,80,50);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(80,50,110,80,100,120,30,120);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }
    
    public Pane getUpQ(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(70,150, 0,180,-10,40,45,35);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(45,35,120,40,90,150,70,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(10,105,40,155,90,100,95,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpR(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,60, 30,160,30,160,20,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(20,100,0,30,50,10,85,50);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(85,50,100,80,90,120,30,110);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve4= crearCurva(30,110,80,90,80,120,100,150);
        letter= puntoControlVisible(curve4, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3, curve4);
        return letter;
    }

    public Pane getUpS(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(15,150, 90, 0,70,10,50,30);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(50,30,150,100,20,170,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }
    
    public Pane getUpT(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(90,30,10,120,10,200,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,30,40,10,80,50,90,30);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(30,90,50,75,30,100,60,90);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar == false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }
    
    public Pane getUpU(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,15, 50,20,-40,180,80,145);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(70,15,110,15,55,170,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }
    
    public Pane getUpV(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,25, 60,20,-20,150,50,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(50,150,100,150,40,70,90,70);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }
    
    public Pane getUpW(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(10,25, 60,20,-20,180,50,120);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(50,120,110,180,40,50,90,70);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(50,120,60,90,40,90,50,120);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }
    
    public Pane getUpX() {
        
        Pane letter = new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1 = crearCurva(20, 30, 80, 0, 25, 170, 100, 150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2 = crearCurva(85, 30, 65, 35, 55, 120, 0, 150);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }
    
    public Pane getUpY(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,140,-10,160,100,270,70,20);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,140,60,120,80,135,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(30,20,10,100,90,120,70,20);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar == false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }
    
    public Pane getUpZ() {

        Pane letter = new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1 = crearCurva(20, 30, 80, 0, 130, 66, 50, 110);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2 = crearCurva(50, 110, 190, 240, -30, 180, 100, 150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2);

        return letter;
    }
        
    public Pane getUpa(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(65,100,-5,80,0,190,65,145);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(65,100,60,140,65,160,100,150);
        letter= puntoControlVisible(curve2, letter);

        if(posicion==85)
        {
            CubicCurve curve3= crearCurva(0,85,20,75,25,100,65,100);
            letter= puntoControlVisible(curve3, letter);
            if (mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);
        
            return letter;
        }
        else if(posicion==110)
        {
            CubicCurve curve3= crearCurva(0,110,10,110,15,110,25,105);
            letter= puntoControlVisible(curve3, letter);
            if (mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);
        
            return letter;
        }
        
        CubicCurve curve3= crearCurva(0,150,5,150,10,145,15,140);
        letter= puntoControlVisible(curve3, letter);
        
        if (mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        
        return letter;
    }

    public Pane getUpb(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(40,10,15,15,10,180,60,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(60,150,75,135,65,110,70,110);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve4= crearCurva(70,110,80,110,85,110,100,110);
        letter= puntoControlVisible(curve4, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,25,100,75,20,40,10);
            letter= puntoControlVisible(curve1, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3, curve4);
            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,25,140,85,20,40,10);
        letter= puntoControlVisible(curve1, letter);
        
        if (mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3, curve4);
        return letter;
    }
    
    public Pane getUpc(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(75,100,15,80,0,190,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        if(posicion==85)
        {
            CubicCurve curve2= crearCurva(0,85,20,75,30,105,45,100);
            letter= puntoControlVisible(curve2, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve1, curve2);
            return letter;
        
        }
        
        if(posicion==110)
        {
            CubicCurve curve2= crearCurva(0,110,20,110,30,115,40,105);
            letter= puntoControlVisible(curve2, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve1, curve2);
            return letter;
        }
        CubicCurve curve2= crearCurva(0,150,20,140,30,125,30,115);
        letter= puntoControlVisible(curve2, letter);
        
        if (mostrar==false)
            letter.getChildren().addAll(curve1, curve2);
        return letter;
    }

    public Pane getUpd(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(60,90,-5,80,0,190,65,140);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(60,90,60,140,65,160,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3 = crearCurva(60,90,60,100,60,40,65,15);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve4= crearCurva(0,110,15,110,20,105,30,95);
            letter= puntoControlVisible(curve4, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve1, curve2, curve3, curve4);
            return letter;
        }
        
        CubicCurve curve4 = crearCurva(0,150,5,150,10,145,15,140);
        letter= puntoControlVisible(curve4, letter);
        
        if (mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3, curve4);
        return letter;
    }
    
    public Pane getUpe(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(75,100,30,65,-20,170,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(75,100,90,130,30,145,35,145);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve3= crearCurva(0,110,5,110,20,110,45,95);
            letter= puntoControlVisible(curve2, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve1, curve2, curve3);
            return letter;
        }
        
        CubicCurve curve3= crearCurva(0,150,15,150,25,145,35,145);
        letter= puntoControlVisible(curve3, letter);

        if(mostrar== false)
            letter.getChildren().addAll(curve1, curve2, curve3);

        return letter;
    }
        
    public Pane getUpf(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(90,30,75,-50,15,250,60,190);
        letter= puntoControlVisible(curve1, letter);
        
        if(posicion==110)
        {
            
            CubicCurve curve2= crearCurva(60,190,85,145,0,70,100,150);
            letter= puntoControlVisible(curve2, letter);
            
            CubicCurve curve3= crearCurva(0,110,25,110,100,135,90,30);
            letter= puntoControlVisible(curve3, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve1, curve2, curve3);
            return letter;
        }
        
        CubicCurve curve2= crearCurva(60,190,85,145,0,90,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        
        CubicCurve curve3= crearCurva(0,150,65,125,100,80,90,30);
        letter= puntoControlVisible(curve3, letter);        
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }
    
    public Pane getUpg(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve= crearCurva(50,90,100,90,80,170,30,135);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(80,120,95,270,-25,160,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        if(posicion==110)
        {
            
            CubicCurve curve2= crearCurva(50,90,20,95,15,120,30,135);
            letter= puntoControlVisible(curve2, letter);
            
            CubicCurve curve3= crearCurva(0,110,35,100,20,100,50,90);
            letter= puntoControlVisible(curve3, letter);
        
            if (mostrar==false)
                letter.getChildren().addAll(curve, curve1, curve2, curve3);
            return letter;
        }
        
        CubicCurve curve2= crearCurva(30,135,20,130,15,90,50,90);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(0,150,25,150,15,90,45,90);
        letter= puntoControlVisible(curve3, letter);
        
        
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, curve2, curve3);
        return letter;
    }

    public Pane getUph(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(30,150,25,80,65,85,65,130);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(65,130,65,155,85,155,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,130,10,0,-50,30,150);
            letter= puntoControlVisible(curve, letter);
            
            if(mostrar== false)
                letter.getChildren().addAll(curve, curve1, curve2);
            
            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,120,0,20,-50,30,150);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, curve2);
        
        return letter;
    }

    public Pane getUpi(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(50,100,50,130,60,160,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curvePunto = crearCurva(50,80,50,80,50,80,50,80);
        letter= puntoControlVisible(curvePunto, letter);
  
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,35,110,50,105,50,100);
            letter= puntoControlVisible(curve, letter);
            
            if(mostrar==false)
                letter.getChildren().addAll(curve, curve1, curvePunto);
            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,35,150,50,130,50,100);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curvePunto);
        return letter;
    }

    public Pane getUpj(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(30,100,100,290,-60,120,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curvePunto = crearCurva(30,80,30,80,30,80,30,30);
        letter= puntoControlVisible(curvePunto, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,20,110,30,105,30,100);
            letter= puntoControlVisible(curve, letter);
        
            if(mostrar== false)
                letter.getChildren().addAll(curve, curve1, curvePunto);

            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,10,150,20,125,30,100);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, curvePunto);

        return letter;
    }

    public Pane getUpk(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(35,105,70,70,75,140,40,125);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(40,125,55,130,85,160,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,155,-5,5,-30,40,150);
            letter= puntoControlVisible(curve, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve, curve1, curve2);
        
             return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,150,-35,15,-40,40,150);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2);
        
        return letter;
    }
    
    public Pane getUpl(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(45,10,10,20,20,165,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,60,110,70,25,45,10);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2);

            return letter;
            
        }
        
        CubicCurve curve1= crearCurva(0,150,60,160,70,25,45,10);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);

        return letter;
    }
      
    public Pane getUpm(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(40,150,35,75,70,80,65,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve3= crearCurva(65,150,55,80,90,85,90,125);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve2= crearCurva(90,125,90,130,90,150,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,30,105,40,65,40,150);
            letter= puntoControlVisible(curve, letter);
            
            if(mostrar==false)
                letter.getChildren().addAll(curve, curve1, curve2, curve3);

            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,30,135,40,40,40,150);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2, curve3);

        return letter;
    }

    public Pane getUpn(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(45,150,40,85,70,85,75,125);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(75,125,75,160,85,155,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,20,105,45,60,45,150);
            letter= puntoControlVisible(curve, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve, curve1, curve2);
            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,20,135,40,45,45,150);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2);
        return letter;
    }
    
    public Pane getDownEnie(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(30,105,95,75,40,150,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(15,80,40,90,50,70,65,80);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,25,95,30,85,30,150);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);
            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,25,85,30,75,30,150);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpo(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(30,140,20,120,30,85,65,100);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(65,100,100,135,55,175,30,140);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,105,60,110,60,115,100,110);
        letter= puntoControlVisible(curve2, letter);
        
        
        if(posicion==110)
        {
            CubicCurve curve3= crearCurva(0,110,15,110,20,105,30,105);
            letter= puntoControlVisible(curve3, letter);
        
            if(mostrar== false)
                letter.getChildren().addAll(curve, curve1, curve2, curve3);
            return letter;
        }
        
        CubicCurve curve3= crearCurva(0,150,15,145,20,140,25,125);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, curve2, curve3);
        return letter;
    }

    public Pane getUpp(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(35,100,35,130,35,120,35,200);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(35,105,85,75,85,175,35,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(35,150,65,150,75,155,100,150);
        letter= puntoControlVisible(curve3, letter);

        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,20,105,25,105,35,100);
            letter= puntoControlVisible(curve, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve, curve1, curve2, curve3);
        
            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,20,130,25,120,35,100);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2, curve3);
        
        return letter;
    }

    public Pane getUpq(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(70,100,70,150,70,150,70,200);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(70,100,10,90,10,165,70,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(40,170,50,165,65,160,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,20,110,25,105,45,100);
            letter= puntoControlVisible(curve, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve,curve1, curve2, curve3);
        
            return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,20,145,25,145,30,140);
        letter= puntoControlVisible(curve, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve,curve1, curve2, curve3);
        
        return letter;
    }

    public Pane getUpr(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(30,100,65,100,65,100,75,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(75,100,60,130,80,160,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,35,105,20,105,30,100);
            letter= puntoControlVisible(curve, letter);
            if(mostrar==false)
                letter.getChildren().addAll(curve,curve1, curve2);
        
        return letter;
        }
        
        CubicCurve curve= crearCurva(0,150,35,140,30,125,30,100);
        letter= puntoControlVisible(curve, letter);
            
        if(mostrar==false)
            letter.getChildren().addAll(curve,curve1, curve2);
        
        return letter;
    }
    
    public Pane getUps(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(50,100,75,140,55,160,30,145);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(30,145,55,160,75,150,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,30,110,40,105,50,100);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);
            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,30,135,40,125,50,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpt(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(100,150,35,160,40,140,50,10);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(25,60,30,50,50,70,70,60);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,40,100,55,90,50,10);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);
            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,50,160,55,140,50,10);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpu(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(25,100,15,170,65,170,60,100);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(60,100,55,150,80,155,90,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,15,110,20,105,25,100);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);

            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,20,145,25,125,25,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }
        
    public Pane getUpv(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(40,115,45,160,80,160,85,110);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(85,110,90,110,100,110,100,110);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,25,115,35,80,40,115);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)  
                letter.getChildren().addAll(curve1,curve2, curve3);
            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,25,149,35,75,40,115);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)  
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;

    }

    public Pane getUpw(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(30,100,20,170,60,170,55,100);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(55,100,50,170,90,170,85,105);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve4= crearCurva(85,105,90,110,95,110,100,110);
        letter= puntoControlVisible(curve4, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,10,110,20,105,30,100);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3, curve4);

            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,10,140,30,125,30,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3, curve4);

        return letter;
    }

    public Pane getUpx(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(40,100,90,175,100,160,115,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(40,155,65,130,85,115,100,100);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,25,105,30,105,40,100);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);

            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,25,135,30,90,40,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }
    
    public Pane getUpy(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(30,100,25,160,80,160,75,100);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(75,90,90,285,-20,150,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,20,105,30,90,30,100);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);

            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,30,150,35,90,30,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }

    public Pane getUpz(){

        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve2= crearCurva(45,100,70,110,65,140,45,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(45,150,85,220,-40,180,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(posicion==110)
        {
            CubicCurve curve1= crearCurva(0,110,20,105,25,95,45,100);
            letter= puntoControlVisible(curve1, letter);
        
            if(mostrar==false)
                letter.getChildren().addAll(curve1,curve2, curve3);

            return letter;
        }
        
        CubicCurve curve1= crearCurva(0,150,30,140,20,100,45,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }
    
    public Pane getUpUnknown() {

        Pane letter = new Pane();
        letter= configurarPane(letter);

        letter.toFront();

        return letter;
    }
    
}
