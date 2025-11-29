import java.util.Scanner;
import java.util.Random;
public class Lingolyn {
    /*Variables usadas para todos los metodos (Principalmente en el Modulo General)*/
    static Scanner sc = new Scanner(System.in);
    static String usuario;
    static String nnombre;
    static String allnombre;
    static String nivel;
    static int nivelSpellingBee;

    /*Variables para Modalidad Tradicional Spelling Bee*/
    static int aciertos = 0;
    static int errores = 0;
    static int[] palabrasFalladas = new int[10];
    static int contadorFallos = 0;
    static int[] pistaUsada = new int[10];
    static Random random = new Random();

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


    public static void registro(){
        System.out.println("            Por favor, ingresa tu nombre (como quieres que te llamemos);");
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


                    System.out.println("            Ingresa el nivel que deseas cursar (recuerda que se dara por hecho que ya has cursado los niveles anteriores a el):");
                    System.out.println("            1- Básico\n            2- Medio\n            3- Normal\n            4- Difícil\n            5- Expert");

                    do {
                        nivelSpellingBee = sc.nextInt();
                        switch (nivelSpellingBee) {
                            case 1:
                                nnombre = "Básico";
                                break;
                            case 2:
                                nnombre = "Medio";
                                break;
                            case 3:
                                nnombre = "Normal";
                                break;
                            case 4:
                                nnombre = "Difícil";
                                break;
                            case 5:
                                nnombre = "Expert";
                                break;
                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ningún nivel. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while(nivelSpellingBee<1 || nivelSpellingBee>5);


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
                    nivel ="la categoría gramatical";
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
                    int nivelVocabulario;
                    System.out.println("            Ingresa la categoría gramatical que deseas estudiar (recuerda que se dara por hecho que ya has cursado las categorías gramaticales anterirores a ella):");
                    System.out.println("            1.Verbo\n" + "            2.Sustantivo\n" + "            3.Preposiciones\n" + "            4.Adjetivos\n" + "            5.Expresiones comunes");

                    do {
                        nivelVocabulario= sc.nextInt();
                        switch (nivelVocabulario) {
                            case 1:
                                nnombre = "Verbo";
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
                    while(nivelVocabulario<1 || nivelVocabulario>5);


                    /*Preguntar modalidad Spelling Bee */
                    System.out.println("         +=========================================================+");
                    System.out.println("         ||       Ahora elige la modalidad                         ||");
                    System.out.println("         ||       1. Modalidad Tradicional                         ||");
                    System.out.println("         ||       2. Modalidad Juegos                              ||");
                    System.out.println("         +=========================================================+");
                    System.out.print("\n\n          Ingresa 1 o 2: ");
                    int modalidadVocabulario;

                    /*Leer modalidad Vocabulario*/
                    do {
                        modalidadVocabulario = sc.nextInt();
                        switch (modalidadVocabulario) {
                            case 1:
                                allnombre ="Vocabulario Modalidad Tradicional";
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


    public static void pause(long ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){}
    }


    public static void contador(){
        pause(4000);
        System.out.println("¿Estas list@?...");
        sc.nextLine();
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


    public static void bienvenida(){
        pause(800);
        System.out.println("cargando instrucciones...");
        pause(1500);
        System.out.println("¡Bienvenid@ " + usuario + " :D!\nA continuación iniciará la ronda de "+ allnombre + ", en "+ nivel +" "+ nnombre);
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
        do{
            sbRetoJuego= sc.nextInt();
            switch (sbRetoJuego){
                case 1:
                    System.out.println("¡Excelente decisión! Ahora porfavor ingresa el numero de reto que te gustaría jugar\n1- Deletreo Rápido\n2- Desafío de Precisión");
                    int sbReto;
                    do{
                        sbReto = sc.nextInt();
                        switch (sbReto){
                            case 1:
                                allnombre ="reto Deletreo Rápido";
                                sbrDeletreoRapido();
                                break;
                            case 2:
                                allnombre ="reto Desafio de Precisión";
                                sbrDesafioPrecision();
                                break;
                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ningun reto. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while(sbReto < 1 || sbReto > 3);
                    break;
                case 2:
                    System.out.println("¡Excelente decisión! Ahora porfavor ingresa el numero de juego que te gustaría jugar\n1- Ahorcado\n2- Completar letras faltantes\n3- Ordenar letras");
                    int sbJuego;
                    do{
                        sbJuego = sc.nextInt();
                        switch (sbJuego){
                            case 1:
                                allnombre ="juego Ahorcado";
                                sbjAhorcado();
                                break;
                            case 2:
                                allnombre ="juego Completar Letras Faltantes";
                                sbjCompletarLetrasFaltantes();
                                break;
                            case 3:
                                allnombre ="juego Ordenar Letras";
                                sbjOrdenarLetras();
                                break;
                            default:
                                System.out.print("Opción invalida. Ese número no corresponde a ningun juego. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while(sbJuego < 1 || sbJuego > 3);
                    break;
                default:
                    System.out.print("Opción invalida. Ese número no corresponde a ninguna opcion. Intenta de nuevo: ");
                    break;
            }
        }
        while(sbRetoJuego!= 1 && sbRetoJuego != 2);
    }


    public static void sbrDeletreoRapido(){
        bienvenida();
        System.out.println("En este reto deberás:\n-Escribir la mayor cantidad de palabras correctamente en 3 minutos.\n-Escribir cada palabra en inglés a partir de su traducción al español, de manera consecutiva, antes de pasar a la siguiente. \n-Al terminar el tiempo, revisar un resumen de resultados que muestra tus aciertos, errores y palabras falladas.");
        contador();
    }


    public static void sbrDesafioPrecision(){
        bienvenida();
        System.out.println("En este reto deberás:\n-Deletrear la mayor cantidad de palabras posible, pero solo puedes cometer tres errores.\n-Cuando cometas el tercer error, el reto terminará automáticamente y verás un resumen con tus aciertos y errores.\n-Este reto te ayudará a mejorar tu precisión y concentración mientras escribes.");
        contador();
    }


    public static void sbjAhorcado(){
        bienvenida();
        System.out.println("En este juego deberás:\n"+ "1. Adivinar la palabra letra por letra, completándola antes de que se terminen tus intentos.\n" + "2. Cada letra correcta se mostrará en su posición correspondiente, mientras que los errores se contabilizan.\n" + "3. Recibirás retroalimentación inmediata, y si no logras adivinar la palabra, al finalizar se mostrará la palabra completa.");
        contador();

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
        bienvenida();
        System.out.println("En cada ronda, usted deberá:\n1- Escribir el significado en español de una palabra que se muestre en inglés,\n2- Escribir la palabra en inglés a partir de su significado en español, o\n3- Seleccionar la traducción correcta entre varias opciones.\nAdemás:\nCada palabra incluirá ejemplos contextualizados, como frases o fragmentos de conversación, para ayudarle a comprender y usar correctamente el vocabulario.\nRecibirá retroalimentación inmediata en cada intento, y al finalizar un nivel o categoría, podrá revisar un resumen con sus aciertos y errores.\nLas palabras que no domine serán retomadas automáticamente por el sistema en repaso.");
        contador();
    }


    public static void modalidadJuegosVocabulario() {
        System.out.println("Has elegido la Modalidad Juegos, en el nivel " + nnombre);
        int vjuego;
        System.out.println("Ingresa el juego que te gustaría jugar\n1- Palabras relacionadas\n2- Completar oraciones\n3- Adivinar la palabra");
        do{
            vjuego= sc.nextInt();
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
}
