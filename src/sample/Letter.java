
package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Shear;


public class Letter {
    
    //para señañar en que punto termina cada letra
    private int posicion=150;
    
    // para mostrar puntos de control
    private boolean mostrar=false;
    //validar
    private boolean negra=false;
    private boolean cursiva=false;
    private boolean subrayado=false;
    
    
    public void setPosicion(int posicion) 
    {
        this.posicion = posicion;
    }
    
     // obtener si es false o true
    public boolean getSubrayado(){
        return this.subrayado;
    }
    
    // hace el cambio de false a true y al reves
    public boolean CambiarSubrayado(){
        if (subrayado)
            subrayado=false;
        else subrayado=true;
     return subrayado;
    }
    
    // obtener si es false o true
    public boolean getCursiva(){
        return this.cursiva;
    }
    
    // hace el cambio de false a true y al reves
    public boolean CambiarCursiva(){
        if (cursiva)
            cursiva=false;
        else cursiva=true;
     return cursiva;
    }
    
    // obtener si es false o true
    public boolean getNegra(){
        return this.negra;
    }
    
    // hace el cambio de false a true y al reves
    public boolean CambiarNegra(){
        if (negra)
            negra=false;
        else negra=true;
     return negra;
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
    private CubicCurve negrita(CubicCurve c){
        c.setStroke(Color.FORESTGREEN);
        c.setStrokeWidth(8);
        c.setStrokeLineCap(StrokeLineCap.ROUND);
        c.setFill(null);
        c.setFocusTraversable(false);
        return c;
    }
    
    public Pane ponerCursiva(Pane letter)
    {
        Shear sh = new Shear();
        sh.setX(-0.3);
        letter.getTransforms().add(sh);
     
        return letter;
    }
    
    private Line lineSubrayado()
    {
        Line linea= new Line(1, 155, 100, 155);
        linea.setStroke(Color.MEDIUMVIOLETRED);
        linea.setStrokeWidth(5);
        return linea;
    }

    private CubicCurve crearCurva(int inicioX, int inicioY, int punto1X, int punto1Y, int punto2X, int punto2Y, int finX, int finY){
        CubicCurve curve= new CubicCurve(inicioX,inicioY,punto1X,punto1Y,punto2X,punto2Y,finX,finY);
        
        if(negra)
            curve = negrita(curve);
       
        else curve = configurarCurva(curve);
        
        return curve;
    }
    
    private Pane configurarPane(Pane letter){
        letter.setMinSize(100,200);
        letter.setMaxSize(100,200);
        letter.setStyle("-fx-background-color: white;");
        
        Line line= lineSubrayado();
        
        if(subrayado)
            letter.getChildren().add(line);
        
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
        
        Line line= lineSubrayado();
        
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
        
        CubicCurve curve2= crearCurva(20,100,100,80,10,160,70,150);
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
        
        CubicCurve curve4= crearCurva(90,10,70,5,70,170,100,148);
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
        
        CubicCurve curve2= crearCurva(30,120,50,100,90,140,90,150);
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
        
        CubicCurve curve3= crearCurva(30,100,90,100,70,150,90,150);
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
        
        CubicCurve curve3= crearCurva(55,55,110,30,80,100,90,150);
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
        
        CubicCurve curve2= crearCurva(20,60,100,10,35,150,85,150);
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
        
        CubicCurve curve2= crearCurva(20,65,110,-10,35,150,85,150);
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
        
        CubicCurve curve3= crearCurva(15,75,40,85,75,85,100,75);
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
        
        CubicCurve curve4= crearCurva(30,110,80,90,80,120,90,150);
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
        
        CubicCurve curve2= crearCurva(50,30,150,100,20,170,90,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);
        return letter;
    }
    
    public Pane getUpT(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(90,30,10,120,10,200,90,150);
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
        
        CubicCurve curve2= crearCurva(70,15,110,15,55,170,95,150);
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
        
        CubicCurve curve2 = crearCurva(50, 110, 190, 240, -30, 180, 100, 148);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2);

        return letter;
    }
        
    public Pane getUpa(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(65,100,-5,80,0,190,65,140);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(65,100,60,140,65,160,100,150);
        letter= puntoControlVisible(curve2, letter);

        if(posicion==75)
        {
            CubicCurve curve3= crearCurva(0,75,30,75,35,120,65,100);
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
        
        CubicCurve curve3 = crearCurva(60,90,60,100,60,40,65,35);
        letter= puntoControlVisible(curve3, letter);
        
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
        
        CubicCurve curve2= crearCurva(0,150,15,150,25,145,30,145);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(75,100,90,130,30,145,30,145);
        letter= puntoControlVisible(curve3, letter);

        if(mostrar== false)
            letter.getChildren().addAll(curve1, curve2, curve3);

        return letter;
    }
        
    public Pane getUpf(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(90,35,70,0,20,230,60,185);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(60,185,85,145,0,90,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(0,150,65,125,100,80,90,35);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }
    
    public Pane getUpg(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,50,150,15,90,50,90);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(50,90,100,90,80,170,30,135);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(80,120,95,270,-25,160,100,150);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, curve2);
        return letter;
    }

    public Pane getUph(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,100,0,10,-50,25,150);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(25,150,20,80,60,85,60,130);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(60,130,60,160,70,155,75,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, curve2);
        
