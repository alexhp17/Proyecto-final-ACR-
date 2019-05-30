/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.Random;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Juego {
    
    private int nivel;
    private int puntuacion;
    private double time;
    private String username;
    private String palabraJuego;
    private char[] palabraAux;
    
    
    
    String nivel1[]={"Mago", "Dado", "Gato", "Lago", "Mano", "Papa", "Kiwi", "Rana", 
                     "Baño", "Ropa", "Pato", "Pelo", "Pico", "Dedo", "Taco", "Bote"};
    String nivel2[]={"Silla", "Bomba", "Bicho", "Tabla", "Labio", "Cinco", "China", "Japon", 
                     "Disco", "Libro", "Cielo", "Hielo", "Elote", "Arena", "Cisne", "Fresa"};
    String nivel3[]={"Espejo", "Piedra", "Puente", "Iguana", "Azteca", "Diesel", "Atleta", "Sirena", 
                      "Maceta", "Marfil", "Vector", "Anillo", "Cabaña", "Obispo", "Dinero"};
    String nivel4[]={"Cerrojo", "Calzado", "Francia", "Desnudo", "Eclipse", "Gemelos", "Materia", "Mineral", 
                     "Mineral", "Negocio", "Navidad", "Tractor", "Nirvana", "Acuerdo", "Binario", "Disfraz"};
    String nivel5[]={"Avestruz", "Castillo", "Estudiar", "Guitarra", "Hospital", "Ladrillo", "Luchador", "Paraguas", 
                     "Tornillo", "Vainilla", "Langosta", "Ensalada", "Aceituna", "Edificio", "Princesa", "Columpio"};
    String nivel6[]={"Concierto", "Legumbres", "Aventuras", "Categoria", "Hechicero", "Masculino", "Mermelada", "Organizar", 
                     "Perseguir", "Sombrilla", "Tulipanes", "Mandarina", "Renacuajo", "Sonriente", "Pastillas", "Peligroso"};
    String nivel7[]={"Fabricante", "Garrafones", "Habitacion", "Zunzapotes", "Oaxaqueños", "Rabanillos", "Tabaquismo", "Xenofobia", 
                     "Vacaciones", "Yerbateros", "Gabardinas"};
    
    String palabras[][] = new String[][]{nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7};
    
    public Juego(String username){
        nivel = 0;
        this.time=0;
        this.puntuacion=0;
        this.username=username;
    }
    

   
   private void seleccionarPalabra(){
       Random r = new Random(); 
       int pos = r.nextInt(this.palabras[this.nivel].length);
       this.palabraJuego = this.palabras[this.nivel][pos];
       this.palabraAux = new char[this.palabraJuego.length()];
       for(int i=0;i<this.palabraJuego.length();i++)
           this.palabraAux[i]='-';
   }
   
   public void verificarLetra(String a){
       
       if(this.palabraJuego.contains(a)){
           char aux[] = this.palabraJuego.toCharArray();
           //this.palabraAux="";
          for(int i=0;i<this.palabraJuego.length();i++){
              if(this.palabraJuego.charAt(i)==a.charAt(0)){
                  this.palabraAux[i]=a.charAt(0);
              }
          }
          ///Verificar si ya esta completo para avanzar de nivel
          int cont=0;
           for (int i = 0; i < this.palabraAux.length; i++) {
              if(palabraAux[i]=='-')
               cont++;
           }      
          if(cont==0) {nivel++; seleccionarPalabra();}
          
          if(nivel==7)
               System.out.println("Has ganado");
          
           System.out.println(String.valueOf(this.palabraAux));
       }else{
           //Lo del ahorcado
       }
   }
   
   
   public static void main(String args[]){
//    String hola = "xoximilco"; 
//    if(hola.contains("x")) System.out.println("Lo contiene");
//    
//       for (int i = 0; i <100; i++) {
//            Random r = new Random(); 
//           System.out.println(r.nextInt(12+1)); 
//       }

   Juego j = new Juego("Cesar");
   j.seleccionarPalabra();
       System.out.println("");
   j.verificarLetra("a");
   j.verificarLetra("e");
   j.verificarLetra("i");
   j.verificarLetra("o");
   j.verificarLetra("u");
       System.out.println(j.palabraJuego);
       System.out.println("");   
   }
    
}
