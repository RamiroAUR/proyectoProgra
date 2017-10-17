
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
    private @FXML TextField expresion;
    private @FXML ScrollPane scroll;
    private @FXML Rectangle rect;
    private final Letter letras =new Letter();
    private final Symbol simbolos =new Symbol();
    
    
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
                double x=0, y=0;
                for(Pane pane:panes){
                    pane.setStyle("-fx-background-color: blueviolet;");
                    pane.toFront();
                    pane.setLayoutY(y);
                    pane.setLayoutX(x);
                    groupA.getChildren().addAll(pane);
                    pane.toFront();
                    System.out.println("x="+x);
                    System.out.println("I add");
                    x= x+pane.getMaxWidth();
                    if (x>=800){
                        x=0;
                        y=y+200;
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
                double x=0, y=0;
                for(Pane pane:panes){
                    pane.setStyle("-fx-background-color: blueviolet;");
                    pane.toFront();
                    pane.setLayoutY(y);
                    pane.setLayoutX(x);
                    this.groupA.getChildren().addAll(pane);
                    pane.toFront();
                    
                    x= x+pane.getMaxWidth();
                }
            }else{
                autohideAlert("¡No ha ingresado texto!",3000);
            }
        }
        
        );

        // boton para aplicar la expresion regular
        this.applyExpRegular.setOnMouseClicked(e->{
            boolean conito;
            // ubicaciones
            
//            double h1=0; double v1=0;
            
            // tengo las expresiones para todo
            String inputExp =this.expresion.getText();
            if(inputExp!=null&&!inputExp.equals("")){
                // ver si tiene conito o no
                ArrayList<String> expresion= this.getExp(inputExp,",");
                String primerExp = expresion.get(0);
                conito =existeConito(primerExp);
                // si es que existe, elimino el conito sino tira a la alerta
                if(conito){ 
                    String lineaSinConito=primerExp.substring(1, primerExp.length());
                    expresion.set(0, lineaSinConito);
                    for(int c=0;c<expresion.size();c++){ // va por expresion 
                        getEstilo(expresion.get(c),c); // aplicar estilo
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
        public void getEstilo(String tipoEstilo, int posicionPalabra){
        // reemplazo el "+" porque me tira error, solo porque es "+" (nose porque Dx)
        String tipoEstilo1=tipoEstilo.replace('+', '-');
        // separo los estilos si es que tiene mas de 1
        ArrayList<String> fullEstilo= this.getExp(tipoEstilo1,"-");
        
        ArrayList<Pane> panes=new ArrayList<>();
        
        this.clearGroup(); 
        // tengo el texto completo a maquillar
        String input= this.inputText.getText();
        if(input!=null&&!input.equals("")){
            // separar por palabras
            System.out.println("input: "+input);
            ArrayList<String> palabras =new ArrayList<>();
            
            StringTokenizer tokens = new StringTokenizer(input);
            while(tokens.hasMoreTokens()){
                palabras.add(tokens.nextToken());
            }
        //--------imprimir nomas---------------
            for (int q =0; q<palabras.size();q++){
            System.out.println("palabra: "+palabras.get(q));
            }
            //---------------------------
            //seleccionar palabra
            String word = palabras.get(posicionPalabra);
            System.out.println("palabra select: "+word);

            // aplicar estilo uno por uno  
            for(int c=0;c<fullEstilo.size();c++){
                 String L=fullEstilo.get(c);
                 System.out.println("estiloSelec: "+L);
                    // primero veo si es numero para el tamaño de las letras
                    if(isNumeric(L)){
                        int proporcion=Integer.parseInt(L);
                    } 
                    else {// sino lo convierto a caracter y aplico estilo
                        char estilo=L.charAt(0);// cuando no hay char ni un espacio tira error
                        System.out.println("letra; "+estilo);
                        if(estilo=='N'||estilo=='n'){
                            System.out.println("negra "); 
                              letras.CambiarNegra();
                              ArrayList<Pane> panes= this.getPwithSting(word);
                              letras.CambiarNegra();
                        }
                        else{
                            if (estilo=='S'||estilo=='s'){
                                System.out.println("subrayado");
                                letras.CambiarSubrayado();
                                ArrayList<Pane> panes= this.getPwithSting(word);
                                letras.CambiarSubrayado();
                            }
                            else {
                                if(estilo=='K'||estilo=='k'){
                                    System.out.println("cursiva");
                                    letras.CambiarCursiva();
                                    ArrayList<Pane> panes= this.getPwithSting(word);
                                    letras.CambiarCursiva();
                                }
                            }
                        }
                    }
                    
            }
//                            autohideAlert("¡No existe ese tipo de estilo!",4000);
//                            ;
//                        }
//                    }    
//                }
//         }
//        else {
//            autohideAlert("¡No ha ingresado texto!",4000);
//        }
//       
        }
    }

    
    
    // ver si una expresion es un numero... para hacer las proporciones de las letras
    private boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
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
                panes.add(this.getPwithChar(character));

            }
            return panes;
        }
    }
    
    public Pane crearPaneLetra(Pane pane, int i)
    {
        Pane panel= pane;
        letras.setPosicion(i);
        return panel;
    }
    
    // obtener los caracteres artisticos
    public Pane getPwithChar(Character character){
        
        
        
        switch (character) {
            
            case 'A':
            {
                Pane pane= crearPaneLetra(letras.getUpA(), 150);
                return pane;
            }
                
            case 'B':
            {
                Pane pane= crearPaneLetra(letras.getUpB(), 150);
                return pane;
            }
            
            case 'C':
            {
                Pane pane= crearPaneLetra(letras.getUpC(), 150);
                return pane;
            }
            
            case 'D':
            {
                Pane pane= crearPaneLetra(letras.getUpD(), 150);
                return pane;
            }
            
            case 'E':
            {
                Pane pane= crearPaneLetra(letras.getUpE(), 150);
                return pane;
            }
            
            case 'F':
            {
                Pane pane= crearPaneLetra(letras.getUpF(), 150);
                return pane;
            }
            
            case 'G':
            {
                Pane pane= crearPaneLetra(letras.getUpG(), 150);
                return pane;
            }
            
            case 'H':
            {
                Pane pane= crearPaneLetra(letras.getUpH(), 150);
                return pane;
            }
            
            case 'I':
            {
                Pane pane= crearPaneLetra(letras.getUpI(), 150);
                return pane;
            }
            
            case 'J':
            {
                Pane pane= crearPaneLetra(letras.getUpJ(), 150);
                return pane;
            }
            
            case 'K':
            {
                Pane pane= crearPaneLetra(letras.getUpK(), 150);
                return pane;
            }
            
            case 'L':
            {
                Pane pane= crearPaneLetra(letras.getUpL(), 150);
                return pane;
            }
            
            case 'M':
            {
                Pane pane= crearPaneLetra(letras.getUpM(), 150);
                return pane;
            }
            
            case 'N':
            {
                Pane pane= crearPaneLetra(letras.getUpN(), 150);
                return pane;
            }
            
            case 'Ñ':
            {
                Pane pane= crearPaneLetra(letras.getUpEnie(), 150);
                return pane;
            }
            
            case 'O':
            {
                Pane pane= crearPaneLetra(letras.getUpO(), 85);
                return pane;
            }
                    
            case 'P':
            {
                Pane pane= crearPaneLetra(letras.getUpP(), 150);
                return pane;
            }
            
            case 'Q':
            {
                Pane pane= crearPaneLetra(letras.getUpQ(), 150);
                return pane;
            }
            
            case 'R':
            {
                Pane pane= crearPaneLetra(letras.getUpR(), 150);
                return pane;
            }
            
            case 'S':
            {
                Pane pane= crearPaneLetra(letras.getUpS(), 150);
                return pane;
            }
            
            case 'T':
            {
                Pane pane= crearPaneLetra(letras.getUpT(), 150);
                return pane;
            }
            
            case 'U':
            {
                Pane pane= crearPaneLetra(letras.getUpU(), 150);
                return pane;
            }
            
            case 'V':
            {
                Pane pane= crearPaneLetra(letras.getUpV(), 150);
                return pane;
            }
            
            case 'W':
            {
                Pane pane= crearPaneLetra(letras.getUpW(), 150);
                return pane;
            }
            
            case 'X':
            {
                Pane pane= crearPaneLetra(letras.getUpX(), 150);
                return pane;
            }
            
            case 'Y':
            {
                Pane pane= crearPaneLetra(letras.getUpY(), 150);
                return pane;
            }
            
            case 'Z':
            {
                Pane pane= crearPaneLetra(letras.getUpZ(), 150);
                return pane;
            }
            
            case 'a':
            {
                Pane pane= crearPaneLetra(letras.getUpa(), 150);
                return pane;
            }
            
            case 'b':
            {
                Pane pane= crearPaneLetra(letras.getUpb(), 110);
                return pane;
            }
            
            case 'c':
            {
                Pane pane= crearPaneLetra(letras.getUpc(), 150);
                return pane;
            }
            
            case 'd':
            {
                Pane pane= crearPaneLetra(letras.getUpd(), 150);
                return pane;
            }
            
            case 'e':
            {
                Pane pane= crearPaneLetra(letras.getUpe(), 150);
                return pane;
            }
            
            case 'f':
            {
                Pane pane= crearPaneLetra(letras.getUpf(), 150);
                return pane;
            }
            
            case 'g':
            {
                Pane pane= crearPaneLetra(letras.getUpg(), 150);
                return pane;
            }
            
            case 'h':
            {
                Pane pane= crearPaneLetra(letras.getUph(), 150);
                return pane;
            }
            
            case 'i':
            {
                Pane pane= crearPaneLetra(letras.getUpi(), 150);
                return pane;
            }
            
            case 'j':
            {
                Pane pane= crearPaneLetra(letras.getUpj(), 150);
                return pane;
            }
            
            case 'k':
            {
                Pane pane= crearPaneLetra(letras.getUpk(), 150);
                return pane;
            }
            
            case 'l':
            {
                Pane pane= crearPaneLetra(letras.getUpl(), 150);
                return pane;
            }
            
            case 'm':
            {
                Pane pane= crearPaneLetra(letras.getUpm(), 150);
                return pane;
            }
            
            case 'n':
            {
                Pane pane= crearPaneLetra(letras.getUpn(), 150);
                return pane;
            }
            
            case 'ñ':
            {
                Pane pane= crearPaneLetra(letras.getDownEnie(), 150);
                return pane;
            }
            
            case 'o':
            {
                Pane pane= crearPaneLetra(letras.getUpo(), 110);
                return pane;
            }
            
            case 'p':
            {
                Pane pane= crearPaneLetra(letras.getUpp(), 150);
                return pane;
            }
            
            case 'q':
            {
                Pane pane= crearPaneLetra(letras.getUpq(), 150);
                return pane;
            }
            
            case 'r':
            {
                Pane pane= crearPaneLetra(letras.getUpr(), 150);
                return pane;
            }
            
            case 's':
            {
                Pane pane= crearPaneLetra(letras.getUps(), 150);
                return pane;
            }
            
            case 't':
            {
                Pane pane= crearPaneLetra(letras.getUpt(), 150);
                return pane;
            }
            
            case 'u':
            {
                Pane pane= crearPaneLetra(letras.getUpu(), 150);
                return pane;
            }
            
            case 'v':
            {
                Pane pane= crearPaneLetra(letras.getUpv(), 110);
                return pane;
            }
            
            case 'w':
            {
                Pane pane= crearPaneLetra(letras.getUpw(), 110);
                return pane;
            }
            
            case 'x':
            {
                Pane pane= crearPaneLetra(letras.getUpx(), 150);
                return pane;
            }
            
            case 'y':
            {
                Pane pane= crearPaneLetra(letras.getUpy(), 150);
                return pane;
            }
            
            case 'z':
            {
                Pane pane= crearPaneLetra(letras.getUpz(), 150);
                return pane;
            }
            
            default:
                break;
        } 

        if(character.equals('¿')){
            return simbolos.getUPPreguntaOpen();
        } if(character.equals('?')){
            return simbolos.getUPPreguntaClose();
        } if(character.equals('¡')){
            return simbolos.getUpExOpen();
        } if(character.equals('!')){
            return simbolos.getUpExClose();
        } if(character.equals('.')) {
            return simbolos.getUpPunto();
        } if(character.equals(',')){
            return simbolos.getUpComa();
        } if(character.equals(';')){
            return simbolos.getUpPuntoComa();
        } if(character.equals(':')){
            return simbolos.getUpDosPuntos();
        } if((int)character == 39){
            return simbolos.getUpComillasSimplesOpen();
        } if(character.equals('<')){
            return simbolos.getUpComillasEspOpen();
        } if(character.equals('>')){
            return simbolos.getUpComillasEspClose();
        } if(character.equals('"')){
            return simbolos.getUpComillasInglesasOpen();
        } if(character.equals('(')){
            return simbolos.getUpParentesisOpen();
        } if(character.equals(')')){
            return simbolos.getUpParentesisClose();
        } if(character.equals('[')){
            return simbolos.getUpCorcheteOpen();
        } if(character.equals(']')){
            return simbolos.getUpCorcheteClose();
        } if(character.equals('{')){
            return simbolos.getUpLlaveOpen();
        } if(character.equals('}')){
            return simbolos.getUpLlaveClose();
        } if(character.equals('-')){
            return simbolos.getUpGuion();
        } if(character.equals('_')){
            return simbolos.getUpRaya();
        }
        return letras.getUpUnknown();
    }

}
