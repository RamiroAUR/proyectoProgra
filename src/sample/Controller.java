
package sample;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;

public class Controller implements Initializable{

    private @FXML TextField inputText;
    private @FXML Group groupA;
    private @FXML Button applyExpRegular;
    private @FXML Button pointControl;
    private @FXML TextField inputExpresion;
    private @FXML ScrollPane scroll;
    private @FXML Rectangle rect;
    private final Letter letras =new Letter();
    private final Selection selection =new Selection();
    private ArrayList<Pane> panesLetras =new ArrayList<>();
    
    
    public void getText(){
        System.out.println(this.inputText);

    }

    public void clearGroup(){
        ArrayList<Node> nodes= new ArrayList<>();
        for(Node n:this.groupA.getChildren()){
            if(n instanceof Rectangle){

            }else{
                nodes.add(n);
            }
        }
        if(nodes.size()>0){
            for(Node ni:nodes){
                this.groupA.getChildren().remove(ni);
            }
        }
    }

    public void autohideAlert(String title, int wait){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(wait);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        Optional<ButtonType> result = alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // texto en forma dinamica
        
        inputText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {

                    clearGroup();
                    ArrayList<Pane> panes= getPwithSting(s2);
//                    ArrayList<Pane> panesLetras= getPwithSting(s2);
                     double x=0, y=0,x_word=0;
                double anchoActual= scroll.getWidth()-50;
                ArrayList<Pane> word= new ArrayList<>();
                for(Pane pane:panes){
//                    for(Pane pane:panesLetras){
                    pane.setStyle("-fx-background-color: transparent;");
                    pane.toFront();
                    pane.setLayoutY(y);
                    pane.setLayoutX(x);
                    groupA.getChildren().addAll(pane);
                    pane.toFront();
                    x= x+pane.getMaxWidth();

                    if(pane.getRotate()==0){//pregunto si el panel no es espacio
                        word.add(pane);
                        x_word+=x;

                    }else{// entra si es espacio
                        System.out.println(pane.getChildren().isEmpty());
                        if(word.isEmpty()){//palabra es vacia?

                        }else{//palabra no es vacia
                            x_word=0;
                            if(x<=scroll.getWidth()){//la palabra se sale del ancho visible?
                                word.clear();

                            }else{
                                y+=200;
                                for(Pane t_p:word){
                                    t_p.setLayoutX(x_word);
                                    t_p.setLayoutY(y);
                                    x_word+=t_p.getMaxWidth();
                                }
                                x=x_word+100;
                            }
                        }
                    }
            }
            }});
        
        //boton para mostrar puntos de control
        this.pointControl.setOnMouseClicked(e->{
                letras.CambiarMostrar();
           
            this.clearGroup();
            String input= this.inputText.getText();
            if(input!=null&&!input.equals("")){
                ArrayList<Pane> panes= this.getPwithSting(input);
                                double x=0, y=0,x_word=0;
                double anchoActual= scroll.getWidth()-50;
                ArrayList<Pane> word= new ArrayList<>();
                for(Pane pane:panes){
                    pane.setStyle("-fx-background-color: transparent;");
                    pane.toFront();
                    pane.setLayoutY(y);
                    pane.setLayoutX(x);
                    groupA.getChildren().addAll(pane);
                    pane.toFront();
                    x= x+pane.getMaxWidth();

                    if(pane.getRotate()==0){//pregunto si el panel no es espacio
                        word.add(pane);
                        x_word+=x;

                    }else{// entra si es espacio
                        System.out.println(pane.getChildren().isEmpty());
                        if(word.isEmpty()){//palabra es vacia?

                        }else{//palabra no es vacia
                            x_word=0;
                            if(x<=scroll.getWidth()){//la palabra se sale del ancho visible?
                                word.clear();

                            }else{
                                y+=200;
                                for(Pane t_p:word){
                                    t_p.setLayoutX(x_word);
                                    t_p.setLayoutY(y);
                                    x_word+=t_p.getMaxWidth();
                                }
                                x=x_word+100;
                            }
                        }
                    }



            
                }
            }else{
                autohideAlert("¡No ha ingresado texto!",3000);
            }
        }
        
        );

        
