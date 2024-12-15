package case1;

import java.util.*;

import static java.util.Collections.*;

public class Guild {
    private final String name;
    private final Set<Hero> members;

    public Guild(String name, List<Hero> members) {
        this.name = name;

        if (members.size() < 1 || members.size() > 10) {
            throw new IllegalArgumentException("公會成員數需介於 1 到 10 人之間");
        }

        for (Hero hero : members) {
            hero.addGuild(this);
        }

        this.members = new HashSet<>(members);
    }

    public String getName() {
        return name;
    }

    public Collection<Hero> getMembers() {
        return unmodifiableSet(members);
    }

    public void join(Hero member) {
        if (members.size() == 10) {
            throw new IllegalStateException("成員已滿 10 人");
        }

        if (members.contains(member)) {
            throw new IllegalStateException("英雄已經在公會中");
        }

        members.add(member);
        member.addGuild(this);
    }

    public void leave(Hero member) {
        if (members.size() == 1) {
            throw new IllegalStateException("公會至少要有一名成員");
        }

        if (!members.contains(member)) {
            throw new IllegalStateException("英雄不在公會中");
        }

        members.remove(member);
        member.removeGuild(this);
    }
}
