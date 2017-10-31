
package sample;

import javafx.scene.layout.Pane;


public class Selection {
    
    private final Letter letras =new Letter();
    private final Symbol simbolos =new Symbol();
    
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
            return simbolos.getUpComillasSimples();
        } if(character.equals('<')){
            return simbolos.getUpComillasEspOpen();
        } if(character.equals('>')){
            return simbolos.getUpComillasEspClose();
        } if(character.equals('"')){
            return simbolos.getUpComillasInglesas();
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
        if(character.equals(' ')){
    return simbolos.getUpEspacio();
}

        return letras.getUpUnknown();
    }

}
