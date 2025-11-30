import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Main {
        static Scanner sc = new Scanner(System.in);
        static String usuario;
        static String nnombre;
        static String allnombre;
        static String nivel;
        static int nivelSpellingBee;

        static int aciertos = 0;
        static int errores = 0;
        static int[] palabrasFalladas = new int[10];
        static int contadorFallos = 0;
        static int[] pistaUsada = new int[10];
        static Random random = new Random();



        static final String[] PALABRAS_BASE = {};
        static String[] PALABRAS_JUEGO = PALABRAS_BASE;
        static String[][] PALABRAS_VOCABULARIO;
        static String[][] PALABRAS_RELACIONADAS;
        static String[][] COMPLETAR_ORACIONES;
        static String palabraSecreta;
        static char[] palabraAdivinada;
        static char[] letrasIncorrectas = new char[6];
        static int contadorIncorrectas = 0;
        static final int INTENTOS_MAXIMOS = 6;

    /*DECLARACION DE NIVELES SPELLING BEE PARA MODALIDAD TRACIONAL*/
    static String [][] nsbBasico = { {"add", "Complete the sentence with the correct English word:\nPlease ___ the numbers to get the result.", "Read the definition and write the correct English word:\nTo combine two or more numbers.", "Write the English word for this Spanish meaning:\nAgregar"}, {"eye", "Complete the sentence with the correct English word:\nShe closed one ___.", "Read the definition and write the correct English word:\nThe organ you use to see.", "Write the English word for this Spanish meaning:\nOjo"}, {"ear", "Complete the sentence with the correct English word:\nHe whispered the secret into my ___.", "Read the definition and write the correct English word:\nThe organ you use to hear sounds.", "Write the English word for this Spanish meaning: \nOreja"}, {"boat", "Complete the sentence with the correct English word:\nWe crossed the lake in a small ___.", "Read the definition and write the correct English word:\nA vehicle used to travel on water.", "Write the English word for this Spanish meaning: \nBarco"}, {"happy", "Complete the sentence with the correct English word:\nShe felt very ___ on her birthday.", "Read the definition and write the correct English word:\nFeeling joy or pleasure.", "Write the English word for this Spanish meaning: \nFeliz"}, {"lion", "Complete the sentence with the correct English word:\nThe ___ is known as the king of the jungle.", "Read the definition and write the correct English word:\nA large wild cat with a mane.", "Write the English word for this Spanish meaning: \nLeón"}, {"night", "Complete the sentence with the correct English word:\nI like to read at ___.", "Read the definition and write the correct English word:\nThe time of day when it is dark.", "Write the English word for this Spanish meaning: \nNoche"}, {"milk", "Complete the sentence with the correct English word:\nCould you buy some ___ at the store?", "Read the definition and write the correct English word:\nA white liquid produced by cows.", "Write the English word for this Spanish meaning: \nLeche"}, {"uncle", "Complete the sentence with the correct English word:\nMy ___ visits us every Sunday.", "Read the definition and write the correct English word:\nYour parents’ brother.", "Write the English word for this Spanish meaning: \nTío"}, {"thank", "Complete the sentence with the correct English word:\nDon’t forget to ___ your teacher.", "Read the definition and write the correct English word:\nTo express gratitude.", "Write the English word for this Spanish meaning: \nAgradecer"} };
    static String [][] nsbMedio = { {"chef", "Complete the sentence with the correct English word:\nThe ___ prepared a delicious meal.", "Read the definition and write the correct English word:\nA professional cook.\n", "Write the English word for this Spanish meaning:\nChef / cocinero profesional"}, {"brush", "Complete the sentence with the correct English word:\nRemember to ___ your teeth before bed.", "Read the definition and write the correct English word:\nTo clean using a brush.", "Write the English word for this Spanish meaning:\nCepillar"}, {"sister", "Complete the sentence with the correct English word:\nMy ___ is younger than me.", "Read the definition and write the correct English word:\nA girl who has the same parents as you.", "Write the English word for this Spanish meaning:\nHermana"}, {"desert", "Complete the sentence with the correct English word:\nCamels can live in the ___.", "Read the definition and write the correct English word:\nA dry place with little water.", "Write the English word for this Spanish meaning:\nDesierto"}, {"kitchen", "Complete the sentence with the correct English word:\nDinner is ready in the ___.", "Read the definition and write the correct English word:\nThe room where you cook food.", "Write the English word for this Spanish meaning:\nCocina"}, {"Monday", "Complete the sentence with the correct English word:\nSchool starts again on ___.", "Read the definition and write the correct English word:\nThe first day of the week for many people.", "Write the English word for this Spanish meaning:\nLunes"}, {"breakfast", "Complete the sentence with the correct English word:\nI eat eggs and fruit for ___.", "Read the definition and write the correct English word:\nThe first meal of the day.", "Write the English word for this Spanish meaning:\nDesayuno"}, {"horse", "Complete the sentence with the correct English word:\nShe rides a ___ every weekend.", "Read the definition and write the correct English word:\nA large animal people can ride.", "Write the English word for this Spanish meaning:\nCaballo"}, {"quite", "Complete the sentence with the correct English word:\nThe movie was ___ interesting.", "Read the definition and write the correct English word:\nTo a certain or large degree; fairly.", "Write the English word for this Spanish meaning:\nBastante"}, {"listen", "Complete the sentence with the correct English word:\nlease ___ carefully to the instructions.", "Read the definition and write the correct English word:\nTo pay attention to sound.", "Write the English word for this Spanish meaning:\nEscuchar"} };
    static String [][] nsbNormal = { {"intelligent", "Complete the sentence with the correct English word:\nShe is very ___ and learns fast.", "Read the definition and write the correct English word:\nAble to learn and understand things easily.", "Write the English word for this Spanish meaning:\nInteligente"}, {"incredible", "Complete the sentence with the correct English word:\nThe view from the mountain was ___.", "Read the definition and write the correct English word:\nVery surprising or hard to believe.", "Write the English word for this Spanish meaning:\nIncreíble"}, {"classmate", "Complete the sentence with the correct English word:\nMy ___ helped me with the homework.", "Read the definition and write the correct English word:\nAnother student in your class.", "Write the English word for this Spanish meaning:\nCompañero de clase"}, {"celebration", "Complete the sentence with the correct English word:\nWe had a big ___ for her birthday.", "Read the definition and write the correct English word:\nA joyful event or party.", "Write the English word for this Spanish meaning:\nCelebración"}, {"scissors", "Complete the sentence with the correct English word:\nDon’t run with ___.", "Read the definition and write the correct English word:\nA tool used for cutting paper or fabric.", "Write the English word for this Spanish meaning:\nTijeras"}, {"television", "Complete the sentence with the correct English word:\nTurn on the ___ to watch the news.", "Read the definition and write the correct English word:\nA device that shows moving images and sound.", "Write the English word for this Spanish meaning:\nTelevisión"}, {"kilometer", "Complete the sentence with the correct English word:\nThe school is one ___ away.", "Read the definition and write the correct English word:\nA unit of distance equal to 1,000 meters.", "Write the English word for this Spanish meaning:\nKilómetro"}, {"diagram", "Complete the sentence with the correct English word:\nThe teacher drew a ___ on the board.", "Read the definition and write the correct English word:\nA simple drawing that explains how something works.", "Write the English word for this Spanish meaning:\nDiagrama"}, {"January", "Complete the sentence with the correct English word:\nThe year begins in ___.", "Read the definition and write the correct English word:\nThe first month of the year.", "Write the English word for this Spanish meaning:\nEnero"}, {"Mexican", "Complete the sentence with the correct English word:\nShe is very proud to be ___.", "Read the definition and write the correct English word:\nA person from Mexico.", "Write the English word for this Spanish meaning:\nMexicano / Mexicana"} };
    static String [][] nsbDificil = { {"disappear", "Complete the sentence with the correct English word:\nThe cat seemed to ___ in the dark.", "Read the definition and write the correct English word:\nTo stop being visible.", "Write the English word for this Spanish meaning:\nDesaparecer"}, {"apologize", "Complete the sentence with the correct English word:\nYou should ___ for being late.", "Read the definition and write the correct English word:\nTo say you are sorry.", "Write the English word for this Spanish meaning:\nDisculparse"}, {"appreciate", "Complete the sentence with the correct English word:\nI really ___ your help.", "Read the definition and write the correct English word:\nTo be thankful for something.", "Write the English word for this Spanish meaning:\nApreciar / agradecer"}, {"immediately", "Complete the sentence with the correct English word:\nCome here ___.", "Read the definition and write the correct English word:\nWithout waiting; right away.", "Write the English word for this Spanish meaning:\nInmediatamente"}, {"knock", "Complete the sentence with the correct English word:\nPlease ___ before entering the room.", "Read the definition and write the correct English word:\nTo hit a door to get someone’s attention.", "Write the English word for this Spanish meaning:\nTocar (la puerta)"}, {"license", "Complete the sentence with the correct English word:\nYou need a ___ to drive a car.", "Read the definition and write the correct English word:\nAn official document that gives permission.", "Write the English word for this Spanish meaning:\nLicencia"}, {"weigh", "Complete the sentence with the correct English word:\nHow much do you ___?", "Read the definition and write the correct English word:\nTo measure how heavy something is.", "Write the English word for this Spanish meaning:\nPesar"}, {"rhyme", "Complete the sentence with the correct English word:\n'Cat' and 'hat' ___ with each other.", "Read the definition and write the correct English word:\nWords that end with the same sound.", "Write the English word for this Spanish meaning:\nRima / rimar"}, {"multimedia", "Complete the sentence with the correct English word:\nThe project included a ___ presentation.", "Read the definition and write the correct English word:\nUsing many forms of communication (audio, video, text).", "Write the English word for this Spanish meaning:\nMultimedia"}, {"mysterious", "Complete the sentence with the correct English word:\nThere was a ___ noise outside.", "Read the definition and write the correct English word:\nDifficult to explain or understand.", "Write the English word for this Spanish meaning:\nMisterioso"} };
    static String [][] nsbExpert = { {"embarrass", "Complete the sentence with the correct English word:\nDon’t say things that might ___ him.", "Read the definition and write the correct English word:\nTo make someone feel ashamed or uncomfortable.", "Write the English word for this Spanish meaning:\nAvergonzar"}, {"puncture", "Complete the sentence with the correct English word:\nBe careful not to ___ the tire.", "Read the definition and write the correct English word:\nA small hole made by a sharp object.", "Write the English word for this Spanish meaning:\nPinchar / perforar"}, {"sustainable", "Complete the sentence with the correct English word:\nWe need ___ energy solutions.", "Read the definition and write the correct English word:\nAble to be maintained without harming the environment.", "Write the English word for this Spanish meaning:\nSostenible"}, {"acknowledge", "Complete the sentence with the correct English word:\nPlease ___ that you received the email.", "Read the definition and write the correct English word:\nTo admit or accept that something is true.", "Write the English word for this Spanish meaning:\nReconocer"}, {"wriggle", "Complete the sentence with the correct English word:\nThe worm began to ___ on the ground.", "Read the definition and write the correct English word:\nTo twist and turn with small movements.", "Write the English word for this Spanish meaning:\nRetorcerse"}, {"grease", "Complete the sentence with the correct English word:\nThe pan is covered in ___.", "Read the definition and write the correct English word:\nA fatty or oily substance.", "Write the English word for this Spanish meaning:\nGrasa"}, {"harass", "Complete the sentence with the correct English word:\nIt is illegal to ___ someone at work.", "Read the definition and write the correct English word:\nTo repeatedly bother or disturb someone.", "Write the English word for this Spanish meaning:\nAcosar"}, {"deceive", "Complete the sentence with the correct English word:\nHe tried to ___ his friends with a lie.", "Read the definition and write the correct English word:\nTo make someone believe something that is not true.", "Write the English word for this Spanish meaning:\nEngañar"}, {"guarantee", "Complete the sentence with the correct English word:\nThe product comes with a one-year ___.", "Read the definition and write the correct English word:\nA promise that something will work or last.", "Write the English word for this Spanish meaning:\nGarantía"}, {"resilient", "Complete the sentence with the correct English word:\nChildren are often very ___ after facing challenges.", "Read the definition and write the correct English word:\nAble to recover quickly from difficulties; strong and adaptable.", "Write the English word for this Spanish meaning:\nResiliente"} };


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
            opcionprincipal = sc.nextInt();
            switch (opcionprincipal) {
                case 1:
                    nivel="el nivel";
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
                        modalidadSpellingBee = sc.nextInt();
                        switch (modalidadSpellingBee) {
                            case 1:
                                allnombre = "Spelling Bee Modalidad Tradicional";
                                modalidadTradicionalSpellingBee();
                                break;
                            case 2:
                                modalidadRetosyJuegosSpellingBee();
                                break;
                            default:
                                System.out.print("           Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
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
                        String[][] nvPreposiciones = {
                                {"above","Complete the sentence with the correct English word:\nThe picture is hanging ____ the fireplace.","Read the definition and write the correct English word:\nAt a higher level or position.","Write the English word for this Spanish meaning:\nEncima de"},
                                {"below","Complete the sentence with the correct English word:\nThe valley lies ____ the mountains.","Read the definition and write the correct English word:\nAt a lower level or position.","Write the English word for this Spanish meaning:\nDebajo de"},
                                {"between","Complete the sentence with the correct English word:\nThe ball is ____ the two chairs.","Read the definition and write the correct English word:\nIn the middle of two things.","Write the English word for this Spanish meaning:\nEntre"},
                                {"among","Complete the sentence with the correct English word:\nShe was happy to be ____ friends.","Read the definition and write the correct English word:\nSurrounded by, in the company of.","Write the English word for this Spanish meaning:\nEntre"},
                                {"inside","Complete the sentence with the correct English word:\nThe cat is hiding ____ the box.","Read the definition and write the correct English word:\nWithin the interior of something.","Write the English word for this Spanish meaning:\nDentro de"},
                                {"outside","Complete the sentence with the correct English word:\nLet’s wait ____ the house until they arrive.","Read the definition and write the correct English word:\nNot inside; in the open air.","Write the English word for this Spanish meaning:\nFuera de"},
                                {"onto","Complete the sentence with the correct English word:\nHe climbed ____ the roof to fix it.","Read the definition and write the correct English word:\nMoving to a position on top of something.","Write the English word for this Spanish meaning:\nSobre"},
                                {"off","Complete the sentence with the correct English word:\nPlease take your shoes ____ the table.","Read the definition and write the correct English word:\nAway from a place or position.","Write the English word for this Spanish meaning:\nFuera de"},
                                {"around","Complete the sentence with the correct English word:\nThey walked ____ the park together.","Read the definition and write the correct English word:\nIn a circular direction or surrounding.","Write the English word for this Spanish meaning:\nAlrededor de"},
                                {"near","Complete the sentence with the correct English word:\nThe school is ____ the library.","Read the definition and write the correct English word:\nClose to something.","Write the English word for this Spanish meaning:\nCerca de"}
                        };
                        String[][] nvAdjetivos = {
                                {"happy","Complete the sentence with the correct English word:\nShe feels ____ because she passed the exam.","Read the definition and write the correct English word:\nFeeling or showing pleasure.","Write the English word for this Spanish meaning:\nFeliz"},
                                {"sad","Complete the sentence with the correct English word:\nHe looked ____ after hearing the bad news.","Read the definition and write the correct English word:\nFeeling sorrow or unhappiness.","Write the English word for this Spanish meaning:\nTriste"},
                                {"big","Complete the sentence with the correct English word:\nThat is a very ____ house.","Read the definition and write the correct English word:\nOf large size.","Write the English word for this Spanish meaning:\nGrande"},
                                {"small","Complete the sentence with the correct English word:\nThe puppy is so ____.","Read the definition and write the correct English word:\nOf little size.","Write the English word for this Spanish meaning:\nPequeño"},
                                {"fast","Complete the sentence with the correct English word:\nThe car is really ____.","Read the definition and write the correct English word:\nMoving quickly.","Write the English word for this Spanish meaning:\nRápido"},
                                {"slow","Complete the sentence with the correct English word:\nThe turtle is ____.","Read the definition and write the correct English word:\nNot fast.","Write the English word for this Spanish meaning:\nLento"},
                                {"beautiful","Complete the sentence with the correct English word:\nThe garden looks ____.","Read the definition and write the correct English word:\nPleasing to the senses.","Write the English word for this Spanish meaning:\nHermoso"},
                                {"ugly","Complete the sentence with the correct English word:\nThe painting is ____.","Read the definition and write the correct English word:\nNot attractive.","Write the English word for this Spanish meaning:\nFeo"},
                                {"strong","Complete the sentence with the correct English word:\nShe is ____ enough to lift heavy boxes.","Read the definition and write the correct English word:\nHaving power or force.","Write the English word for this Spanish meaning:\nFuerte"},
                                {"weak","Complete the sentence with the correct English word:\nHe felt ____ after the long illness.","Read the definition and write the correct English word:\nLacking strength.","Write the English word for this Spanish meaning:\nDébil"}
                        };
                       String[][] nvExpresionescomunes = {
                            {"How are you?", "Complete the sentence with the correct English expression:\n____, I’m fine thanks.", "Read the definition and write the correct English expression:\nA common greeting asking about someone’s well-being.", "Write the English expression for this Spanish meaning:\n¿Cómo estás?"},
                            {"What’s up?", "Complete the sentence with the correct English expression:\n____, nothing much.", "Read the definition and write the correct English expression:\nAn informal way to ask what is happening.", "Write the English expression for this Spanish meaning:\n¿Qué tal?"},
                            {"Long time no see", "Complete the sentence with the correct English expression:\n____, I missed you!", "Read the definition and write the correct English expression:\nUsed when you meet someone after a long period.", "Write the English expression for this Spanish meaning:\n¡Cuánto tiempo sin verte!"},
                            {"Take care", "Complete the sentence with the correct English expression:\nGoodbye and ____.", "Read the definition and write the correct English expression:\nA phrase used to wish safety and well-being.", "Write the English expression for this Spanish meaning:\nCuídate"},
                            {"See you later", "Complete the sentence with the correct English expression:\nBye, ____!", "Read the definition and write the correct English expression:\nA casual way to say farewell until next time.", "Write the English expression for this Spanish meaning:\nNos vemos luego"},
                            {"Nice to meet you", "Complete the sentence with the correct English expression:\nHello, ____.", "Read the definition and write the correct English expression:\nA polite phrase when meeting someone for the first time.", "Write the English expression for this Spanish meaning:\nEncantado de conocerte"},
                            {"Have a good day", "Complete the sentence with the correct English expression:\nBye, ____!", "Read the definition and write the correct English expression:\nA phrase wishing someone a pleasant day.", "Write the English expression for this Spanish meaning:\nQue tengas un buen día"},
                            {"Don’t worry", "Complete the sentence with the correct English expression:\n____, everything will be fine.", "Read the definition and write the correct English expression:\nUsed to reassure someone not to be concerned.", "Write the English expression for this Spanish meaning:\nNo te preocupes"},
                            {"It’s up to you", "Complete the sentence with the correct English expression:\nChoose the movie, ____.", "Read the definition and write the correct English expression:\nMeans the decision depends on the person.", "Write the English expression for this Spanish meaning:\nDepende de ti"},
                            {"By the way", "Complete the sentence with the correct English expression:\n____, did you finish your homework?", "Read the definition and write the correct English expression:\nUsed to introduce a new topic or reminder.", "Write the English expression for this Spanish meaning:\nPor cierto"}
                    };
                    // PALABRAS VOCABULARIO JUEGO PALABRAS RELACIONADAS
                    String[][] sinyantVerbosRegulares = {
                        {"participate",
                                "Complete the sentence with the correct English synonym:\nShe likes to ____ soccer every weekend. (play)",
                                "Choose the synonym of 'play':\n(a) participate, (b) rest, (c) ignore",
                                "Write the synonym of the following word: play"},

                        {"rest",
                                "Complete the sentence with the correct English antonym:\nHe decided to ____ instead of working all day. (work)",
                                "Choose the antonym of 'work':\n(a) rest, (b) labor, (c) job",
                                "Write the synonym of the following word: work"},

                        {"speak",
                                "Complete the sentence with the correct English synonym:\nLet’s ____ about the new movie tonight. (talk)",
                                "Choose the synonym of 'talk':\n(a) speak, (b) run, (c) watch",
                                "Write the synonym of the following word: talk"},

                        {"ignore",
                                "Complete the sentence with the correct English antonym:\nDon’t just watch, try not to ____ what’s happening. (watch)",
                                "Choose the antonym of 'watch':\n(a) ignore, (b) observe, (c) look",
                                "Write the synonym of the following word: watch"},

                        {"tidy",
                                "Complete the sentence with the correct English synonym:\nShe will ____ the kitchen before guests arrive. (clean)",
                                "Choose the synonym of 'clean':\n(a) tidy, (b) dirty, (c) mess",
                                "Write the synonym of the following word: clean"},

                        {"close",
                                "Complete the sentence with the correct English antonym:\nCan you open the window? Don’t ____ it now. (open)",
                                "Choose the antonym of 'open':\n(a) close, (b) unlock, (c) unseal",
                                "Write the synonym of the following word: open"},

                        {"assist",
                                "Complete the sentence with the correct English synonym:\nCould you ____ me with my homework? (help)",
                                "Choose the synonym of 'help':\n(a) assist, (b) ignore, (c) rest",
                                "Write the synonym of the following word: help"},

                        {"finish",
                                "Complete the sentence with the correct English antonym:\nWe will start the meeting at 10 a.m. and ____ it at noon. (start)",
                                "Choose the antonym of 'start':\n(a) finish, (b) begin, (c) commence",
                                "Write the synonym of the following word: start"},

                        {"phone",
                                "Complete the sentence with the correct English synonym:\nI will ____ my friend to invite her to the party. (call)",
                                "Choose the synonym of 'call':\n(a) phone, (b) write, (c) run",
                                "Write the synonym of the following word: call"},

                        {"die",
                                "Complete the sentence with the correct English antonym:\nThey live in a small town, but many people ____ in the city. (live)",
                                "Choose the antonym of 'live':\n(a) die, (b) survive, (c) exist",
                                "Write the synonym of the following word: live"}
                };
                    String[][] sinyantVerbosIrregulares = {
                        {"travel",
                                "Complete the sentence with the correct English synonym:\nThey want to ____ on vacation next month. (go)",
                                "Choose the synonym of 'go':\n(a) travel, (b) stop, (c) stay",
                                "Write the synonym of the following word: go"},

                        {"fast",
                                "Complete the sentence with the correct English antonym:\nInstead of eating, he decided to ____ for the day. (eat)",
                                "Choose the antonym of 'eat':\n(a) fast, (b) consume, (c) devour",
                                "Write the synonym of the following word: eat"},

                        {"notice",
                                "Complete the sentence with the correct English synonym:\nDid you ____ the rainbow yesterday? (see)",
                                "Choose the synonym of 'see':\n(a) notice, (b) hide, (c) ignore",
                                "Write the synonym of the following word: see"},

                        {"give",
                                "Complete the sentence with the correct English antonym:\nDon’t take the gift, try to ____ it. (take)",
                                "Choose the antonym of 'take':\n(a) give, (b) grab, (c) seize",
                                "Write the synonym of the following word: take"},

                        {"arrive",
                                "Complete the sentence with the correct English synonym:\nShe will ____ to the party later. (come)",
                                "Choose the synonym of 'come':\n(a) arrive, (b) depart, (c) leave",
                                "Write the synonym of the following word: come"},

                        {"abstain",
                                "Complete the sentence with the correct English antonym:\nShe drinks tea daily, but today she decided to ____. (drink)",
                                "Choose the antonym of 'drink':\n(a) abstain, (b) sip, (c) gulp",
                                "Write the synonym of the following word: drink"},

                        {"compose",
                                "Complete the sentence with the correct English synonym:\nHe likes to ____ letters to his friends. (write)",
                                "Choose the synonym of 'write':\n(a) compose, (b) read, (c) erase",
                                "Write the synonym of the following word: write"},

                        {"end",
                                "Complete the sentence with the correct English antonym:\nWe will begin the meeting at 10 a.m. and ____ it at noon. (begin)",
                                "Choose the antonym of 'begin':\n(a) end, (b) start, (c) commence",
                                "Write the synonym of the following word: begin"},

                        {"sprint",
                                "Complete the sentence with the correct English synonym:\nHe can ____ very fast in competitions. (run)",
                                "Choose the synonym of 'run':\n(a) sprint, (b) walk, (c) stop",
                                "Write the synonym of the following word: run"},

                        {"fix",
                                "Complete the sentence with the correct English antonym:\nThe vase broke, but she managed to ____ it. (break)",
                                "Choose the antonym of 'break':\n(a) fix, (b) shatter, (c) crack",
                                "Write the synonym of the following word: break"}
                };
                    String[][] sinyantSustantivos ={
                        {"profession",
                                "Complete the sentence with the correct English synonym:\nHe chose a new ____ in medicine. (career)",
                                "Choose the synonym of 'career':\n(a) profession, (b) unemployment, (c) hobby",
                                "Write the synonym of the following word: career"},

                        {"incompetence",
                                "Complete the sentence with the correct English antonym:\nThat student shows skill, but the other shows ____. (skill)",
                                "Choose the antonym of 'skill':\n(a) incompetence, (b) ability, (c) expertise",
                                "Write the synonym of the following word: skill"},

                        {"understanding",
                                "Complete the sentence with the correct English synonym:\nReading gives us more ____. (knowledge)",
                                "Choose the synonym of 'knowledge':\n(a) understanding, (b) ignorance, (c) doubt",
                                "Write the synonym of the following word: knowledge"},

                        {"problem",
                                "Complete the sentence with the correct English antonym:\nWe found a solution, but another team found a ____. (solution)",
                                "Choose the antonym of 'solution':\n(a) problem, (b) answer, (c) resolution",
                                "Write the synonym of the following word: solution"},

                        {"surroundings",
                                "Complete the sentence with the correct English synonym:\nWe must protect our ____. (environment)",
                                "Choose the synonym of 'environment':\n(a) surroundings, (b) pollution, (c) habitat",
                                "Write the synonym of the following word: environment"},

                        {"inexperience",
                                "Complete the sentence with the correct English antonym:\nHe has a lot of experience, but she has ____. (experience)",
                                "Choose the antonym of 'experience':\n(a) inexperience, (b) practice, (c) expertise",
                                "Write the synonym of the following word: experience"},

                        {"baggage",
                                "Complete the sentence with the correct English synonym:\nShe packed her ____ before the trip. (luggage)",
                                "Choose the synonym of 'luggage':\n(a) baggage, (b) vendor, (c) suitcase",
                                "Write the synonym of the following word: luggage"},

                        {"vendor",
                                "Complete the sentence with the correct English antonym:\nThe customer bought fruit, but the ____ sold it. (customer)",
                                "Choose the antonym of 'customer':\n(a) vendor, (b) client, (c) buyer",
                                "Write the synonym of the following word: customer"},

                        {"view",
                                "Complete the sentence with the correct English synonym:\nEveryone has a different ____. (opinion)",
                                "Choose the synonym of 'opinion':\n(a) view, (b) fact, (c) truth",
                                "Write the synonym of the following word: opinion"},

                        {"free flow",
                                "Complete the sentence with the correct English antonym:\nThe traffic was heavy yesterday, but today there is ____. (traffic)",
                                "Choose the antonym of 'traffic':\n(a) free flow, (b) jam, (c) congestion",
                                "Write the synonym of the following word: traffic"}
                };
                    String[][] sinyantPreposiciones ={
                        {"over",
                                "Complete the sentence with the correct English synonym:\nThe lamp is ____ the table. (above)",
                                "Choose the synonym of 'above':\n(a) over, (b) under, (c) below",
                                "Write the synonym of the following word: above"},

                        {"above",
                                "Complete the sentence with the correct English antonym:\nThe shoes are below the bed, not ____ it. (below)",
                                "Choose the antonym of 'below':\n(a) above, (b) under, (c) beneath",
                                "Write the synonym of the following word: below"},

                        {"amid",
                                "Complete the sentence with the correct English synonym:\nShe was happy to be ____ friends. (among)",
                                "Choose the synonym of 'among':\n(a) amid, (b) alone, (c) outside",
                                "Write the synonym of the following word: among"},

                        {"alone",
                                "Complete the sentence with the correct English antonym:\nHe was among friends yesterday, but today he is ____. (among)",
                                "Choose the antonym of 'among':\n(a) alone, (b) together, (c) amidst",
                                "Write the synonym of the following word: among"},

                        {"within",
                                "Complete the sentence with the correct English synonym:\nThe cat is hiding ____ the box. (inside)",
                                "Choose the synonym of 'inside':\n(a) within, (b) outside, (c) exterior",
                                "Write the synonym of the following word: inside"},

                        {"exterior",
                                "Complete the sentence with the correct English antonym:\nThe cat is inside the box, not ____ it. (inside)",
                                "Choose the antonym of 'inside':\n(a) exterior, (b) within, (c) inside",
                                "Write the synonym of the following word: inside"},

                        {"onto",
                                "Complete the sentence with the correct English synonym:\nHe climbed ____ the roof quickly. (onto)",
                                "Choose the synonym of 'onto':\n(a) onto, (b) off, (c) under",
                                "Write the synonym of the following word: onto"},

                        {"off",
                                "Complete the sentence with the correct English antonym:\nHe jumped onto the roof, then got ____. (onto)",
                                "Choose the antonym of 'onto':\n(a) off, (b) upon, (c) down",
                                "Write the synonym of the following word: onto"},

                        {"around",
                                "Complete the sentence with the correct English synonym:\nThey walked ____ the park. (around)",
                                "Choose the synonym of 'around':\n(a) around, (b) about, (c) near",
                                "Write the synonym of the following word: around"},

                        {"far",
                                "Complete the sentence with the correct English antonym:\nThe school is near the library, not ____ it. (near)",
                                "Choose the antonym of 'near':\n(a) far, (b) close, (c) nearby",
                                "Write the synonym of the following word: near"}
                };
                    String[][] sinyantAdjetivos ={
                        {"joyful",
                                "Complete the sentence with the correct English synonym:\nShe feels ____ because she passed the exam. (happy)",
                                "Choose the synonym of 'happy':\n(a) joyful, (b) sad, (c) weak",
                                "Write the synonym of the following word: happy"},

                        {"happy",
                                "Complete the sentence with the correct English antonym:\nHe looked sad, but later he was ____. (sad)",
                                "Choose the antonym of 'sad':\n(a) happy, (b) joyful, (c) cheerful",
                                "Write the synonym of the following word: sad"},

                        {"large",
                                "Complete the sentence with the correct English synonym:\nThat is a very ____ house. (big)",
                                "Choose the synonym of 'big':\n(a) large, (b) tiny, (c) small",
                                "Write the synonym of the following word: big"},

                        {"tiny",
                                "Complete the sentence with the correct English antonym:\nThe puppy is big, but the kitten is ____. (small)",
                                "Choose the antonym of 'small':\n(a) tiny, (b) large, (c) huge",
                                "Write the synonym of the following word: small"},

                        {"quick",
                                "Complete the sentence with the correct English synonym:\nThe car is ____ and very expensive. (fast)",
                                "Choose the synonym of 'fast':\n(a) quick, (b) slow, (c) sluggish",
                                "Write the synonym of the following word: fast"},

                        {"sluggish",
                                "Complete the sentence with the correct English antonym:\nThe cheetah is fast, but the turtle is ____. (fast)",
                                "Choose the antonym of 'fast':\n(a) sluggish, (b) quick, (c) rapid",
                                "Write the synonym of the following word: fast"},

                        {"lovely",
                                "Complete the sentence with the correct English synonym:\nThe painting is ____. (beautiful)",
                                "Choose the synonym of 'beautiful':\n(a) lovely, (b) hideous, (c) ugly",
                                "Write the synonym of the following word: beautiful"},

                        {"hideous",
                                "Complete the sentence with the correct English antonym:\nThe painting is beautiful, but the wall is ____. (beautiful)",
                                "Choose the antonym of 'beautiful':\n(a) hideous, (b) lovely, (c) pretty",
                                "Write the synonym of the following word: beautiful"},

                        {"powerful",
                                "Complete the sentence with the correct English synonym:\nShe is ____ enough to lift heavy boxes. (strong)",
                                "Choose the synonym of 'strong':\n(a) powerful, (b) fragile, (c) weak",
                                "Write the synonym of the following word: strong"},

                        {"fragile",
                                "Complete the sentence with the correct English antonym:\nHe is strong, but after the illness he became ____. (strong)",
                                "Choose the antonym of 'strong':\n(a) fragile, (b) mighty, (c) powerful",
                                "Write the synonym of the following word: strong"}
                };
                    String[][] sinyantExpresionesComunes ={
                        {"how’s it going?",
                                "Complete the sentence with the correct English synonym:\n“____, I’m fine thanks.” (how are you?)",
                                "Choose the synonym of 'how are you?':\n(a) how’s it going?, (b) goodbye, (c) see you later",
                                "Write the synonym of the following expression: how are you?"},

                        {"goodbye",
                                "Complete the sentence with the correct English antonym:\nInstead of saying “how are you?”, he just said ____. (how are you?)",
                                "Choose the antonym of 'how are you?':\n(a) goodbye, (b) hello, (c) hi",
                                "Write the synonym of the following expression: how are you?"},

                        {"it’s been a while",
                                "Complete the sentence with the correct English synonym:\n“____, I missed you!” (long time no see)",
                                "Choose the synonym of 'long time no see':\n(a) it’s been a while, (b) see you often, (c) daily",
                                "Write the synonym of the following expression: long time no see"},

                        {"see you often",
                                "Complete the sentence with the correct English antonym:\nInstead of “long time no see”, they said “____, we meet every day.” (long time no see)",
                                "Choose the antonym of 'long time no see':\n(a) see you often, (b) it’s been a while, (c) rarely",
                                "Write the synonym of the following expression: long time no see"},

                        {"catch you later",
                                "Complete the sentence with the correct English synonym:\nBye, ____! (see you later)",
                                "Choose the synonym of 'see you later':\n(a) catch you later, (b) goodbye forever, (c) bye now",
                                "Write the synonym of the following expression: see you later"},

                        {"goodbye forever",
                                "Complete the sentence with the correct English antonym:\nInstead of “see you later”, she said “____ forever.” (see you later)",
                                "Choose the antonym of 'see you later':\n(a) goodbye forever, (b) catch you later, (c) bye now",
                                "Write the synonym of the following expression: see you later"}
                };

                    //PALABRAS VOCABULARIO JUEGO COMPLETAR ORACIONES
                    String[][] coVerbosregulares = {
                            { "play", "Complete the sentence with the correct English word:\nEvery Saturday morning, the children ______ football in the park with their friends.", "Complete the sentence with the correct English word:\nWhen I feel stressed, I usually ______ the guitar for at least one hour.", "Complete the sentence with the correct English word:\nAt the party last night, they ______ different games to entertain the guests."},
                            { "work", "Complete the sentence with the correct English word:\nMy father usually ______ in his office until late at night because he has many responsibilities.", "Complete the sentence with the correct English word:\nDuring the summer, many students ______ in restaurants to save money for school.", "Complete the sentence with the correct English word:\nShe ______ very hard on her project because she wants to get a promotion."},
                            { "talk", "Complete the sentence with the correct English word:\nAfter dinner, we always ______ about our plans for the future.", "Complete the sentence with the correct English word:\nThe teacher ______ to the students about the importance of studying every day.", "Complete the sentence with the correct English word:\nYesterday, my best friend ______ to me for hours about her new job."},
                            { "watch", "Complete the sentence with the correct English word:\nOn weekends, my family ______ movies together in the living room.", "Complete the sentence with the correct English word:\nAt night, he usually ______ the news to know what is happening in the world.", "Complete the sentence with the correct English word:\nLast summer, we ______ the stars from the beach until midnight."},
                            { "clean", "Complete the sentence with the correct English word:\nEvery Sunday morning, my mother ______ the entire house before visitors arrive.", "Complete the sentence with the correct English word:\nThe workers ______ the office carefully because the manager asked them to.", "Complete the sentence with the correct English word:\nYesterday, I ______ my room and found many old photos."},
                            { "open", "Complete the sentence with the correct English word:\nPlease ______ the window because it is very hot in here.", "Complete the sentence with the correct English word:\nEvery morning, the shopkeeper ______ his store at 9 o’clock sharp.", "Complete the sentence with the correct English word:\nWhen she ______ the box, she discovered a beautiful gift inside."},
                            { "help", "Complete the sentence with the correct English word:\nThe nurse always ______ the patients with kindness and patience.", "Complete the sentence with the correct English word:\nMy brother ______ me with my homework when I don’t understand the exercises.", "Complete the sentence with the correct English word:\nYesterday, the volunteers ______ the old man carry his heavy bags."},
                            { "start", "Complete the sentence with the correct English word:\nThe movie ______ at 8 p.m., so we need to arrive early.", "Complete the sentence with the correct English word:\nEvery day, she ______ her work by checking her emails first.", "Complete the sentence with the correct English word:\nLast week, the company ______ a new project to improve customer service."},
                            { "call", "Complete the sentence with the correct English word:\nEvery evening, I ______ my grandmother to ask how she is.", "Complete the sentence with the correct English word:\nThe teacher ______ the students one by one to answer the questions.", "Complete the sentence with the correct English word:\nYesterday, my friend ______ me three times because she needed urgent help."},
                            { "live", "Complete the sentence with the correct English word:\nMany people ______ in big cities because there are more job opportunities.", "Complete the sentence with the correct English word:\nMy cousins ______ in a small village near the mountains.", "Complete the sentence with the correct English word:\nWhen I was a child, we ______ in a house with a large garden."}
                            };
                    String[][] coVerbosIrregulares = {
                            { "go", "Complete the sentence with the correct English word:\nEvery morning, I ______ to school by bus because it is faster than walking.", "Complete the sentence with the correct English word:\nLast summer, we ______ to the mountains to spend our holidays together.", "Complete the sentence with the correct English word:\nShe usually ______ to the gym after work to stay healthy."},
                            { "eat", "Complete the sentence with the correct English word:\nAt lunchtime, the students ______ sandwiches and fruit in the cafeteria.", "Complete the sentence with the correct English word:\nYesterday, we ______ pizza while watching a movie at home.", "Complete the sentence with the correct English word:\nHe always ______ breakfast before leaving for the office."},
                            { "see", "Complete the sentence with the correct English word:\nFrom the top of the tower, you can ______ the entire city and the river.", "Complete the sentence with the correct English word:\nLast night, I ______ a shooting star while walking in the garden.", "Complete the sentence with the correct English word:\nShe usually ______ her friends at the park on weekends."},
                            { "take", "Complete the sentence with the correct English word:\nPlease ______ this book with you and return it next week.", "Complete the sentence with the correct English word:\nYesterday, he ______ a photo of the sunset because it looked amazing.", "Complete the sentence with the correct English word:\nShe always ______ notes during class to remember the important details."},
                            { "come", "Complete the sentence with the correct English word:\nCan you ______ to my house tomorrow to study together?", "Complete the sentence with the correct English word:\nLast week, many visitors ______ to the museum to see the new exhibition.", "Complete the sentence with the correct English word:\nHe usually ______ home late because of his busy schedule."},
                            { "drink", "Complete the sentence with the correct English word:\nAfter running in the park, I always ______ a glass of cold water.", "Complete the sentence with the correct English word:\nYesterday, she ______ tea with her grandmother in the afternoon.", "Complete the sentence with the correct English word:\nThey usually ______ coffee before starting their work in the morning."},
                            { "write", "Complete the sentence with the correct English word:\nEvery day, the journalist ______ articles for the local newspaper.", "Complete the sentence with the correct English word:\nLast month, she ______ a letter to her best friend in Canada.", "Complete the sentence with the correct English word:\nHe usually ______ notes in his notebook during meetings."},
                            { "begin", "Complete the sentence with the correct English word:\nThe class will ______ at 9 a.m., so please be on time.", "Complete the sentence with the correct English word:\nYesterday, the concert ______ with a beautiful piano solo.", "Complete the sentence with the correct English word:\nShe usually ______ her day by reading the news online."},
                            { "run", "Complete the sentence with the correct English word:\nEvery morning, he ______ five kilometers to stay in shape.", "Complete the sentence with the correct English word:\nLast year, she ______ in a marathon and finished in the top ten.", "Complete the sentence with the correct English word:\nThe children usually ______ around the playground during recess."},
                            { "break", "Complete the sentence with the correct English word:\nBe careful not to ______ the glass when you wash it.", "Complete the sentence with the correct English word:\nYesterday, he accidentally ______ his phone while playing football.", "Complete the sentence with the correct English word:\nShe usually ______ her pencil when she presses too hard while writing."}
                    };
                    String[][] coSustantivos = {
                            { "career",
                                    "Complete the sentence with the correct English word:\nShe decided to pursue a challenging ______ in medicine because she loves helping people.",
                                    "Complete the sentence with the correct English word:\nAfter many years of dedication, he finally built a successful ______ in engineering.",
                                    "Complete the sentence with the correct English word:\nChoosing the right ______ can influence your happiness and financial stability in the future."
                            },
                            { "skill",
                                    "Complete the sentence with the correct English word:\nLearning a new ______ such as coding can open many opportunities in the future.",
                                    "Complete the sentence with the correct English word:\nPublic speaking is an important ______ for leaders who want to inspire others.",
                                    "Complete the sentence with the correct English word:\nShe practiced every day to improve her piano ______ and perform confidently."
                            },
                            { "knowledge",
                                    "Complete the sentence with the correct English word:\nTeachers share their ______ with students to help them understand the world better.",
                                    "Complete the sentence with the correct English word:\nReading books is one of the best ways to gain ______ about history and culture.",
                                    "Complete the sentence with the correct English word:\nHis deep ______ of science helped him solve the complex problem quickly."
                            },
                            { "solution",
                                    "Complete the sentence with the correct English word:\nThe engineer found a creative ______ to fix the problem in the machine.",
                                    "Complete the sentence with the correct English word:\nWe need to find a practical ______ to reduce pollution in the city.",
                                    "Complete the sentence with the correct English word:\nAfter hours of discussion, the team finally agreed on a ______ to the conflict."
                            },
                            { "environment",
                                    "Complete the sentence with the correct English word:\nWe must protect the natural ______ to ensure a healthy planet for future generations.",
                                    "Complete the sentence with the correct English word:\nThe company created a safe working ______ for all its employees.",
                                    "Complete the sentence with the correct English word:\nChildren grow better in a positive ______ where they feel supported and loved."
                            },
                            { "experience",
                                    "Complete the sentence with the correct English word:\nTraveling abroad was an unforgettable ______ that taught me many lessons.",
                                    "Complete the sentence with the correct English word:\nShe gained valuable ______ while working as an intern in the hospital.",
                                    "Complete the sentence with the correct English word:\nThe concert was an amazing ______ that I will never forget."
                            },
                            { "luggage",
                                    "Complete the sentence with the correct English word:\nThe passengers carried heavy ______ through the airport before boarding the plane.",
                                    "Complete the sentence with the correct English word:\nPlease check your ______ before leaving the hotel to avoid forgetting anything.",
                                    "Complete the sentence with the correct English word:\nHer ______ was lost during the flight, so the airline had to deliver it later."
                            },
                            { "customer",
                                    "Complete the sentence with the correct English word:\nThe shop assistant greeted the ______ politely and offered help with the products.",
                                    "Complete the sentence with the correct English word:\nEvery ______ expects good service when they visit a restaurant or store.",
                                    "Complete the sentence with the correct English word:\nThe company values each ______ and tries to meet their needs effectively."
                            },
                            { "opinion",
                                    "Complete the sentence with the correct English word:\nEveryone has the right to express their ______ about important social issues.",
                                    "Complete the sentence with the correct English word:\nIn my ______, teamwork is the key to success in any project.",
                                    "Complete the sentence with the correct English word:\nShe shared her ______ on the book, and many classmates agreed with her."
                            },
                            { "traffic",
                                    "Complete the sentence with the correct English word:\nWe were late because the heavy ______ delayed us for more than an hour.",
                                    "Complete the sentence with the correct English word:\nThe city is working on new plans to reduce ______ during rush hours.",
                                    "Complete the sentence with the correct English word:\nAccidents often happen when there is too much ______ on the highway."
                            }
                    };
                    String[][] coPreposiciones = {
                            { "above",
                                    "Complete the sentence with the correct English word:\nThe stars shine brightly ______ the mountains, creating a breathtaking view at night.",
                                    "Complete the sentence with the correct English word:\nThe helicopter hovered ______ the city, giving the passengers a clear view of the streets.",
                                    "Complete the sentence with the correct English word:\nThe picture was placed ______ the sofa to decorate the living room."
                            },
                            { "below",
                                    "Complete the sentence with the correct English word:\nThe valley lies ______ the snowy peaks, surrounded by forests and rivers.",
                                    "Complete the sentence with the correct English word:\nThe answers are written ______ the questions on the exam paper.",
                                    "Complete the sentence with the correct English word:\nThe basement is located ______ the main floor of the house."
                            },
                            { "between",
                                    "Complete the sentence with the correct English word:\nThe playground is located ______ the school and the library, making it easy to find.",
                                    "Complete the sentence with the correct English word:\nShe sat ______ her two best friends during the ceremony.",
                                    "Complete the sentence with the correct English word:\nThe negotiations took place ______ the government and the workers’ union."
                            },
                            { "among",
                                    "Complete the sentence with the correct English word:\nShe felt comfortable ______ her classmates because they welcomed her warmly.",
                                    "Complete the sentence with the correct English word:\nThe treasure was hidden ______ the trees in the forest.",
                                    "Complete the sentence with the correct English word:\nThere was a sense of excitement ______ the fans before the concert began."
                            },
                            { "inside",
                                    "Complete the sentence with the correct English word:\nThe documents are stored ______ the drawer to keep them safe.",
                                    "Complete the sentence with the correct English word:\nThe children stayed ______ the house because it was raining heavily.",
                                    "Complete the sentence with the correct English word:\nThe cat is hiding ______ the box, waiting to surprise its owner."
                            },
                            { "outside",
                                    "Complete the sentence with the correct English word:\nThe kids are playing ______ the house because the weather is sunny.",
                                    "Complete the sentence with the correct English word:\nThere is a bench ______ the building where people can rest.",
                                    "Complete the sentence with the correct English word:\nThe dog waited patiently ______ the store until its owner returned."
                            },
                            { "onto",
                                    "Complete the sentence with the correct English word:\nThe child climbed ______ the chair to reach the cookies on the table.",
                                    "Complete the sentence with the correct English word:\nThe ball rolled ______ the roof after the strong wind blew it away.",
                                    "Complete the sentence with the correct English word:\nShe stepped ______ the stage confidently to deliver her speech."
                            },
                            { "off",
                                    "Complete the sentence with the correct English word:\nPlease take your shoes ______ before entering the house.",
                                    "Complete the sentence with the correct English word:\nThe bird suddenly flew ______ the branch and disappeared into the sky.",
                                    "Complete the sentence with the correct English word:\nHe fell ______ the bike because the road was slippery."
                            },
                            { "around",
                                    "Complete the sentence with the correct English word:\nThe children ran ______ the playground laughing and shouting with joy.",
                                    "Complete the sentence with the correct English word:\nThere are many shops ______ the central square of the town.",
                                    "Complete the sentence with the correct English word:\nShe wrapped a scarf ______ her neck to stay warm."
                            },
                            { "near",
                                    "Complete the sentence with the correct English word:\nThere is a small café ______ the station where we can wait for the train.",
                                    "Complete the sentence with the correct English word:\nThe school is located ______ the park, making it easy for children to play after class.",
                                    "Complete the sentence with the correct English word:\nHe bought a house ______ the beach to enjoy the ocean view."
                            }
                    };
                    String[][] coAdjetivos = {
                            { "happy",
                                    "Complete the sentence with the correct English word:\nShe felt ______ when she received the news that she had passed all her exams.",
                                    "Complete the sentence with the correct English word:\nThe children were ______ to see their grandparents after such a long time.",
                                    "Complete the sentence with the correct English word:\nHe was truly ______ on his wedding day, surrounded by family and friends."
                            },
                            { "sad",
                                    "Complete the sentence with the correct English word:\nShe looked ______ after hearing that her best friend was moving to another country.",
                                    "Complete the sentence with the correct English word:\nThe movie was so ______ that many people cried at the end.",
                                    "Complete the sentence with the correct English word:\nHe felt ______ because he couldn’t attend the party with his friends."
                            },
                            { "big",
                                    "Complete the sentence with the correct English word:\nThey live in a ______ house with a large garden and swimming pool.",
                                    "Complete the sentence with the correct English word:\nThe company made a ______ investment in new technology last year.",
                                    "Complete the sentence with the correct English word:\nShe carried a ______ box that was too heavy for her alone."
                            },
                            { "small",
                                    "Complete the sentence with the correct English word:\nHe bought a ______ car because it was easier to park in the city.",
                                    "Complete the sentence with the correct English word:\nThe child held a ______ toy in his hands and smiled.",
                                    "Complete the sentence with the correct English word:\nThey live in a ______ apartment near the university."
                            },
                            { "fast",
                                    "Complete the sentence with the correct English word:\nThe cheetah is a ______ animal that can run at incredible speeds.",
                                    "Complete the sentence with the correct English word:\nShe typed so ______ that she finished the report in half the time.",
                                    "Complete the sentence with the correct English word:\nThe train was very ______ and arrived earlier than expected."
                            },
                            { "slow",
                                    "Complete the sentence with the correct English word:\nThe old man walked ______ along the path, enjoying the scenery.",
                                    "Complete the sentence with the correct English word:\nThe internet connection was so ______ that it took hours to download the file.",
                                    "Complete the sentence with the correct English word:\nHe spoke ______ so that everyone could understand his explanation clearly."
                            },
                            { "beautiful",
                                    "Complete the sentence with the correct English word:\nThe garden looked ______ in spring, full of colorful flowers and green trees.",
                                    "Complete the sentence with the correct English word:\nShe wore a ______ dress that caught everyone’s attention at the party.",
                                    "Complete the sentence with the correct English word:\nThe sunset over the ocean was truly ______ and unforgettable."
                            },
                            { "ugly",
                                    "Complete the sentence with the correct English word:\nThe building looked ______ because it hadn’t been painted in years.",
                                    "Complete the sentence with the correct English word:\nHe thought the shoes were ______, but his sister liked them.",
                                    "Complete the sentence with the correct English word:\nThe monster in the movie was so ______ that the children screamed."
                            },
                            { "strong",
                                    "Complete the sentence with the correct English word:\nShe is a ______ woman who never gives up, even in difficult times.",
                                    "Complete the sentence with the correct English word:\nThe bridge is ______ enough to support thousands of cars every day.",
                                    "Complete the sentence with the correct English word:\nHe became ______ after months of training at the gym."
                            },
                            { "weak",
                                    "Complete the sentence with the correct English word:\nAfter being sick for a week, he felt too ______ to go back to work.",
                                    "Complete the sentence with the correct English word:\nThe chair was so ______ that it broke when someone sat on it.",
                                    "Complete the sentence with the correct English word:\nShe was ______ after the long race and needed to rest."
                            }
                    };
                    String[][] coExpresionesComunes = {
                            { "How are you?",
                                    "Complete the sentence with the correct English expression:\nWhen I meet my friend after class, I usually greet her by saying ______.",
                                    "Complete the sentence with the correct English expression:\nAt the beginning of the phone call, he asked politely ______ to show interest.",
                                    "Complete the sentence with the correct English expression:\nShe smiled and said ______ when she saw her neighbor in the morning."
                            },
                            { "What’s up?",
                                    "Complete the sentence with the correct English expression:\nWhen I saw my cousin at the party, I casually said ______ to start the conversation.",
                                    "Complete the sentence with the correct English expression:\nHe walked into the room and greeted everyone with a cheerful ______.",
                                    "Complete the sentence with the correct English expression:\nFriends often say ______ when they want to know what’s happening."
                            },
                            { "Long time no see",
                                    "Complete the sentence with the correct English expression:\nAfter meeting an old classmate at the mall, she exclaimed ______ with excitement.",
                                    "Complete the sentence with the correct English expression:\nHe greeted his former teacher by saying ______ because they hadn’t met in years.",
                                    "Complete the sentence with the correct English expression:\nWhen I saw my neighbor after months, I said ______ with a big smile."
                            },
                            { "Take care",
                                    "Complete the sentence with the correct English expression:\nBefore leaving for her trip, her mother hugged her and said ______ warmly.",
                                    "Complete the sentence with the correct English expression:\nHe ended the email with the words ______ to show kindness.",
                                    "Complete the sentence with the correct English expression:\nWhen saying goodbye to a friend, it’s common to say ______."
                            },
                            { "See you later",
                                    "Complete the sentence with the correct English expression:\nAfter finishing lunch, he waved at his friend and said ______ before leaving.",
                                    "Complete the sentence with the correct English expression:\nShe told her classmates ______ because they would meet again in the afternoon.",
                                    "Complete the sentence with the correct English expression:\nAt the end of the meeting, the manager smiled and said ______ to everyone."
                            },
                            { "Nice to meet you",
                                    "Complete the sentence with the correct English expression:\nWhen introduced to a new colleague, she said ______ politely.",
                                    "Complete the sentence with the correct English expression:\nHe shook hands and said ______ during the interview.",
                                    "Complete the sentence with the correct English expression:\nAt the party, she greeted the guest with a smile and said ______."
                            },
                            { "Have a good day",
                                    "Complete the sentence with the correct English expression:\nThe cashier smiled and said ______ after giving me the receipt.",
                                    "Complete the sentence with the correct English expression:\nShe ended her message with ______ to wish her friend well.",
                                    "Complete the sentence with the correct English expression:\nBefore leaving the office, he told his coworkers ______."
                            },
                            { "Don’t worry",
                                    "Complete the sentence with the correct English expression:\nWhen she forgot her homework, the teacher said ______ and gave her another chance.",
                                    "Complete the sentence with the correct English expression:\nHe told his friend ______ because the problem was already solved.",
                                    "Complete the sentence with the correct English expression:\nShe comforted her brother by saying ______ after he made a mistake."
                            },
                            { "It’s up to you",
                                    "Complete the sentence with the correct English expression:\nWhen deciding where to eat, he said ______ to let his friend choose.",
                                    "Complete the sentence with the correct English expression:\nShe told her team ______ because they could decide the best strategy.",
                                    "Complete the sentence with the correct English expression:\nHe shrugged and said ______ when asked about the movie choice."
                            },
                            { "By the way",
                                    "Complete the sentence with the correct English expression:\nShe added ______ at the end of the conversation to mention something important.",
                                    "Complete the sentence with the correct English expression:\nHe said ______ before reminding his friend about the meeting tomorrow.",
                                    "Complete the sentence with the correct English expression:\nDuring the discussion, she used ______ to introduce a new topic."
                            }
                    };
                    //PALABRAS VOCABULARIO ADIVIDAR PALABRAS
                        int nivelVocabulario;
                    System.out.println("            Ingresa la categoría gramatical que deseas estudiar (recuerda que se dara por hecho que ya has cursado las categorías gramaticales anterirores a ella):");
                    System.out.println("            1.Verbo\n" + "            2.Sustantivo\n" + "            3.Preposiciones\n" + "            4.Adjetivos\n" + "            5.Expresiones comunes");

                  do {
                        nivelVocabulario = sc.nextInt();
                        switch (nivelVocabulario) {
                            case 1:
                                nnombre = "Verbo";
                                int formadeverbo;
                                System.out.println("Selecciona la forma de verbo que deseas estudiar");
                                System.out.println("1.Verbos Regulares\n" + "2.Verbos Irregulares");
                                formadeverbo = sc.nextInt();
                                do {
                                    switch (formadeverbo) {
                                        case 1:
                                            System.out.println("Has elegido verbos regulares");
                                            PALABRAS_VOCABULARIO = nvVerboregulares;
                                            PALABRAS_RELACIONADAS = sinyantVerbosRegulares;
                                            COMPLETAR_ORACIONES = coVerbosregulares;
                                         break;
                                        case 2:
                                            System.out.println("Has elegido verbos irregulares");
                                            PALABRAS_VOCABULARIO = nvVerbosirregulares;
                                            PALABRAS_RELACIONADAS = sinyantVerbosIrregulares;
                                            COMPLETAR_ORACIONES = coVerbosIrregulares;
                                            break;
                                        default:
                                            System.out.print("Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
                                            break;
                                    }
                                }
                                while (formadeverbo < 1 || formadeverbo > 2);
                                break;

                            case 2:
                                nnombre = "Sustantivo";
                                PALABRAS_VOCABULARIO = nvSustantivo;
                                PALABRAS_RELACIONADAS = sinyantSustantivos;
                                COMPLETAR_ORACIONES = coSustantivos;
                                break;

                            case 3:
                                nnombre = "Preposiciones";
                                PALABRAS_VOCABULARIO = nvPreposiciones;
                                PALABRAS_RELACIONADAS = sinyantPreposiciones;
                                COMPLETAR_ORACIONES = coPreposiciones;
                                break;

                            case 4:
                                nnombre = "Adjetivos";
                                PALABRAS_VOCABULARIO = nvAdjetivos;
                                PALABRAS_RELACIONADAS = sinyantAdjetivos;
                                COMPLETAR_ORACIONES = coAdjetivos;
                                break;

                            case 5:
                                nnombre = "Expresiones comunes";
                                PALABRAS_VOCABULARIO = nvExpresionescomunes;
                                PALABRAS_RELACIONADAS = sinyantExpresionesComunes;
                                COMPLETAR_ORACIONES = coExpresionesComunes;
                                break;

                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ninguna categoría gramatical. Intenta de nuevo: ");
                                break;

                        }
                    }
                    while (nivelVocabulario < 1 || nivelVocabulario > 5);

                        System.out.println("         +=========================================================+");
                        System.out.println("         ||       Ahora elige la modalidad                         ||");
                        System.out.println("         ||       1. Modalidad Tradicional                         ||");
                        System.out.println("         ||       2. Modalidad Juegos                              ||");
                        System.out.println("         +=========================================================+");
                        System.out.print("\n\n          Ingresa 1 o 2: ");
                        int modalidadVocabulario;
                        do {
                            modalidadVocabulario = sc.nextInt();
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
                        break;
                    default:
                        System.out.print("Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
                }
            }
            while (opcionprincipal != 1 && opcionprincipal != 2);
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

   public static String[][] obtenerMatrizPorNivel(String nivel) {
        switch (nivelSpellingBee) {
            case 1:
                return nsbBasico;
            case 2:
                return nsbMedio;
            case 3:
                return nsbNormal;
            case 4:
                return nsbDificil;
            case 5:
                return nsbExpert;
            default:
                return nsbBasico; // solo formalidad
        }
    }



    public static void modalidadTradicionalSpellingBee() {

        String[][] matriz = obtenerMatrizPorNivel(nivel);

        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;

        bienvenida();
        System.out.println("1- Se te mostrará la traducción, la definición en inglés de una palabra, o una oración con un espacio en blanco.\n2- Escribe la palabra correcta.\n3- Cada intento recibe retroalimentación inmediata.\n4- Al final verás tu resumen.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = matriz[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(prompt);

            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = matriz[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n--- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {

                int indicePalabra = palabrasFalladas[f];

                int pista2;
                do {
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = matriz[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = matriz[indicePalabra][0].toLowerCase();

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
                System.out.print(matriz[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
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

 public static void ganaste()
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
    public static void perdiste()
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
                System.out.print(COMPLETAR_ORACIONES[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
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

 public static void vjPalabrasRelacionadas() {
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        bienvenida();
        System.out.println("En cada ronda, usted deberá:\n1- Escribir el significado en español de una palabra que se muestre en inglés,\n2- Escribir la palabra en inglés a partir de su significado en español, o\n3- Seleccionar la traducción correcta entre varias opciones.\nAdemás:\nCada palabra incluirá ejemplos contextualizados, como frases o fragmentos de conversación, para ayudarle a comprender y usar correctamente el vocabulario.\nRecibirá retroalimentación inmediata en cada intento, y al finalizar un nivel o categoría, podrá revisar un resumen con sus aciertos y errores.\nLas palabras que no domine serán retomadas automáticamente por el sistema en repaso.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = PALABRAS_RELACIONADAS[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(PALABRAS_RELACIONADAS[i][pista + 1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = PALABRAS_RELACIONADAS[i][0].trim();

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
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = PALABRAS_RELACIONADAS[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = PALABRAS_RELACIONADAS[indicePalabra][0].toLowerCase();

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
                System.out.print(COMPLETAR_ORACIONES[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }
         
    }

    public static void vjCompletarOraciones() {
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        bienvenida();
        System.out.println("En este juego deberás:\n1. Completar oraciones incompletas en inglés escribiendo la palabra correcta en los espacios, usando el vocabulario que ya has aprendido.\n2. El sistema validará tu respuesta en tiempo real, indicándote si es correcta o incorrecta.\n3. Al finalizar cada ronda, verás un resumen de resultados con tus aciertos y errores, para reforzar las palabras que aún no dominas.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = COMPLETAR_ORACIONES[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(COMPLETAR_ORACIONES[i][pista + 1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = COMPLETAR_ORACIONES[i][0].trim();

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
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = COMPLETAR_ORACIONES[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = COMPLETAR_ORACIONES[indicePalabra][0].toLowerCase();

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
                System.out.print(COMPLETAR_ORACIONES[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }

    }

    public static void vjAdiviniarPalabras() {
        bienvenida();
        System.out.println("En este juego deberás:\n1. Adivinar la palabra en inglés que se te presenta escribiéndola correctamente, usando las pistas que recibas.\n2. Cada intento recibirá retroalimentación inmediata, y si fallas, el sistema mostrará la palabra correcta.\n3. Al finalizar la ronda, verás un resumen de resultados con tus aciertos y errores.");
        contador();
    }

   

}
