import com.pendu.game.GuessGame;
import java.util.Random;
import java.util.Scanner;

/**
 * Entrypoint GuessGame Class
 */
public class Main {
   /**
    * Entry point of the Guess Game. Contains the main algorithm of the game.
    */
   public static void main(String[] args) {

      final var random = new Random();
      final var words = "voiture soleil montagne babiole coeur malade souris maison balais bougie".split(" ");
      var wordToGuess = words[random.nextInt(words.length)];
      var game = new GuessGame(wordToGuess, 10);

      System.out.println("Bienvenue au jeu du pendu !");

      while(true){
         System.out.println(game);

         final var letter = getLetter("Veuillez entrer une lettre :");

         game.guessLetter(letter);

         if (game.isLost()) {
            System.out.println(game);
            System.out.println("Perdu !");
         }
         if (game.isWon()){
            System.out.println(game);
            System.out.println("Gagné !");
         }
         if(game.isWon() || game.isLost()){
            var replayAnswer = getLetter("Voulez-vous rejouer ? o / n :");
            if(replayAnswer == 'o' || replayAnswer == 'O'){
               wordToGuess = words[random.nextInt(words.length)];
               game = new GuessGame(wordToGuess, 10);
            }else {
               break;
            }
         }
      }
   }

   private static char getLetter(String question) {
      final var scanner = new Scanner(System.in);

      Character letter = null;

      do {
         System.out.println(question);
         var input = scanner.nextLine();
         if(input.length() == 1){
            letter = input.charAt(0);
         } else {
            System.out.println("Erreur : Vous devez entrer une seule lettre.");
         }
      }while(letter == null);

      return letter;
   }
}