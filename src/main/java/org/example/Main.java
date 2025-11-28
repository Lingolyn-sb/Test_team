import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String usuario;
    static String nnombre;
    static String allnombre;
    static String nivel;
    static final String[] PALABRAS_BASE = {};
    static String[] PALABRAS_JUEGO = PALABRAS_BASE;
    static String[][] PALABRAS_VOCABULARIO;
    static String palabraSecreta;
    static char[] palabraAdivinada;
    static char[] letrasIncorrectas = new char[6];
    static int contadorIncorrectas = 0;
    static final int INTENTOS_MAXIMOS = 6;
    static int aciertos = 0;
    static int errores = 0;

    static int[] palabrasFalladas = new int[10];
    static int contadorFallos = 0;

    static int[] pistaUsada = new int[10];

    static Random random = new Random();

    /*DECLARACION DE NIVELES SPELLING BEE*/
    static String [][] nsbBasico = {
            {"add", "Complete the sentence with the correct English word:\nPlease ___ the numbers to get the result.", "Read the definition and write the correct English word:\nTo combine two or more numbers.", "Write the English word for this Spanish meaning:\nAgregar"},
            {"eye", "Complete the sentence with the correct English word:\nShe closed one ___.", "Read the definition and write the correct English word:\nThe organ you use to see.", "Write the English word for this Spanish meaning:\nOjo"},
            {"ear", "Complete the sentence with the correct English word:\nHe whispered the secret into my ___.", "Read the definition and write the correct English word:\nThe organ you use to hear sounds.", "Write the English word for this Spanish meaning: \nOreja"},
            {"boat", "Complete the sentence with the correct English word:\nWe crossed the lake in a small ___.", "Read the definition and write the correct English word:\nA vehicle used to travel on water.", "Write the English word for this Spanish meaning: \nBarco"},
            {"happy", "Complete the sentence with the correct English word:\nShe felt very ___ on her birthday.", "Read the definition and write the correct English word:\nFeeling joy or pleasure.", "Write the English word for this Spanish meaning: \nFeliz"},
            {"lion", "Complete the sentence with the correct English word:\nThe ___ is known as the king of the jungle.", "Read the definition and write the correct English word:\nA large wild cat with a mane.", "Write the English word for this Spanish meaning: \nLeón"},
            {"night", "Complete the sentence with the correct English word:\nI like to read at ___.", "Read the definition and write the correct English word:\nThe time of day when it is dark.", "Write the English word for this Spanish meaning: \nNoche"},
            {"milk", "Complete the sentence with the correct English word:\nCould you buy some ___ at the store?", "Read the definition and write the correct English word:\nA white liquid produced by cows.", "Write the English word for this Spanish meaning: \nLeche"},
            {"uncle", "Complete the sentence with the correct English word:\nMy ___ visits us every Sunday.", "Read the definition and write the correct English word:\nYour parents’ brother.", "Write the English word for this Spanish meaning: \nTío"},
            {"thank", "Complete the sentence with the correct English word:\nDon’t forget to ___ your teacher.", "Read the definition and write the correct English word:\nTo express gratitude.", "Write the English word for this Spanish meaning: \nAgradecer"}
    };

    public static void main(String[] args) {
        /*Bienvenida*/
        char simbolo = (char) 42;
        System.out.println("\n");
        System.out.println("         ////////////////////////////////////////////////////////////////////");
        System.out.println("         //██╗     ██╗███╗   ██╗ ██████╗  ██████╗ ██╗  ██╗   ██╗███╗   ██╗ //");
        System.out.println("         //██║     ██║████╗  ██║██╔════╝ ██╔═══██╗██║  ╚██╗ ██╔╝████╗  ██║ //");
        System.out.println("         //██║     ██║██╔██╗ ██║██║  ███╗██║   ██║██║   ╚████╔╝ ██╔██╗ ██║ //");
        System.out.println("         //██║     ██║██║╚██╗██║██║   ██║██║   ██║██║    ╚██╔╝  ██║╚██╗██║ //");
        System.out.println("         //███████╗██║██║ ╚████║╚██████╔╝╚██████╔╝███████╗██║   ██║ ╚████║ //");
        System.out.println("         //╚══════╝╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═══╝ //");
        System.out.println("         ////////////////////////////////////////////////////////////////////");
        System.out.println("           =::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "           =::::::::::::::::+@#+:::::::::::::::::::::::+@-=:::::::::::::::::\n" +
                "           =:::::::::::::::::+%-::::::::::::::::::::::::@=::::::::::::::::::\n" +
                "           =:::::::::::::::::::+-::::::::::::::::::::::*::::::::::::::::::::\n" +
                "           =::::::::::::::::::::+:::::::::::::::::::::+-::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::#-::::::::::::::::::#-:::::::::::::::::::::\n" +
                "           =::::::::::::::::::::::+-::::::::::::::::#:::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::::+-::::::::::::::+-:::::::::::::::::::::::\n" +
                "           =::::::::::::::::::::::::*--=#%%%%%#+-:#:::::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::::+#=......::....-*+:::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::*@-::::::::::::::::.=#:::::::::::::::::::::\n" +
                "           =:::::::::::::::::::-#-:::::::::::::::::...:#-:::::::::::::::::::\n" +
                "           =:::::::::-+  :#=::=%-:::::::::::::::::::. ..%=::-#+-+=::::::::::\n" +
                "           =:::::::::*     -%%-:::=+-::::::::::::=-:. .:%#=     +-:::::::::\n" +
                "           =:::::::::=.    .=.#=:::*@#+*:::::::::-@@+%:..:-+ .   +-:::::::::\n" +
                "           =:::::::::-=    +%+::::+@@@+::=-::=::-@@@@:::::#.*.   #::::::::::\n" +
                "           =::::::::::+. :=+%=::::::::::::===:::::--::::::*+:+. :=::::::::::\n" +
                "           =:::::::::::#    #-::::::::::::::::::::::::::::+-    *:::::::::::\n" +
                "           =::::::::::::+:  #-::::::::::::::::::::::::::::+-   #::::::::::::\n" +
                "           =:::::::::::::+ -#-::::::::::::::::::::::::::::#: .*:::::::::::::\n" +
                "           =:::::::::::::::@@@#+-::::::::::::::::::::::-=%@ -+::::::::::::::\n" +
                "           =::::::::::::::::#@@@@@@@%*=----------=+#@@@@@@@#::::::::::::::::\n" +
                "           =::::::::::::::::=%%@@@@@@@@@@@@@@@@@@@@@@@@@@@#:::::::::::::::::\n" +
                "           =:::::::::::::::=%@+---+*%@@@@@@@@@@@@@@@#*===@@*::::::::::::::::\n" +
                "           =:::::::::::::::%:-@@@@=-------------------=%@#:@%-::::::::::::::\n" +
                "           =::::::::::::::::::-@@@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::\n" +
                "           =:::::::::::::::::::-@*@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::@#+==----====------=#%:::::::::::::::::::::\n" +
                "           =::::::::::::::::::::::-@@@@@@@@@@@@@@@@@@=::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::::::@@@@@@@@@@@@@@=::::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::::::::-*@@@@@@*=:::::::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::::::::::#+:-@-:::::::::::::::::::::::::::::\n" +
                "           =:::::::::::::::::::::::::::::#+:-@-:::::::::::::::::::::::::::::\n" +
                "           =::::::::::::::::::::::::::#@@@=:-@@@@-::::::::::::::::::::::::::\n");
        System.out.println("        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "       ~░█▀▄░▀█▀░█▀▀░█▀█░█░█░█▀▀░█▀█░▀█▀░█▀▄░▄▀▄░░░█▀█░░░█░░░▀█▀░█▀█░█▀▀░█▀█░█░░░█░█░█▀█~\n" +
                "       ~░█▀▄░░█░░█▀▀░█░█░▀▄▀░█▀▀░█░█░░█░░█░█░█▀▀░░░█▀█░░░█░░░░█░░█░█░█░█░█░█░█░░░░█░░█░█~\n" +
                "       ~░▀▀░░▀▀▀░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀░▀▀▀░▀▀░░░▀░░░░▀░▀░░░▀▀▀░▀▀▀░▀░▀░▀▀▀░▀▀▀░▀▀▀░░▀░░▀░▀~\n" +
                "       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n");
        registro();
        moduloGeneral();
    }

    public static void registro() {
        System.out.println("            Por favor, ingresa tu nombre (como quieres que te llamemos)");
        usuario = sc.nextLine();
    }

    public static void moduloGeneral() {
        /*Preguntar que desea practicar*/
        int opcionprincipal;
        System.out.println("         +================================================================+");
        System.out.println("         ||       Hola  " + usuario + ", ¿Qué modo deseas practicar?                   ||");
        System.out.print("         ||       1.Spelling Bee (deletreo)                              ||\n " +  "        ||       2.Vocabulario (ampliar palabras)                      ||");
        System.out.println("\n         +================================================================+");
        System.out.println("\n\n          Elige 1 o 2:");
        /*leer que desea practicar*/
        do {
            if (sc.hasNextInt()) {
                opcionprincipal = sc.nextInt();
            } else {
                opcionprincipal = 0;
            }

            switch (opcionprincipal) {
                case 1:
                    nivel = "el nivel";
                    System.out.println(usuario + ", elegiste:\n");
                    String art =
                            "          ··············································································\n" +
                                    "          : #####                                                 ######               :\n" +
                                    "          :#     # #####  ###### #      #      # #    #  ####     #     # ###### ######:\n" +
                                    "          :#       #    # #      #      #      # ##   # #    #    #     # #      #     :\n" +
                                    "          : #####  #    # #####  #      #      # # #  # #         ######  #####  ##### :\n" +
                                    "          :      # #####  #      #      #      # #  # # #  ###    #     # #      #     :\n" +
                                    "          :#     # #      #      #      #      # #   ## #    #    #     # #      #     :\n" +
                                    "          : #####  #      ###### ###### ###### # #    #  ####     ######  ###### ######:\n" +
                                    "          ··············································································";
                    System.out.println(art);
                    System.out.println("\n");

                    /*DECLARACION DE NIVELES SPELLING BEE (CONVERTIDOS A MAYÚSCULAS)*/
                    String[] nsbBasico = {"ADD", "EYE", "EAR", "BOAT", "HAPPY", "LION", "NIGHT", "MILK", "UNCLE", "THANK"};
                    String[] nsbMedio = {"CHEF", "BRUSH", "SISTER", "DESERT", "KITCHEN", "MONDAY", "BREAKFAST", "HORSE", "QUITE", "LISTEN"};
                    String[] nsbNormal = {"INTELLIGENT", "INCREDIBLE", "CLASSMATE", "CELEBRATION", "SCISSORS", "TELEVISION", "KILOMETER", "DIAGRAM", "JANUARY", "MEXICAN"};
                    String[] nsbDificil = {"DISAPPEAR", "APOLOGIZE", "APPRECIATE", "IMMEDIATELY", "KNOCK", "LICENSE", "WEIGH", "RHYME", "MULTIMEDIA", "MYSTERIOUS"};
                    String[] nsbExpert = {"EMBARRASS", "PUNCTURE", "SUSTAINABLE", "ACKNOWLEDGE", "WRIGGLE", "GREASE", "HARASS", "DECEIVE", "GUARANTEE"};

                    int nivelSpellingBee;

                    System.out.println("            Ingresa el nivel que deseas cursar (recuerda que se dara por hecho que ya has cursado los niveles anteriores a el):");
                    System.out.println("            1- Básico\n            2- Medio\n            3- Normal\n            4- Difícil\n            5- Expert");

                    do {
                        nivelSpellingBee = sc.nextInt();
                        switch (nivelSpellingBee) {
                            case 1:
                                nnombre = "Básico";
                                PALABRAS_JUEGO = nsbBasico;
                                break;
                            case 2:
                                nnombre = "Medio";
                                PALABRAS_JUEGO = nsbMedio;
                                break;
                            case 3:
                                nnombre = "Normal";
                                PALABRAS_JUEGO = nsbNormal;
                                break;
                            case 4:
                                nnombre = "Difícil";
                                PALABRAS_JUEGO = nsbDificil;
                                break;
                            case 5:
                                nnombre = "Experto";
                                PALABRAS_JUEGO = nsbExpert;
                                break;
                            default:
                                System.out.print("              Opción invalida. Ese número no corresponde a ningún nivel. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (nivelSpellingBee < 1 || nivelSpellingBee > 5);

                    /*Preguntar modalidad Spelling Bee */
                    System.out.println("\n\n");
                    System.out.println("         +================================================================+");
                    System.out.println("         ||       Ahora elige la modalidad                                ||");
                    System.out.println("         ||       1. Modalidad Tradicional                                ||");
                    System.out.println("         ||       2. Modalidad Retos y Juegos                             ||");
                    System.out.println("         +================================================================+");
                    System.out.print("\n\n          Ingresa 1 o 2: ");
                    int modalidadSpellingBee;
                    /*leer modalidad Spelling Bee*/
                    do {
                        if (sc.hasNextInt()) {
                            modalidadSpellingBee = sc.nextInt();
                        } else {
                            sc.next();
                            modalidadSpellingBee = 0;
                        }
                        switch (modalidadSpellingBee) {
                            case 1:
                                allnombre = "Spelling Bee Modalidad Tradicional";
                                modalidadTradicionalSpellingBee();
                                break;
                            case 2:
                                modalidadRetosyJuegosSpellingBee();
                                break;
                            default:
                                System.out.print("          Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (modalidadSpellingBee != 1 && modalidadSpellingBee != 2);
                    break;

                case 2:
                    nivel = "la categoría gramatical";
                        /*Preguntar modalidad Vocabulario*/
                        System.out.println(usuario + ", elegiste:\n ");
                        String art2 =
                                "           /==========================================================\\\n" +
                                        "           ||__     __              _           _            _       ||\n" +
                                        "           ||\\ \\   / /__   ___ __ _| |__  _   _| | __ _ _ __(_) ___  ||\n" +
                                        "           || \\ \\ / / _ \\ / __/ _` | '_ \\| | | | |/ _` | '__| |/ _ \\ ||\n" +
                                        "           ||  \\ V / (_) | (_| (_| | |_) | |_| | | (_| | |  | | (_) |||\n" +
                                        "           ||   \\_/ \\___/ \\___\\__,_|_.__/ \\__,_|_|\\__,_|_|  |_|\\___/ ||\n" +
                                        "           \\==========================================================/\n";
                        System.out.println(art2);
                        System.out.println("\n");
                       /*DECLARACION DE NIVELES VOCABULARIO*/
                        String [][] nvVerboregulares = {
                                        {"play","Complete the sentence with the correct English word:\nWould you ____ chess with me after the soccer training","Read the definition and write the correct English word:\nTo engage in a game or sport for fun or competition","Write the English word for this Spanish meaning:\nJugar"},
                                        {"work","Complete the sentence with the correct English word:\nHow can you ____ for long hours without coffee","Read the definition and write the correct English word:\nTo perform tasks or duties, usually for money or effort","Write the English word for this Spanish meaning:\nTrabajar"},
                                        {"talk","Complete the sentence with the correct English word:\nNow that we don´t ____ on instagram, i feel better","Read the definition and write the correct English word:\nTo communicate with someone using words","Write the English word for this Spanish meaning:\nHablar"},
                                        {"watch","Complete the sentence with the correct English word:\nIf i was you, i will don´t want to _____ that movie, it´s so sad", "Read the definition and write the correct English word:\nTo look at something attentively, especially a movie or TV show.","Write the English word for this Spanish meaning:\nMirar"},
                                        {"clean","Complete the sentence with the correct English word:\nOh wow, you have to _____ really well, this place is so spotless", "Read the definition and write the correct English word:\nTo make a place free from dirt or mess.","Write the English word for this Spanish meaning:\nLimpiar"},
                                        {"open","Complete the sentence with the correct English word:\nCan you ____ the windows, i´ts getting hot in here", "Read the definition and write the correct English word:\nTo move something so that it is no longer closed.","Write the English word for this Spanish meaning:\nAbrir"},
                                        {"help","Complete the sentence with the correct English word:\nI need some ____, this shopping bags are too heavy", "Read the definition and write the correct English word:\nTo give assistance to someone in need.","Write the English word for this Spanish meaning:\nAyudar"},
                                        {"start","Complete the sentence with the correct English word:\nAre you ready to _____, the time is ending", "Read the definition and write the correct English word:\nTo begin an activity or action.","Write the English word for this Spanish meaning:\nEmpezar"},
                                        {"call","Complete the sentence with the correct English word:\nMy party has been updated. ____ me to know the new information","Read the definition and write the correct English word:\nTo contact someone by phone.","Write the English word for this Spanish meaning:\nLlamar"},
                                        {"live","Complete the sentence with the correct English word:\nI don´t wanna ____ forever, because I know I´ll be living in vain", "Read the definition and write the correct English word:\nTo exist in a particular place or time.","Write the English word for this Spanish meaning:\nVivir"}
                        };
                        String[][] nvVerbosirregulares = {
                                {"go","Complete the sentence with the correct English word:\nI want to ____ to the park this afternoon.","Read the definition and write the correct English word:\nTo move from one place to another.","Write the English word for this Spanish meaning:\nIr"},
                                {"eat","Complete the sentence with the correct English word:\nLet’s ____ pizza for dinner tonight.","Read the definition and write the correct English word:\nTo put food into the mouth, chew, and swallow.","Write the English word for this Spanish meaning:\nComer"},
                                {"see","Complete the sentence with the correct English word:\nDid you ____ that amazing rainbow yesterday?","Read the definition and write the correct English word:\nTo notice or perceive with the eyes.","Write the English word for this Spanish meaning:\nVer"},
                                {"take","Complete the sentence with the correct English word:\nCan you ____ this book back to the library?","Read the definition and write the correct English word:\nTo get into one’s possession; to carry or bring.","Write the English word for this Spanish meaning:\nTomar"},
                                {"come","Complete the sentence with the correct English word:\nPlease ____ to my house tomorrow for lunch.","Read the definition and write the correct English word:\nTo move toward or arrive at a place.","Write the English word for this Spanish meaning:\nCome"},
                                {"drink","Complete the sentence with the correct English word:\nI need to ____ some water after running.","Read the definition and write the correct English word:\nTo swallow liquid.","Write the English word for this Spanish meaning:\nBeber"},
                                {"write","Complete the sentence with the correct English word:\nShe wants to ____ a letter to her friend.","Read the definition and write the correct English word:\nTo form words on paper or screen with a pen or keyboard.","Write the English word for this Spanish meaning:\nEscribir"},
                                {"begin","Complete the sentence with the correct English word:\nThe class will ____ at nine o’clock sharp.","Read the definition and write the correct English word:\nTo start or commence something.","Write the English word for this Spanish meaning:\nComenzar"},
                                {"run","Complete the sentence with the correct English word:\nHe likes to ____ every morning before breakfast.","Read the definition and write the correct English word:\nTo move quickly with your legs.","Write the English word for this Spanish meaning:\nCorrer"},
                                {"break","Complete the sentence with the correct English word:\nBe careful not to ____ that glass, it’s fragile.","Read the definition and write the correct English word:\nTo separate into pieces by force.","Write the English word for this Spanish meaning:\nRomper"},
                        };
                        String[][] nvSustantivo = {
                                {"career","Complete the sentence with the correct English word:\nShe built a successful ____ in medicine.","Read the definition and write the correct English word:\nA profession or occupation pursued for a significant period of life.","Write the English word for this Spanish meaning:\nCarrera"},
                                {"skill","Complete the sentence with the correct English word:\nGood communication is an important ____.","Read the definition and write the correct English word:\nThe ability to do something well, usually gained through training or practice.","Write the English word for this Spanish meaning:\nHabilidad"},
                                {"knowledge","Complete the sentence with the correct English word:\nHis ____ of history is impressive.","Read the definition and write the correct English word:\nInformation, understanding, or awareness gained through learning or experience.","Write the English word for this Spanish meaning:\nConocimiento"},
                                {"solution","Complete the sentence with the correct English word:\nWe need a ____ to fix this problem.","Read the definition and write the correct English word:\nAn answer or way to resolve a difficulty.","Write the English word for this Spanish meaning:\nSolución"},
                                {"environment","Complete the sentence with the correct English word:\nProtecting the ____ is everyone’s responsibility.","Read the definition and write the correct English word:\nThe surroundings or conditions in which people, animals, or plants live.","Write the English word for this Spanish meaning:\nAmbiente"},
                                {"experience","Complete the sentence with the correct English word:\nShe has five years of ____ in teaching.","Read the definition and write the correct English word:\nPractical contact with and observation of facts or events.","Write the English word for this Spanish meaning:\nExperencia"},
                                {"luggage","Complete the sentence with the correct English word:\nDon’t forget your ____ at the airport.","Read the definition and write the correct English word:\nBags and suitcases used for traveling.","Write the English word for this Spanish meaning:\nEquipaje"},
                                {"customer","Complete the sentence with the correct English word:\nThe shop assistant helped the ____.","Read the definition and write the correct English word:\nA person who buys goods or services.","Write the English word for this Spanish meaning:\nCliente"},
                                {"opinion","Complete the sentence with the correct English word:\nIn my ____, this book is excellent.","Read the definition and write the correct English word:\nA personal view, belief, or judgment.","Write the English word for this Spanish meaning:\nOpinión"},
                                {"traffic","Complete the sentence with the correct English word:\nWe were late because of heavy ____.","Read the definition and write the correct English word:\nThe movement of vehicles on roads.","Write the English word for this Spanish meaning:\nTráfico"},
                        };
                        String[][] nvPreposiciones = {{"across"}, {"against"}, {"through"}, {"except for"}, {"towards"}, {"unlike"}, {"in spite of"}, {"by"}, {"during"}, {"untill"}};
                        String[][] nvAdjetivos = {{"crowded"}, {"comfortable"}, {"polite"}, {"rude"}, {"easy"}, {"available"}, {"necessary"}, {"successful"}, {"tired"}, {"exciting"}};
                        String[][] nvExpresionescomunes = {{"I suppose so"}, {"hold on a minute"}, {"never mind"}, {"to be honest"}, {"looking forward to"}, {"how about"}, {"by the way"}, {"at least"}, {"as far as I know"}, {"it's up to you"}};
                        int nivelVocabulario;
                    System.out.println("            Ingresa la categoría gramatical que deseas estudiar (recuerda que se dara por hecho que ya has cursado las categorías gramaticales anterirores a ella):");
                    System.out.println("            1.Verbo\n" + "            2.Sustantivo\n" + "            3.Preposiciones\n" + "            4.Adjetivos\n" + "            5.Expresiones comunes");

                    do {
                        if (sc.hasNextInt()) {
                            nivelVocabulario = sc.nextInt();
                        } else {
                            sc.next();
                            nivelVocabulario = 0;
                        }
                        switch (nivelVocabulario) {
                            case 1:
                                nnombre = "Verbo";
                                int formadeverbo;
                                System.out.println("Selecciona la forma de verbo que deseas estudiar");
                                System.out.println("1.Verbos Regulares\n" + "2.Verbos Irregulares");
                                do {
                                    if (sc.hasNextInt()) {
                                        formadeverbo = sc.nextInt();
                                    } else {
                                        sc.next();
                                        formadeverbo = 0;
                                    }
                                    switch (formadeverbo) {
                                        case 1:
                                            System.out.println("Has elegido verbos regulares");

                                            break;
                                        case 2:
                                            System.out.println("Has elegido verbos irregulares");

                                            break;
                                        default:
                                            System.out.print("Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
                                            break;
                                    }
                                }while (formadeverbo < 1 || formadeverbo > 2);
                                break;
                            case 2:
                                nnombre = "Sustantivo";

                                break;

                            case 3:
                                nnombre = "Preposiciones";

                                break;

                            case 4:
                                nnombre = "Adjetivos";

                                break;

                            case 5:
                                nnombre = "Expresiones comunes";

                                break;

                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ninguna categoría gramatical. Intenta de nuevo: ");
                                break;

                        }
                    }
                    while (nivelVocabulario < 1 || nivelVocabulario > 5);
                    break;
                default:
                    System.out.print("Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
            }
        }
        while (opcionprincipal != 1 && opcionprincipal != 2);
    }

    private static void modalidadTradicionalojuegos() {

        System.out.println("         +=========================================================+");
        System.out.println("         ||       Ahora elige la modalidad                         ||");
        System.out.println("         ||       1. Modalidad Tradicional                         ||");
        System.out.println("         ||       2. Modalidad Juegos                              ||");
        System.out.println("         +=========================================================+");
        System.out.print("\n\n          Ingresa 1 o 2: ");
        int modalidadVocabulario;
        do {
            if (sc.hasNextInt()) {
                modalidadVocabulario = sc.nextInt();
            } else {
                sc.next();
                modalidadVocabulario = 0;
            }
            switch (modalidadVocabulario) {
                case 1:
                    allnombre = "Vocabulario Modalidad Tradicional";
                    modalidadTradicionalVocabulario();
                    break;
                case 2:
                    modalidadJuegosVocabulario();
                    break;
                default:
                    System.out.print("Opción invalida, Esa opción no corresponde a ninguna modalidad. Intenta de nuevo: ");
                    break;
            }
        }
        while (modalidadVocabulario != 1 && modalidadVocabulario != 2);
    }

    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

    public static void contador() {
        pause(4000);
        System.out.println("¿Estás list@?...");
        sc.nextLine();
        System.out.println("Mucha Suerte!!");
        pause(800);
        System.out.println("Ronda Inicia en...");
        pause(1200);
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            pause(1200);
        }
        System.out.println("Inicia!!");
    }

    public static void bienvenida() {
        pause(800);
        System.out.println("Cargando instrucciones...");
        pause(1500);
        System.out.println("¡Bienvenid@ " + usuario + " :D!\nA continuación iniciará la ronda de " + allnombre + ", en " + nivel + " " + nnombre);
        System.out.println("Instrucciones:");
    }

    public static void modalidadTradicionalSpellingBee() {
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;

        bienvenida();
        System.out.println("1- Se te mostrará la traducción, la definición en inglés de una palabra, o una oración con un espacio en blanco donde falta la palabra.\n2- Escribe la palabra en inglés correcta que corresponda a lo que se muestra.\n 3- Cada intento recibirá retroalimentación inmediata para saber si acertaste o no.\n4- Al terminar la ronda, verás un resumen con tus aciertos y errores para evaluar tu desempeño.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int)(Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = nsbBasico[i][pista + 1];
            System.out.println("Pregunta " + (i+1) + ":");
            System.out.println(nsbBasico[i][pista+1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = nsbBasico[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();// pausa hasta que el usuario presione Enter
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n--- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {
                int indicePalabra = palabrasFalladas[f];


                int pista2;
                do {
                    pista2 = (int)(Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = nsbBasico[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = nsbBasico[indicePalabra][0].toLowerCase();

                if (respuesta2.equals(correcta2)) {
                    System.out.println("✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                    errores++;
                }

                System.out.println("Presiona ENTER para continuar...");
                sc.nextLine();
            }
        }

        // RESUMEN FINAL
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Errores: " + errores);
        if (contadorFallos > 0) {
            System.out.print("Palabras que preguntamos otra vez: ");
            for (int i = 0; i < contadorFallos; i++) {
                System.out.print(nsbBasico[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
                return;
            }
        }


    }

    public static void modalidadRetosyJuegosSpellingBee() {
        System.out.println("Has elegido la Modalidad Retos y Juegos, en el nivel " + nnombre);
        System.out.println("¿Deseas cursar 1- Retos o 2-Juegos?");
        int sbRetoJuego;
        do {
            if (sc.hasNextInt()) {
                sbRetoJuego = sc.nextInt();
            } else {
                sc.next();
                sbRetoJuego = 0;
            }
            switch (sbRetoJuego) {
                case 1:
                    System.out.println("¡Excelente decisión! Ahora porfavor ingresa el numero de reto que te gustaría jugar\n1- Deletreo Rápido\n2- Desafío de Precisión");
                    int sbReto;
                    do {
                        if (sc.hasNextInt()) {
                            sbReto = sc.nextInt();
                        } else {
                            sc.next();
                            sbReto = 0;
                        }
                        switch (sbReto) {
                            case 1:
                                allnombre = "reto Deletreo Rápido";
                                sbrDeletreoRapido();
                                break;
                            case 2:
                                allnombre = "reto Desafio de Precisión";
                                sbrDesafioPrecision();
                                break;
                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ningun reto. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (sbReto < 1 || sbReto > 3);
                    break;
                case 2:
                    System.out.println("¡Excelente decisión! Ahora porfavor ingresa el numero de juego que te gustaría jugar\n1- Ahorcado\n2- Completar letras faltantes\n3- Ordenar letras");
                    int sbJuego;
                    do {
                        if (sc.hasNextInt()) {
                            sbJuego = sc.nextInt();
                        } else {
                            sc.next();
                            sbJuego = 0;
                        }
                        switch (sbJuego) {
                            case 1:
                                allnombre = "juego Ahorcado";
                                sbjAhorcado();
                                break;
                            case 2:
                                allnombre = "juego Completar Letras Faltantes";
                                sbjCompletarLetrasFaltantes();
                                break;
                            case 3:
                                allnombre = "juego Ordenar Letras";
                                sbjOrdenarLetras();
                                break;
                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ningun juego. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (sbJuego < 1 || sbJuego > 3);
                    break;
                default:
                    System.out.print("Opción invalida. Ese número no corresponde a ninguna opcion. Intenta de nuevo: ");
                    break;
            }
        }
        while (sbRetoJuego != 1 && sbRetoJuego != 2);
    }

    public static void sbrDeletreoRapido() {
        bienvenida();
        System.out.println("En este reto deberás:\n-Escribir la mayor cantidad de palabras correctamente en 3 minutos.\n-Escribir cada palabra en inglés a partir de su traducción al español, de manera consecutiva, antes de pasar a la siguiente. \n-Al terminar el tiempo, revisar un resumen de resultados que muestra tus aciertos, errores y palabras falladas.");
        contador();
    }

    public static void sbrDesafioPrecision() {
        bienvenida();
        System.out.println("En este reto deberás:\n-Deletrear la mayor cantidad de palabras posible, pero solo puedes cometer tres errores.\n-Cuando cometas el tercer error, el reto terminará automáticamente y verás un resumen con tus aciertos y errores.\n-Este reto te ayudará a mejorar tu precisión y concentración mientras escribes.");
        contador();
    }
    public static void sbjAhorcado()
    {
        if (PALABRAS_JUEGO == null || PALABRAS_JUEGO.length == 0) {
            PALABRAS_JUEGO = PALABRAS_BASE;
        }
        contadorIncorrectas = 0;
        letrasIncorrectas = new char[INTENTOS_MAXIMOS];
        String artAhorcado=("/==========================================================================\\\n" +
                "||01000001 01101000 01101111 01110010 01100011 01100001 01100100 01101111 ||\n" +
                "\\==========================================================================/");
        System.out.print(artAhorcado);
        System.out.println(" ");
        bienvenida();
        System.out.println("En este juego deberás:\n"+ "1. Adivinar la palabra letra por letra, completándola antes de que se terminen tus intentos.\n" + "2. Cada letra correcta se mostrará en su posición correspondiente, mientras que los errores se contabilizan.\n" + "3. Recibirás retroalimentación inmediata, y si no logras adivinar la palabra, al finalizar se mostrará la palabra completa.");
        contador();
        seleccionarPalabra();
        inicializarPalabraAdivinada();

        while (!juegoTerminado()) {
            mostrarEstadoDelJuego();
            mostrarMuñeco();
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce una letra: ");
            String input = sc.nextLine().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Entrada inválida. Por favor, introduce una sola letra.");
                continue;
            }
            char letra = input.charAt(0);

            if (yaSeIntento(letra)) {
                System.out.println("Ya intentaste la letra '" + letra + "'. Intenta con otra.");
                continue;
            }

            if (!adivinarLetra(letra)) {
                System.out.println("Letra incorrecta!");
                letrasIncorrectas[contadorIncorrectas] = letra;
                contadorIncorrectas++;
            } else {
                System.out.println("Letra correcta!");
            }
        }

        mostrarEstadoDelJuego();
        mostrarMuñeco();
        if (palabraCompletada()) {
            System.out.println("¡Ganaste! La palabra era: " + palabraSecreta);
            ganaste();
        } else {
            System.out.println("¡Perdiste! El ahorcado se completó. La palabra era: " + palabraSecreta);
            perdiste();
        }
    }
    private static void seleccionarPalabra() {
        int indiceAleatorio = (int) (Math.random() * PALABRAS_JUEGO.length);
        palabraSecreta = PALABRAS_JUEGO[indiceAleatorio];
    }

    private static void inicializarPalabraAdivinada() {
        palabraAdivinada = new char[palabraSecreta.length()];
        Arrays.fill(palabraAdivinada, '_');
    }

    private static boolean yaSeIntento(char letra) {
        for (char c : palabraAdivinada) {
            if (c == letra) return true;
        }
        for (int i = 0; i < contadorIncorrectas; i++) {
            if (letrasIncorrectas[i] == letra) return true;
        }
        return false;
    }

    private static void mostrarEstadoDelJuego() {
        System.out.println("\n--- Estado Actual ---");
        System.out.println("Palabra: " + String.valueOf(palabraAdivinada));
        System.out.println("Intentos fallidos: " + contadorIncorrectas + "/" + INTENTOS_MAXIMOS);
        System.out.print("Letras incorrectas: ");
        for (int i = 0; i < contadorIncorrectas; i++) {
            System.out.print(letrasIncorrectas[i]);
            if (i < contadorIncorrectas - 1) System.out.print(", ");
        }
        System.out.println();
    }

    private static boolean adivinarLetra(char letra) {
        boolean letraAdivinada = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                if (palabraAdivinada[i] == '_') {
                    palabraAdivinada[i] = letra;
                    letraAdivinada = true;
                }
            }
        }
        return letraAdivinada;
    }

    private static boolean juegoTerminado() {
        return palabraCompletada() || contadorIncorrectas >= INTENTOS_MAXIMOS;
    }

    private static boolean palabraCompletada() {
        for (char c : palabraAdivinada) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static void mostrarMuñeco() {
        String[] muñeco = {
                " _______ \n |/      |\n |      \n |      \n |      \n |      \n_|___  ", // 0
                " _______ \n |/      |\n |      O\n |      \n |      \n |      \n_|___  ", // 1
                " _______ \n |/      |\n |      O\n |      | \n |      \n |      \n_|___  ", // 2
                " _______ \n |/      |\n |      O\n |     /|\\\n |      \n |      \n_|___  ", // 3
                " _______ \n |/      |\n |      O\n |     /|\\\n |     / \n |      \n_|___  ", // 4
                " _______ \n |/      |\n |      O\n |     /|\\\n |     / \\\n |      \n_|___  ", // 5 (último error antes de perder)
                " _______ \n |/      |\n |      O\n |     /|\\\n |     / \\\n |      \n_|___  ", // 6 (Estado final de pérdida)
        };
        int indice = Math.min(contadorIncorrectas, INTENTOS_MAXIMOS);
        if (indice < muñeco.length) {
            System.out.println(muñeco[indice]);
        }
    }

    public static void sbjCompletarLetrasFaltantes(){
        bienvenida();
        System.out.println("En este juego deberás:\n1. Completar la palabra escribiendo las letras que faltan en los espacios correspondientes.\n2. Cada intento recibirá retroalimentación inmediata, y se contabilizarán tus aciertos y errores.\n3. Presta atención a la posición de cada letra, ya que solo contará si la colocas en el lugar correcto.");
        contador();
    }

    public static void sbjOrdenarLetras(){
        bienvenida();
        System.out.println("En este juego deberás:\n1. Recibirás una palabra con las letras desordenadas y deberás escribirla en su forma correcta.\n2. Cada intento recibirá retroalimentación inmediata, y se contabilizarán tus aciertos y errores.");
        contador();
    }

    public static void modalidadTradicionalVocabulario(){
            aciertos = 0;
            errores = 0;
            contadorFallos = 0;
            for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
            bienvenida();
            System.out.println("En cada ronda, usted deberá:\n1- Escribir el significado en español de una palabra que se muestre en inglés,\n2- Escribir la palabra en inglés a partir de su significado en español, o\n3- Seleccionar la traducción correcta entre varias opciones.\nAdemás:\nCada palabra incluirá ejemplos contextualizados, como frases o fragmentos de conversación, para ayudarle a comprender y usar correctamente el vocabulario.\nRecibirá retroalimentación inmediata en cada intento, y al finalizar un nivel o categoría, podrá revisar un resumen con sus aciertos y errores.\nLas palabras que no domine serán retomadas automáticamente por el sistema en repaso.");
            contador();

            // PRIMERA RONDA
            for (int i = 0; i < 10; i++) {
                int pista = (int)(Math.random() * 3);
                pistaUsada[i] = pista;

                String prompt = PALABRAS_VOCABULARIO[i][pista + 1];
                System.out.println("Pregunta " + (i+1) + ":");
                System.out.println(PALABRAS_VOCABULARIO[i][pista+1]);
                System.out.print("Tu respuesta: ");
                String respuesta = sc.nextLine().trim();

                String correcta = PALABRAS_VOCABULARIO[i][0].trim();

                if (respuesta.equalsIgnoreCase(correcta)) {
                    System.out.println("\n✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                    errores++;
                    palabrasFalladas[contadorFallos++] = i;
                }

                System.out.println("Presiona ENTER para continuar...");
                sc.nextLine();// pausa hasta que el usuario presione Enter
            }

            // SEGUNDA RONDA
            if (contadorFallos > 0) {
                System.out.println("\n--- Ronda de repaso para palabras falladas ---");
                for (int f = 0; f < contadorFallos; f++) {
                    int indicePalabra = palabrasFalladas[f];


                    int pista2;
                    do {
                        pista2 = (int)(Math.random() * 3);
                    } while (pista2 == pistaUsada[indicePalabra]);

                    String prompt2 = PALABRAS_VOCABULARIO[indicePalabra][pista2 + 1];
                    System.out.println("\nRepetición palabra " + (f + 1) + ":");
                    System.out.println(prompt2);

                    System.out.print("Tu respuesta: ");
                    String respuesta2 = sc.nextLine().trim().toLowerCase();

                    String correcta2 =PALABRAS_VOCABULARIO[indicePalabra][0].toLowerCase();

                    if (respuesta2.equals(correcta2)) {
                        System.out.println("✔ Correcto!");
                        aciertos++;
                    } else {
                        System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                        errores++;
                    }

                    System.out.println("Presiona ENTER para continuar...");
                    sc.nextLine();
                }
            }

            // RESUMEN FINAL
            System.out.println("\n--- RESULTADOS FINALES ---");
            System.out.println("Aciertos: " + aciertos);
            System.out.println("Errores: " + errores);
            if (contadorFallos > 0) {
                System.out.print("Palabras que preguntamos otra vez: ");
                for (int i = 0; i < contadorFallos; i++) {
                    System.out.print(PALABRAS_VOCABULARIO[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
                    return;
                }
            }



        }

    public static void modalidadJuegosVocabulario() {
        System.out.println("Has elegido la Modalidad Juegos, en el nivel " + nnombre);
        int vjuego;
        System.out.println("Ingresa el juego que te gustaría jugar\n1- Palabras relacionadas\n2- Completar oraciones\n3- Adivinar la palabra");
        do{
            if (sc.hasNextInt()) {
                vjuego = sc.nextInt();
            } else {
                sc.next();
                vjuego = 0;
            }
            switch (vjuego){
                case 1:
                    allnombre = "juego Palabras Relacionadas";
                    vjPalabrasRelacionadas();
                    break;
                case 2:
                    allnombre = "juego Completar Oraciones";
                    vjCompletarOraciones();
                    break;
                case 3:
                    allnombre = "juego Adivinar Palabras";
                    vjAdiviniarPalabras();
                    break;
                default:
                    System.out.print("Opción invalida. Ese número no corresponde a ningun juego. Intenta de nuevo: ");
                    break;
            }
        }
        while(vjuego<1 || vjuego>3);
    }

    public static void vjPalabrasRelacionadas(){
        bienvenida();
        System.out.println("En este juego deberás:\n1. Escribir el sinónimo o antónimo en inglés de la palabra que se te presente, según indique el ejercicio.\n2. La respuesta correcta debe ser una palabra que ya hayas aprendido previamente en el submódulo de vocabulario, modalidad tradicional.\n3. Cada intento recibirá retroalimentación inmediata, indicándote si acertaste o no.\n4. Al finalizar el juego, verás un resumen de resultados con tus aciertos y errores, para identificar qué palabras necesitas repasar.");
        contador();
    }

    public static void vjCompletarOraciones(){
        bienvenida();
        System.out.println("En este juego deberás:\n1. Completar oraciones incompletas en inglés escribiendo la palabra correcta en los espacios, usando el vocabulario que ya has aprendido.\n2. El sistema validará tu respuesta en tiempo real, indicándote si es correcta o incorrecta.\n3. Al finalizar cada ronda, verás un resumen de resultados con tus aciertos y errores, para reforzar las palabras que aún no dominas.");
        contador();
    }


    public static void vjAdiviniarPalabras() {
        bienvenida();
        System.out.println("En este juego deberás:\n1. Adivinar la palabra en inglés que se te presenta escribiéndola correctamente, usando las pistas que recibas.\n2. Cada intento recibirá retroalimentación inmediata, y si fallas, el sistema mostrará la palabra correcta.\n3. Al finalizar la ronda, verás un resumen de resultados con tus aciertos y errores.");
        contador();
    }

    private static void ganaste()
    {
        System.out.println("Que bien");
        String artGanaste=("      .-.         .--''-.\n" +
                "    .'   '.     /'       `.\n" +
                "    '.     '. ,'          |\n" +
                " o    '.o   ,'        _.-'\n" +
                "  \\.--./'. /.:. :._:.'\n" +
                " .'    '._-': ': ': ': ':\n" +
                ":(#) (#) :  ': ': ': ': ':>-\n" +
                " ' ____ .'_.:' :' :' :' :'\n" +
                "  '\\__/'/ | | :' :' :'\n" +
                "        \\  \\ \\\n" +
                "        '  ' '");
        System.out.print(artGanaste);
    }
    private static void perdiste()
    {
        System.out.println("BUena suerte para la proxima");
        String artPerdiste=("      .-.         .--''-.\n" +
                "    .'   '.     /'       `.\n" +
                "    '.     '. ,'          |\n" +
                " o    '.o   ,'        _.-'\n" +
                "  \\.--./'. /.:. :._:.'\n" +
                " .\\   /'._-':#0: ':#0: ':\n" +
                ":(#) (#) :  ':#0: ':#0: ':>#=-\n" +
                " ' ____ .'_.:J0:' :J0:' :'\n" +
                "  'V  V'/ | |\":' :'\":'\n" +
                "        \\  \\ \\\n" +
                "        '  ' '");
        System.out.print(artPerdiste);
    }

}
