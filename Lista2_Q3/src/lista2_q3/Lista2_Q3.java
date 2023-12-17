package lista2_q3;

public class Lista2_Q3 {

    /*
    O sistema pede a implementação de um padrão de projeto que consiga adicionar poderes ao ataque do personagem em tempo de execução, 
    obtendo a flexibilidade de extensão da aplicação sem modificar o código. 
    Por conta das palavras-chave tempo de execução, logo pensei no Decorator, 
    que foi padrão utilizado para implementar o problema proposto.
    
    Ao final, o código ficou da seguinte forma: um jogador possui um ataque básico com 10 de dano, 
    mas é possível escolher um ou mais poderes para complementar o seu ataque: fogo, água e grama. 
    Cada poder acrescenta, respectivamente, 7, 4 e 3 de dado ao ataque base. 
    Então, antes de usar o ataque de fato, o jogador precisa criar a combinação de ataques desejada 
    (ou escolher usar apenas o ataque base), selecionar o ataque desejado e então realizar o ataque com o método usePower().

    */
    
    //Interface Component 
    public static interface ComponentAttack {
        public int getPower();
        public void attack();
    }

    //Classe Concreta 
    public static class BasicAttack implements ComponentAttack {
        private int power;
        public BasicAttack() {
            this.power = 10;
        }
        @Override
        public void attack() {
            System.out.println("\nPlayer attacks!");
        }
        @Override
        public int getPower() {
            return power;
        }
    }

    //Interface Decorator
    public static interface Power extends ComponentAttack {

    }

    //Classes Concretas - poder 1
    public static class WaterPower implements Power {
        private ComponentAttack attack;
        public WaterPower(ComponentAttack attack) {
            this.attack = attack;
        }
        
        @Override
        public void attack() {
            attack.attack();
            System.out.println("Uses water power!");
        }
        @Override
        public int getPower() {
            return attack.getPower() + 4;
        }

    }

    //Poder 2
    public static class FirePower implements Power {
        private ComponentAttack attack;
        public FirePower(ComponentAttack attack) {
            this.attack = attack;
        }
        @Override
        public void attack() {
            attack.attack();
            System.out.println("Uses fire power!");
        }
        @Override
        public int getPower() {
            return attack.getPower() + 7;
        }

    }

    
    //Poder 3
    public static class GrassPower implements Power {
        private ComponentAttack attack;
        public GrassPower(ComponentAttack attack) {
            this.attack = attack;
        }
        @Override
        public void attack() {
            attack.attack();
            System.out.println("Uses grass power!");
        }
        @Override
        public int getPower() {
            return attack.getPower() + 3;
        }

    }
    
    public static class Player {
        private ComponentAttack attack;  // Ataque básico do jogador

        public Player(ComponentAttack attack) {
            this.attack = attack;
        }

        public void setAttack(ComponentAttack attack) {
            this.attack = attack;
        }

        public ComponentAttack getAttack() {
            return attack;
        }

        // Executar o ataque com os poderes
        public void usePowers() {
            attack.attack();
            System.out.println("Total damage: " + attack.getPower());
        }
    }

    public static void main(String[] args) {
        ComponentAttack basicAttack = new BasicAttack();
        Player player = new Player(basicAttack);

        //Decorando o ataque
        Power allPowers = new GrassPower(new WaterPower(new FirePower(basicAttack)));
        Power grassWater = new GrassPower(new WaterPower(basicAttack));
        Power grassFire = new GrassPower(new FirePower(basicAttack));
        Power waterFire = new WaterPower(new FirePower(basicAttack));
        Power water = new WaterPower(basicAttack);
        Power fire = new FirePower(basicAttack);
        Power grass = new GrassPower(basicAttack);
        
        //ataque básico
        player.setAttack(basicAttack);
        player.usePowers();
        
        //usando combinação de ataques
        player.setAttack(allPowers);
        player.usePowers();
        
        player.setAttack(grassWater);
        player.usePowers();
        
        player.setAttack(grassFire);
        player.usePowers();
        
        player.setAttack(waterFire);
        player.usePowers();
        
        player.setAttack(water);
        player.usePowers();
        
        player.setAttack(fire);
        player.usePowers();
        
        player.setAttack(grass);
        player.usePowers();
        
       
        
    }

}
