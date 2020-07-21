package com.tutorial;

// Player
class Player{
    String name;
    double health;
    Weapon weapon;
    // tipe data Weapon harus object turunan dari class Weapon
    Armor armor;
    // tipe data Armor harus object turunan dari class Armor
    
    Player(String name, double health){
        this.name = name;
        this.health = health;
        
    }
    
    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name+" attacking "+opponent.name+" with power "+attackPower);
        opponent.defence(attackPower);
    }

    void defence(Double attackPower){
        double damage;
        if(this.armor.defencePower < attackPower){
            damage = attackPower - this.armor.defencePower;
        }else{
            damage = 0;
        }
        this.health -= damage;
        System.out.println(this.name+" gets damage "+damage);
    }

    void equipWeapon(Weapon weapon){
        // tipe data Weapon harus object turunan dari class Weapon
        this.weapon = weapon;
    }

    void equipArmor(Armor armor){
        // tipe data Armor harus object turunan dari class Armor
        this.armor = armor;
    }

    void display(){
        System.out.println("\nPlayer: "+this.name);
        System.out.println("Health: "+this.health+" Hp");
        this.weapon.display();
        this.armor.display();
    }
}

// Weapon
class Weapon{
    String name;
    double attackPower;

    //Constructor
    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }

    void display(){
        System.out.println("Weapon: "+this.name+", attack: "+this.attackPower);
    }
}

// Armor
class Armor{
    String name;
    double defencePower;

    //Constructor
    Armor(String name, double defencePower){
        this.name = name;
        this.defencePower = defencePower;
    }

    void display(){
        System.out.println("Armor: "+this.name+", defence: "+this.defencePower);
    }
}

public class App {
    public static void main(String[] args){
        //membuat object player
        Player player1 = new Player("Ucup",100);
        Player player2 = new Player("Otong",50);
        
        //membuat object weapon
        Weapon pedang = new Weapon("Pedang",15);
        Weapon ketapel = new Weapon("Ketapel",1);

        //membuat object armor
        Armor bajuBesi = new Armor("Baju Besi",10);
        Armor kaos = new Armor("Kaos",0);
        
        //memanggil method
        player1.equipWeapon(pedang);
        player1.equipArmor(bajuBesi);
        player1.display();
        
        //memanggil method
        player2.equipWeapon(ketapel);
        player2.equipArmor(kaos);
        player2.display();

        System.out.println("\nPERTEMPURAN");
        System.out.println("\nPhase - 1");
        player1.attack(player2);
        player1.display();
        player2.display();
        System.out.println("\nPhase - 2");
        player2.attack(player1);
        player1.display();
        player2.display();
    }
}