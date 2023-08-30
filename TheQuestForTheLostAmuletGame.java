import com.sun.security.jgss.GSSUtil;

import java.util.*;


public class TheQuestForTheLostAmuletGame {
    static int health = 100;
    static Scanner sc =  new Scanner(System.in);
    static int userChoice;
    static boolean masterArchery = false;
    static String playerName;
    static boolean isAlive = true;
    public static void welcomeScreen(){
        animationText("Welcome to our Game :- The Quest for the Lost Amulet");
        System.out.println("Please Enter Your Name to Continue to the Game");
        System.out.println();
        playerName = sc.nextLine();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("Important Note :- You will have only 100 health and a archer as a weapon with Archery Basic Skills.");
        System.out.println();
        System.out.println("Hello" + playerName + "In a land of magic and mystery, a legendary amulet is said to grant its bearer unimaginable power. " +
                "As a brave adventurer, you embark on a quest to find the Lost Amulet and prove your courage. " +
                "Your journey will be filled with choices, surprises, and the thrill of discovery.\n");
    }
    public static void chapterOne() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Lets Start....");
        System.out.println("\nChapter 1: The Mysterious Invitation\n");
        System.out.println("You receive a mysterious letter inviting you to the ancient town of Eldor. " +
                "\nA wise old sage named Alistair awaits you. Upon arrival, he presents you with a choice:\n");
        System.out.println("1. Accept the Quest: Embark on a journey to find the Lost Amulet.");
        System.out.println("2. Decline the Quest: Politely thank Alistair but choose not to proceed.\n");
        System.out.print("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            chapterTwo();
        }
        else
        {
            System.out.println("You Have Decline the Quest but you are in trouble " +
                    "\nYour Sister Is Sick if you will find amulet then only he will recover" +
                    "\nYou have no Choice Left Dear!!!");
            System.out.println("1. Accept the Quest: Embark on a journey to find the Lost Amulet.");
            System.out.println("Enter 1 to Continue");
            userChoice = sc.nextInt();
            while (userChoice > 2){
                System.out.println("Invalid Choice ");
                System.out.println("Enter 1 or 2");
                userChoice = sc.nextInt();
            }
            chapterTwo();
        }
    }
    public static void chapterTwo(){
        System.out.println("\nChapter 2: The Path Ahead\n");
        System.out.println("Alistair gives you a map leading to the rumored location of the Lost Amulet. " +
                "\nYour journey takes you through enchanted forests and rocky mountains. " +
                "\nAlong the way, you encounter a fork in the road:");
        System.out.println("1. Forest Trail: Traverse the mystical forest, hoping to find clues.");
        System.out.println("2. Mountain Pass: Climb the rocky mountain for a better vantage point.");
        System.out.println();
        System.out.print("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            System.out.println("Well Done! You Travelled the Mystical Forest and" +
                    "\nwhile exploring forest you found a sage who Showed you a path" +
                    "\nto your Destination");
            System.out.println("1. Follow the Path");
            System.out.println("2. Want to Move in Your On Path");
            System.out.println();
            System.out.print("Enter Your Choice :- ");
            userChoice = sc.nextInt();
            while (userChoice > 2){
                System.out.println("Invalid Choice ");
                System.out.println("Enter 1 or 2");
                userChoice = sc.nextInt();
            }
            if (userChoice == 1){
                // chapter 3
                chapterThree();
            }
            else
            {
                System.out.println("You Decided to Move in Your Path and found a powerful demon" +
                        "\nin front of you");
                System.out.println("Note :- You Have a Archer As a Weapon and Have Basic Archery Skills!!!");
                System.out.println("1. Fight with demon with basic archery skills");
                System.out.println("2. Run Away");
                System.out.print("Enter Your Choice :- ");
                userChoice = sc.nextInt();
                while (userChoice > 2){
                    System.out.println("Invalid Choice ");
                    System.out.println("Enter 1 or 2");
                    userChoice = sc.nextInt();
                }
                if (userChoice == 1){
                    System.out.println("You Fought With Demon But He Gave You Damage Of 50" +
                            "\nand you ran away from there");
                    health = health - 50;
                    System.out.println("Your Health Is Now " + health);
                    chapterThree();
                }
                else
                {
                    System.out.println("You Tried to run away from there but then also" +
                            "\nDemon tried to capture you and gave you a damage of 30");
                    health = health - 30;
                    System.out.println("Your Health Is Now " + health);
                    // chapter 3
                    chapterThree();
                }
            }
        }
        else
        {
            // mountain pass
            System.out.println("Awesome!!! You Climbed Rocky Mountain and got your Vantage Point");
            // chapter 3
            chapterThree();
        }

    }
    public static void chapterThree(){
        System.out.println("\nChapter 3: The Hidden Enclave\n");
        System.out.println("Your journey leads you to a hidden enclave of mystical creatures.  " +
                "\nThe leader, an ancient elf named Elara, offers you guidance:\n ");
        System.out.println("1. Learn Magic: Train in the ancient art of magic with Elara's guidance.");
        System.out.println("2. Master Archery: Hone your archery skills under the guidance of Elara's archer companions.\n");
        System.out.println();
        System.out.print("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if(userChoice == 1){
            // fail him in learning magic
            System.out.println("As You Don't Have time Enough time to Learn Magic " +
                    "\nyou Failed In Learning Magic\n");
            // chapter 4
            chapterFour();
        }
        else
        {
            // master the archery skills
            System.out.println("You Have Mastered Your Archery Skill Now You Can Fight" +
                    "\nwith Any Demon without getting any Damage Good Decision!");
            masterArchery = true;
            // chapter 4
            chapterFour();
        }
    }
    public static void chapterFour(){
        System.out.println("\nThe Enchanted Labyrinth\n");
        System.out.println("Elara leads you to an enchanted labyrinth rumored to hold the amulet's key.");
        System.out.println("You face a choice at a fork in the labyrinth:\n");
        System.out.println("1.Left Path: Venture left through a dimly lit corridor.");
        System.out.println("2.Right Path: Choose the right path, where faint whispers seem to beckon.\n");
        System.out.println("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1) {
            leftPath();
            gameOver();
        }
        else
        {
            // chapter 5
            chapterFive();
        }

    }
    public static void leftPath(){
        System.out.println("You choose Left Path:");
        System.out.println("There is no continuation ");
    }
    public static void chapterFive(){
        System.out.println("The right path leads you to a chamber guarded by ancient stone guardians.");
        System.out.println("To proceed, you must answer a riddle:");
        System.out.println("What has keys but can't open locks, and is sometimes a musical note?");
        System.out.println(".....choose a sufficient option.....");
        System.out.println("1.Type your answer.");
        System.out.println("2.Request for Hint.");
        System.out.println("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            leftPathContinued();
        }
        else
        {
            System.out.println("Your hint is :");
            System.out.println("This is something that can be played But it doesn't" +
                    "require balls It has many black and white keys And strings, hammers and some pedals");
            leftPathContinued();
            // chapter 6
            chapterSix();
        }

    }
    public static void leftPathContinued(){
        String OriginalAnswer="piano";
        int i=1,j=3;
        for(;i<=3;i++){
            System.out.println("Please Enter Your Answer.");
            String answer=sc.next();
            String answer1=answer.toLowerCase();
            boolean t=OriginalAnswer.equals(answer1);
            if(t)
            {
                System.out.println("Your answer is correct...");
                // here we call the method which is related to Chapter 6
                chapterSix();
                break;
            }
            if(!t)
            { j--;
                System.out.println("You are wrong, you have only "+j+" chances.");
                if(i==3)
                {
                    System.out.println("You loss the game, beƩer luck next Ɵme.");
                    gameOver();
                    break;
                }
            }
        }
    }
    public static void chapterSix(){
        System.out.println("\nSolving the riddle opens a secret passage. \nBeyond, you discover a treacherous chasm.\n");
        System.out.println("You must choose how to proceed:-\n");
        System.out.println("1. Use the Grappling Hook:- Attempt to swing across the chasm using the grappling hook.");
        System.out.println("2. Search for Another Way:- Search the area for an alternative path.");
        System.out.println("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            conclusion();
        }
        else
        {
            anotherWayBridge();
        }
    }
    public static void anotherWayBridge(){
        System.out.println("You choose to search for another way and find a hidden bridge to cross the chasm.");
        System.out.println("1. Cross the Bridge");
        System.out.println("2. Continue With Grappling Hook");
        System.out.println("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            demon();

        }
        else
        {
            conclusion();
        }

    }
    public static void conclusion(){
        System.out.println("You choose to use the grappling hook and successfully swing across the chasm.");
        System.out.println("You find the Lost Amulet in a hidden chamber beyond the chasm.");
        System.out.println("Its power surges through you, making you a true hero of Eldor.");
        System.out.println("Your journey, choices, and the items you collected have shaped your destiny.");
        System.out.println("The Quest for the Lost Amulet is complete, and you stand as a testament to courage and determination.");
        System.out.println("Will you use the amulet's power for good, or will its influence change you in unexpected ways?");
        System.out.println("Your adventure has ended, but your legacy has just begun.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("Thankyou Dear " + playerName + " for Playing this Game!!!");
    }
    public static void demon(){
        System.out.println("You are Surrounded By 3 Demons!!!");
        System.out.println("1. Fight With Demons");
        System.out.println("2. Give UP :(");
        System.out.println("Enter Your Choice :- ");
        userChoice = sc.nextInt();
        while (userChoice > 2){
            System.out.println("Invalid Choice ");
            System.out.println("Enter 1 or 2");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            fightWithDemons();
        }
        else
        {
            gameOver();
        }
    }
    public static void fightWithDemons(){

        if (masterArchery){
            System.out.println("You Failed to Fight With Demons!!");
            System.out.println("The Demons Gave You Damage Of 100");
            health = health - 100;
            System.out.println("Your Health Is " + health);
            gameOver();
        }
        else
        {
            System.out.println("As You Have Mastery In Archery You Killed all the Demons without");
            System.out.println("getting any Damage");  System.out.println("You find the Lost Amulet in a hidden chamber beyond the chasm.");
            System.out.println("Its power surges through you, making you a true hero of Eldor.");
            System.out.println("Your journey, choices, and the items you collected have shaped your destiny.");
            System.out.println("The Quest for the Lost Amulet is complete, and you stand as a testament to courage and determination.");
            System.out.println("Will you use the amulet's power for good, or will its influence change you in unexpected ways?");
            System.out.println("Your adventure has ended, but your legacy has just begun.");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Thankyou Dear " + playerName + " for Playing this Game!!!");
        }
    }

    public static void gameOver(){
        System.out.println("You Played Well " + playerName);
        System.out.println("Better Luck Next Time ");
    }
    public static void animationText(String text){
        int length = text.length();
        try {
            for (int i = 0; i < length; i++){
                System.out.print(text.charAt(i));
                Thread.sleep(50);
            }
            System.out.println();
        }
        catch (InterruptedException e){
            System.out.println("Exception" + e.getMessage());
        }
    }

    public static void main(String[] args) {
    welcomeScreen();
    chapterOne();
    }
}