//        inputExpresion.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String SAntiguo, String SNuevo) {
//
//                boolean conito;
//                ArrayList<String> expresion= getExp(SNuevo,",");
//                String primerExp= expresion.get(0);
//                conito =existeConito(primerExp);
//            }
//        });

        
        // boton para aplicar la expresion regular
        this.applyExpRegular.setOnMouseClicked(e->{
            boolean conito;

            ArrayList<Pane> panestotal=new ArrayList<>();   
            System.out.println("expresion: "+this.inputExpresion.getText());
            // tengo las expresiones para todo
            String inputExp =this.inputExpresion.getText();
            if(inputExp!=null&&!inputExp.equals("")){
                // ver si tiene conito o no
                ArrayList<String> expresion= this.getExp(inputExp,",");
                String primerExp = expresion.get(0);
                conito =existeConito(primerExp);
                // si es que existe, elimino el conito sino tira a la alerta
                if(conito){ 
                    String lineaSinConito=primerExp.substring(1, primerExp.length());
                    expresion.set(0, lineaSinConito);
                     ArrayList<Pane> paneT=new ArrayList<>();
                    for(int c=0;c<expresion.size();c++){ // va por expresion
                        
                        ArrayList<Pane> panes=getEstilo(expresion.get(c),c); // aplicar estilo
                        for(Pane p: panes){
                            paneT.add(p);
                        }            
                    }
                    int posicionFinal=paneT.size();
                    String restoInputT = inputText.getText();
                    String resto = restoInputT.substring(posicionFinal, restoInputT.length());
                    ArrayList<Pane> panesResto= getPwithSting(resto);
                    for(Pane p:panesResto){
                        paneT.add(p);
                    }
                    this.clearGroup();
                                    double x=0, y=0,x_word=0;
                double anchoActual= scroll.getWidth()-50;
                ArrayList<Pane> word= new ArrayList<>();
                for(Pane pane:paneT){
                    pane.setStyle("-fx-background-color: transparent;");
                    pane.toFront();
                    pane.setLayoutY(y);
                    pane.setLayoutX(x);
                    groupA.getChildren().addAll(pane);
                    pane.toFront();
                    x= x+pane.getMaxWidth();

                    if(pane.getRotate()==0){//pregunto si el panel no es espacio
                        word.add(pane);
                        x_word+=x;

                    }else{// entra si es espacio
                        System.out.println(pane.getChildren().isEmpty());
                        if(word.isEmpty()){//palabra es vacia?

                        }else{//palabra no es vacia
                            x_word=0;
                            if(x<=scroll.getWidth()){//la palabra se sale del ancho visible?
                                word.clear();

                            }else{
                                y+=200;
                                for(Pane t_p:word){
                                    t_p.setLayoutX(x_word);
                                    t_p.setLayoutY(y);
                                    x_word+=t_p.getMaxWidth();
                                }
                                x=x_word+100;
                            }
                        }
                    }
                }
                }

            
                else {
                    autohideAlert("¡No ha ingresado Expresion Correctamente!(ejemplo: ^S,K)",4000);
                }
            }
            else{
                autohideAlert("¡No ha ingresado texto!(ejemplo: ^S,K)",4000);
            }
        });
        
    }
    
    // agregar el estilo y tamanio 
        public ArrayList<Pane> getEstilo(String tipoEstilo, int posicionPalabra){
        
        ArrayList<Pane>panes=combinarEstilo(tipoEstilo,posicionPalabra);
           
        panes.add(letras.getUpUnknown());
        
       return panes; 
    }

    private ArrayList<Pane> combinarEstilo(String estilo, int indexP){
                        
        int total=0;
        for(int i=0; i<estilo.length();i++){
            char e=estilo.charAt(i);
            total=total+(int)e;
        }

        ArrayList<String> palabra= getPalabra();
        
        switch (total){
        
            case 83://S
            {
                letras.CambiarBoolean("S");
                System.out.println("sub");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("S");
                return panes;
                
            }
            case 176://S+2
            {
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("2");
                System.out.println("sub");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 178://S+4
            {
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("4");
                System.out.println("sub");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 180://S+6
            {
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("6");
                System.out.println("sub");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 182://S+8
            {
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("8");
                System.out.println("sub");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 78://N
            {
                letras.CambiarBoolean("N");
                System.out.println("negra");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                return panes;
            }
            case 171://N+2
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("2");
                System.out.println("negra");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 173://N+4
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("4");
                System.out.println("negra");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 175://N+6
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("6");
                System.out.println("negra");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 177://N+8
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("8");
                System.out.println("negra");
                ArrayList<Pane> panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 75://K
            {
                letras.CambiarBoolean("K");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                return panes;
            }
            case 168://K+2
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("2");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 170://K+4
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("4");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 172://K+6
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("6");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 174://K+8
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("8");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 196://K+N
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                return panes;    
            }
            case 289: //K+N+2
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("2");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 291: //K+N+4
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("4");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 293: //K+N+6
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("6");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 295: //K+N+8
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("8");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 201://K+S
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                return panes;
            }
            case 294://K+S+2
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("2");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 296://K+S+4
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("4");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 298://K+S+6
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("6");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 300://K+S+8
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("8");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 204://S+N
            {
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("N");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("N");
                return panes;
            }
            case 297://S+N+2
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("2");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 299://S+N+4
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("4");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 301://S+N+6
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("6");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 303://S+N+8
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("8");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 322://K+N+S
            {
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                return panes;
            }
            case 415://K+N+S+2
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("2");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("2");
                return panes;
            }
            case 417://K+N+S+4
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("4");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("4");
                return panes;
            }
            case 419://K+N+S+6
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("6");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("6");
                return panes;
            }
            case 420://K+N+S+8
            {
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("8");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("N");
                letras.CambiarBoolean("S");
                letras.CambiarBoolean("K");
                letras.CambiarBoolean("8");
                return panes;
            }
            case 50://2
            {
                letras.CambiarBoolean("2");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("2");
                return panes;
            }
            case 52://4
            {
                letras.CambiarBoolean("4");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("4");
                return panes;
            }
            case 54://6
            {
                letras.CambiarBoolean("6");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("6");
                return panes;
            }
            case 56://8
            {
                letras.CambiarBoolean("8");
                ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
                letras.CambiarBoolean("8");
                return panes;
            }
            default:
                break;
        }
        ArrayList<Pane>panes= this.getPwithSting(palabra.get(indexP));
        return panes;
       
    }
    
    private ArrayList<String> getPalabra(){
        ArrayList<String> palabra=new ArrayList<>();

        String input= this.inputText.getText();
        if(input!=null&&!input.equals("")){
            // separar por palabras
            System.out.println("input: "+input);            
            StringTokenizer tokens = new StringTokenizer(input);
            while(tokens.hasMoreTokens()){
                palabra.add(tokens.nextToken());
            }
        //--------imprimir nomas---------------
            for (int q =0; q<palabra.size();q++){
            System.out.println("palabra: "+palabra.get(q));
            }
        }
        else{
            autohideAlert("¡No ha ingresado texto!(ejemplo: ^S,K)",4000);
        }

        return palabra;
    }
    
    
    
    //ver si tiene el conito al principio
    public boolean existeConito(String S){
        boolean cono;
        char letraOCono = S.charAt(0);
        if (letraOCono=='^')
            return cono=true;
        else return cono=false;
    }
    
    // obtener la expresion regular por partes
    public ArrayList<String> getExp(String string, String separador){
        if(string==null) {
            return null;
        }else {
            ArrayList<String> expresiones =new ArrayList<>();
            String[] lista= string.split(separador);
            for (String exp: lista){
                if (exp.equals(" "))
                    expresiones.add(" ");
                else
                expresiones.add(exp);
                
            } 
            return expresiones;
        }
    }
    //obtener las caracteres
    public ArrayList<Pane> getPwithSting(String string){
        if(string==null) {
            return null;
        }else {
            ArrayList<Pane> panes= new ArrayList<>();
            for (Character character:string.toCharArray()){
                panes.add(selection.getPwithChar(character));

            }
            return panes;
        }
    }
}
