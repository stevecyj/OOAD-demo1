package case1;

public class Test2 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Pet cat = new Pet("Kitty");
        hero.setPet(cat);

        System.out.printf("Hero 目前血量： %d\n", hero.getHp());
        assert hero.getPet() != null;
        System.out.printf("Hero's 寵物名稱： %s\n", hero.getPet().getName());

        for (int i = 0; i < 5; i++) {
            cat.eat(new Fruit());
        }

        hero.removePet();

        for (int i = 0; i < 5; i++) {
            cat.eat(new Fruit());
        }
    }
}
