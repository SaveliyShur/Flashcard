package flashcards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

        private static boolean exportFileNeed;

        public static void main(String[] args) {
            var cardGame = new Main();
            if (args.length != 0){
                Map<String, String> comandsLine = new HashMap<>();
                for (int i = 0; i < args.length; i++){
                    if ("-import".equals(args[i])){
                        if (i != args.length-1 && !"-export".equals(args[i+1])){
                            comandsLine.put("-import" , args[i+1]);
                        }
                    }
                    if ("-export".equals(args[i])){
                        if (i != args.length-1 && !"-import".equals(args[i+1])){
                            comandsLine.put("-export" , args[i+1]);
                        }
                    }
                }
                PlayGame comands = new PlayGame();
                exportFileNeed = comands.comandLineArguments(comandsLine);
            }
            cardGame.askForAction();
        }

        public  void askForAction() {
            PlayGame game = new PlayGame();
            boolean exit = false;
            while (!exit){
                game.ioLog("Input the action (add, remove, import," +
                        " export, ask, exit, log, hardest card, reset stats):\n");
                String actionInput = game.ioLog();
                switch (actionInput) {
                    case "add":
                        game.addCard();
                        break;
                    case "remove":
                        game.remove();
                        break;
                    case "import":
                        game.importFile();
                        break;
                    case "export":
                        game.exportToFile();
                        break;
                    case "ask":
                        game.askForCard();
                        break;
                    case "hardest card":
                        game.hardestCard();
                        break;
                    case "reset stats":
                        game.resetStats();
                        break;
                    case "log":
                        game.log();
                        break;
                    case "exit":
                        game.ioLog("Bye bye!");
                        if (exportFileNeed) {
                            game.exit();
                        }
                        exit = true;
                        break;
                }
            }
        }

}
