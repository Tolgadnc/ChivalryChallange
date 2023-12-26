import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static Shield shield = new Shield("The shield", "Capable of blocking(block: 3, stamina: -1) and parrying(parry: 2, stamina: -2)", 3, 2);
    private static DoubleHandedSword doubleHandedSword = new DoubleHandedSword("Long sword", "A long sword, capable of stabbing (Damage: 3, Stamina:-3, slicing (Damage: 2, Stamina: -2) and blocking(block: 2 stamina: -2)", 2, 2, 3);
    private static SingleHandedSword singleHandedSword = new SingleHandedSword("Single Handed Sword", "A standard sword, capable of stabbing (Damage: 2, Stamina:-2, slicing (Damage: 1, Stamina: -1) and blocking(block: 1 stamina: -1)", 1, 1, 2);
    private static PreparingArea preparingArea = new PreparingArea(0, "Preparing Area", "A room where the hero can add items to his inventory.");
    private static Hero hero = new Hero(0, 10,10 ,preparingArea);
    private static HealthPotion healthPotion = new HealthPotion("Health Potion", "Increases health by 1", 0, 1);
    private static StaminaPotion staminaPotion = new StaminaPotion("Stamina Potion", "Increases stamina by 1", 1, 0);
    private static CompoundPotion compoundPotion = new CompoundPotion("Compound Potion", "Stamina and health +1", 1, 1);
    private static Arena arena = new Arena("Arena", "*", 4);

    public static void main(String[] args) {

        preparingArea.addItems(shield);
        preparingArea.addItems(doubleHandedSword);
        preparingArea.addItems(singleHandedSword);


        displayIntroStory();
        selectWeapon();
        wantShield();
        wantPotion();
        wantToChangeInventory();
        exitToArena();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a command (type 'help' for available commands):");
            String userCommand = scanner.nextLine();

            switch (userCommand.toLowerCase(Locale.ROOT)) {

                case "stats":
                    hero.displayHealth();
                    hero.displayStamina();
                case "inventory":
                    hero.displayInventory();
                    break;
                case "go north":
                    System.out.println(hero.move(Directions.NORTH));
                    break;
                case "go south":
                    System.out.println(hero.move(Directions.SOUTH));
                    break;
                case "go east":
                    System.out.println(hero.move(Directions.EAST));
                    break;
                case "go west":
                    System.out.println(hero.move(Directions.WEST));
                    break;

                case "help":
                    displayHelp();
                    break;

                default:
                    System.out.println("Invalid command. Type 'help' for available commands.");
                    break;
            }
        }


    }

    private static void displayIntroStory() {
        System.out.println("You open your eyes inside inside a room which has metal tiles and white lighting.\n" +
                "you see some weapons right in front of you. On your left there are some liquids that you have never seen before.\n" +
                "You are thinking to yourself \"Where am I, what am I doing here?\" Then you see the big screen and it suddenly displays a video.\n" +
                "In the video there is a man in wearing a hood, his face is almost unrecognizable. He starts speaking:\n" +
                "\"Congratulations!, you are the one and only, lucky contestant here. Welcome to Chivalry Challenge! The challenge is simple: choose yor weapon, go into the arena and defeat your opponents.\n Unfortunately there is no other way around. Good luck!\"" +
                "Then the screen turns off. You are in a state of confusion, you don't remember how you got there. But the task is clear.");
    }

    public static void selectWeapon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" So Choose your weapon:\n1. Single handed sword\n2. Long sword");

        while (true) {
            System.out.println("Enter 1 or 2 depending on your choice (You can only select the shield if you have a single-handed sword):");
            String userChoiceWeapon = scanner.nextLine();

            switch (userChoiceWeapon) {
                case "1":
                    hero.getItem(singleHandedSword);
                    System.out.println("You added single handed sword to your inventory");

                    return;
                case "2":
                    hero.getItem(doubleHandedSword);
                    System.out.println("You added long sword to your inventory");

                    return;

                default:
                    System.out.println("Please select a valid weapon (1 or 2).");
            }
        }
    }

    public static void wantShield() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to grab a shield?");
        while (true) {
            System.out.println("Enter yes or no");
            String userChoiceShield = scanner.nextLine();
            userChoiceShield = userChoiceShield.toLowerCase(Locale.ROOT);  // Assign the result back to the variable

            switch (userChoiceShield) {
                case "yes":
                    if (hero.getInventory().contains(singleHandedSword)) {
                        hero.getItem(shield);
                        System.out.println("You added a shield to your inventory");

                    } else {
                        System.out.println("You cannot grab a shield without a single-handed sword. Would you like to go back and change?");
                        while (true) {
                            System.out.println("Enter yes or no");
                            String userGoBack = scanner.nextLine();
                            userGoBack = userGoBack.toLowerCase(Locale.ROOT);  // Assign the result back to the variable. We used chatGPT for this line.
                            switch (userGoBack) {
                                case "yes":
                                    hero.removeItems();
                                    selectWeapon();
                                    wantShield();
                                    return;
                                case "no":
                                    return;
                                default:
                                    System.out.println("Please select a valid option (yes or no).");
                            }
                        }
                    }
                    return;
                case "no":
                    return;
                default:
                    System.out.println("Please select a valid option (yes or no).");
            }
        }
    }

    public static void wantPotion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You may choose from three different types of potions.\n" +
                "1. Health Potion (Health +1)\n" +
                "2. Stamina Poiton (Stamina +1)\n" +
                "3. Compound Potion (Health +1, Stamina +1, there is only one compound potion available to you.)\n");
        while (true) {
            System.out.println("Please select 1, 2 or 3");
            String userChoicePotion = scanner.nextLine();

            switch (userChoicePotion) {
                case "1":

                    if (hero.getInventory().size() < 6) {
                        System.out.println("How many?");
                        int userPotionAmount = scanner.nextInt();
                        if (userPotionAmount + hero.getItemsCount() > 6) {
                            System.out.println("You do not have that much space in your inventory, please select a valid amount.");
                            wantPotion();
                        } else {
                            int addCount = 0;
                            while (addCount < userPotionAmount) {
                                hero.getItem(healthPotion);
                                addCount++;
                            }
                            System.out.println(userPotionAmount + " health potion was added to your inventory.");
                            System.out.println("Number of items in your inventory:" + hero.getInventory().size());
                            System.out.println("Would you like to add other potions? Enter yes or no?");
                            while (true) {

                                String userAddMore = scanner.nextLine();
                                userAddMore = userAddMore.toLowerCase(Locale.ROOT);
                                switch (userAddMore) {
                                    case "yes":
                                        wantPotion();
                                        return;
                                    case "no":
                                        return;
                                }
                            }

                        }

                    } else {
                        System.out.print("Number of items in the inventory:");
                        System.out.println(hero.getItemsCount());
                        System.out.println("You do not have enough space in your inventory");
                    }
                        return;
                        case "2":
                            if (hero.getInventory().size() < 6) {
                                System.out.println("How many?");
                                int userPotionAmount = scanner.nextInt();
                                if (userPotionAmount + hero.getItemsCount() > 6) {
                                    System.out.println("You do not have that much space in your inventory");
                                } else {
                                    int addCount = 0;
                                    while (addCount < userPotionAmount) {
                                        hero.getItem(staminaPotion);
                                        addCount++;
                                    }
                                    System.out.println(userPotionAmount + " stamina potion was added to your inventory.");
                                    System.out.println("Number of items in your inventory:" + hero.getInventory().size());
                                    System.out.println("Would you like to add other potions? Enter yes or no?");
                                    while (true) {

                                        String userAddMore = scanner.nextLine();
                                        userAddMore = userAddMore.toLowerCase(Locale.ROOT);
                                        switch (userAddMore) {
                                            case "yes":
                                                wantPotion();
                                                return;
                                            case "no":
                                                return;
                                        }
                                    }
                                }

                            } else {
                                System.out.print("Number of items in the inventory:");
                                System.out.println(hero.getInventory().size());
                                System.out.println("You do not have enough space in your inventory");
                            }
                            return;
                        case "3":
                            if (hero.getInventory().size() < 6) {
                                if (!hero.getInventory().contains(compoundPotion)){
                                    hero.getItem(compoundPotion);
                                    System.out.println("The compound potion was added to your inventory.");
                                    System.out.println("Number of items in your inventory:" + hero.getInventory().size());
                                    System.out.println("Would you like to add other potions? Enter yes or no?");
                                    while (true) {

                                        String userAddMore = scanner.nextLine();
                                        userAddMore = userAddMore.toLowerCase(Locale.ROOT);
                                        switch (userAddMore) {
                                            case "yes":
                                                wantPotion();
                                                return;
                                            case "no":
                                                return;
                                        }
                                    }
                                }else {
                                    System.out.println("Only one compound potion is available to you.");
                                    wantPotion();
                                }



                            } else {
                                System.out.print("Number of items in the inventory:");
                                System.out.println(hero.getInventory().size());
                                System.out.println("You do not have enough space in your inventory");
                            }
                            return;

                        default:
                            System.out.println("Please type a valid number (1,2 or 3");


                    }

            }

        }

        public static void wantToChangeInventory () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you satisfied with your inventory? If not, you can drop every item" +
                    "in your possesion and generate a new build. Do you want this?");

            while (true) {
                System.out.println("Enter yes or no");
                String userChoiceDropEverything = scanner.nextLine();
                userChoiceDropEverything = userChoiceDropEverything.toLowerCase(Locale.ROOT);

                switch (userChoiceDropEverything) {
                    case "yes":
                        hero.removeItems();
                        selectWeapon();
                        wantShield();
                        wantPotion();
                        return;
                    case "no":
                        return;
                }
            }
        }
        public static void exitToArena () {
            System.out.println("Now that you are ready you can step out to the arena. An automatic door opens behind you. You hear the voice of the mysterious man: \"As always, good hunting!\"");
            hero.setCurrentArea(arena);
            System.out.println("Once you step out, the first thing you notice is that this place is freezing cold. There are snowy trees and that is basically all you can see. You can not just stand there, your enemies await you.");
        }

        public static void displayHelp(){
        System.out.println("Available commands:\n 1. Go North\n 2. Go South\n 3. Go East\n 4. Go West\n 5. Inventory\n 6. Attack\n");
        }



}