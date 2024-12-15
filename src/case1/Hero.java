package case1;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class Hero {
    private int level = 1;
    private int totalExp = 0;
    private int hp = 100;
    private List<Guild> guilds=new ArrayList<>();

    @Nullable
    private Pet pet;

    public Hero() {
    }

    public Hero(int level, int totalExp, int hp) {
        this.level = level; // TODO
        setTotalExp(totalExp);
        setHp(hp);
    }

    public void setPet(Pet pet) {
        if (this.pet != null) {
            this.pet.setOwner(null); // 棄養
        }
        this.pet = pet;

        pet.setOwner(this); // 領養
    }

    public void removePet() {
        if (this.pet != null) {
            this.pet.setOwner(null); // 棄養
        }
        this.pet = null;
    }

    private void setLevel(int level) {
        if (level <= 0) {
            throw new IllegalArgumentException("level must be greater than or equal to 1");
        }
        this.level = level;
    }

    private void setTotalExp(int totalExp) {
        if (totalExp < 0) {
            throw new IllegalArgumentException("totalExp must be greater than or equal to 0");
        }
        this.totalExp = totalExp;
    }

    void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("hp must be greater than or equal to 0");
        }
        this.hp = hp;
        System.out.printf("英雄目前 HP 為 %d。 \n", hp);
    }

    public void gainExp(int exp, LevelSheet levelSheet) {
//        TODO
        if (exp < 0) {
            throw new IllegalArgumentException("exp must be greater than or equal to 0");
        }

        int currentLevel = level;
        setTotalExp(totalExp + exp);
        setLevel(levelSheet.queryLevel(totalExp));

        System.out.printf("英雄目前等級 %d，獲得 %d EXP，最新總共經驗值 %d，最新等級為 %d。 \n", currentLevel, exp, totalExp, level);
    }

    public @Nullable Pet getPet() {
        return pet;
    }

    public int getLevel() {
        return level;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public int getHp() {
        return hp;
    }

    public void addGuild(Guild guild) {
        guilds.add(guild);
    }

    public void removeGuild(Guild guild) {
        guilds.remove(guild);
    }

    public List<Guild> getGuilds() {
        return unmodifiableList(guilds);
    }
}
