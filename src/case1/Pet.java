package case1;

import org.jetbrains.annotations.Nullable;

public class Pet {
    private final String name;

    @Nullable
    private Hero owner;

    public Pet(String name) {
        this.name = name;
    }

    public void eat(Fruit fruit) {
        System.out.println("寵物吃水果...");

        if (owner != null) {
            owner.setHp(owner.getHp() + 10);
        }
    }

    public String getName() {
        return name;
    }

    public void setOwner(Hero hero) {
        this.owner = hero;
    }

    public Hero getOwner() {
        return owner;
    }
}