        return letter;
    }

    public Pane getUpi(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,20,150,25,130,25,100);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(25,100,25,130,20,160,50,150);
        letter= puntoControlVisible(curve1, letter);
        
        Circle circle = new Circle();
        circle.setCenterX(30);
        circle.setCenterY(80);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, circle);
        return letter;
    }

    public Pane getUpj(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,10,150,20,125,30,100);
        letter= puntoControlVisible(curve, letter);

        CubicCurve curve1= crearCurva(30,100,50,270,-50,160,50,150);
        letter= puntoControlVisible(curve1, letter);
        
        Circle circle = new Circle();
        circle.setCenterX(30);
        circle.setCenterY(80);
        circle.setFill(Color.FORESTGREEN);
        circle.setRadius(5);
        
        if(mostrar== false)
            letter.getChildren().addAll(curve, curve1, circle);

        return letter;
    }

    public Pane getUpk(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,150,-35,15,-40,40,150);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(35,105,70,70,75,140,40,125);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(40,125,55,130,85,160,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2);
        
        return letter;
    }
    
    public Pane getUpl(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,60,160,70,25,45,10);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(45,10,10,20,30,170,75,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2);

        return letter;
    }
      
    public Pane getUpm(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,148,30,135,45,55,45,150);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(45,150,40,85,75,90,70,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve3= crearCurva(70,150,60,90,95,100,95,125);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve2= crearCurva(95,125,95,130,95,140,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2, curve3);

        return letter;
    }

    public Pane getUpn(){
        
        Pane letter =new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,20,135,40,50,45,150);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(45,150,40,90,70,90,75,125);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(75,125,75,160,85,155,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2);
        return letter;
    }
    
    public Pane getDownEnie(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150, 25,85,30,75,30,150);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,105,95,75,40,150,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(15,80,40,90,50,70,65,80);
        letter= puntoControlVisible(curve3, letter);
        
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
        
        CubicCurve curve2= crearCurva(30,105,60,120,60,115,100,110);
        letter= puntoControlVisible(curve2, letter);
        
        
        if(posicion==110)
        {
            CubicCurve curve3= crearCurva(0,110,15,115,20,110,25,115);
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

        CubicCurve curve= crearCurva(0,150,15,130,20,120,25,100);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(25,100,25,130,25,120,25,200);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(25,110,75,75,75,170,25,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(25,150,50,150,60,155,75,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve, curve1, curve2, curve3);
        
        return letter;
    }

    public Pane getUpq(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve= crearCurva(0,150,10,145,15,145,20,140);
        letter= puntoControlVisible(curve, letter);
        
        CubicCurve curve1= crearCurva(60,100,60,150,60,150,60,200);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(60,100,0,90,0,165,60,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(40,170,50,165,65,160,80,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve,curve1, curve2, curve3);
        
        return letter;
    }

    public Pane getUpr(){
        
        Pane letter= new Pane();
        letter= configurarPane(letter);
        
        CubicCurve curve1= crearCurva(25,100,65,100,65,100,75,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(75,100,60,130,80,160,100,150);
        letter= puntoControlVisible(curve2, letter);
        
        if(posicion==110)
        {
            CubicCurve curve= crearCurva(0,110,35,110,20,110,25,100);
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

        CubicCurve curve1= crearCurva(0,150,25,135,35,125,45,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(45,100,70,140,50,160,25,145);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(25,145,50,160,70,150,75,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpt(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,50,160,55,140,60,10);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(100,150,45,160,50,140,60,10);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(35,60,40,60,60,60,85,60);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);
        return letter;
    }

    public Pane getUpu(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,20,145,25,125,25,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(25,100,15,170,65,170,60,100);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(60,100,55,150,80,155,90,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }
        
        public Pane getUpv(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,25,149,40,75,50,115);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(50,115,50,160,80,160,80,105);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve3= crearCurva(80,105,90,110,100,110,100,110);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)  
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;

    }

    public Pane getUpw(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,10,140,30,125,30,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,100,20,170,65,170,60,100);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(60,100,50,170,95,170,90,100);
        letter= puntoControlVisible(curve3, letter);
        
        CubicCurve curve4= crearCurva(90,100,100,100,110,100,120,100);
        letter= puntoControlVisible(curve1, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3, curve4);

        return letter;
    }

    public Pane getUpx(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,25,135,30,90,40,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(40,100,90,175,100,160,115,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(40,155,65,130,85,115,100,100);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }
    
    public Pane getUpy(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,30,150,35,90,30,120);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(30,120,25,160,80,160,75,100);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(75,90,90,285,-20,150,100,150);
        letter= puntoControlVisible(curve3, letter);
        
        if(mostrar==false)
            letter.getChildren().addAll(curve1,curve2, curve3);

        return letter;
    }

    public Pane getUpz(){

        Pane letter= new Pane();
        letter= configurarPane(letter);

        CubicCurve curve1= crearCurva(0,150,30,140,25,100,45,100);
        letter= puntoControlVisible(curve1, letter);
        
        CubicCurve curve2= crearCurva(45,100,70,110,65,140,45,150);
        letter= puntoControlVisible(curve2, letter);
        
        CubicCurve curve3= crearCurva(45,150,85,220,-40,180,75,150);
        letter= puntoControlVisible(curve3, letter);
        
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
