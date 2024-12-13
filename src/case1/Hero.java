package case1;

public class Hero {
    private int level = 1;
    private int totalExp = 0;
    private int hp = 100;

    public Hero() {
    }

    public Hero(int level, int totalExp, int hp) {
        this.level = level; // TODO
        setTotalExp(totalExp);
        setHp(hp);
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

    private void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("hp must be greater than or equal to 0");
        }
        this.hp = hp;
    }

    public void gainExp(int exp, LevelSheet levelSheet) {
//        TODO
        if (exp < 0) {
            throw new IllegalArgumentException("exp must be greater than or equal to 0");
        }

        int currentLevel = level;
        setTotalExp(totalExp + exp);
        setLevel(levelSheet.queryLevel(totalExp));

        System.out.printf("英雄目前等級 %d，獲得 %d EXP，最新總共經驗值 %d，最新等級為 %d。", currentLevel, exp, totalExp, level);
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
}
