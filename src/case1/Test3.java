package case1;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        Hero A = new Hero();
        Hero B = new Hero();
        Hero C = new Hero();

        Guild guild = new Guild("公會", List.of(A));
        System.out.printf("初始成員數量：%d\n", guild.getMembers().size());
        guild.join(B);
        System.out.printf("初始成員數量：%d\n", guild.getMembers().size());
        guild.join(C);
        System.out.printf("初始成員數量：%d\n", guild.getMembers().size());

        try {
            guild.join(A);
        } catch (IllegalStateException e) {
            System.out.println("A 已經在公會中");
        }

        guild.leave(A);
        System.out.printf("A 離去，成員數量：%d\n", guild.getMembers().size());
        guild.leave(B);
        System.out.printf("B 離去，成員數量：%d\n", guild.getMembers().size());

        try {
            guild.leave(C);
        } catch (Exception e) {
            System.out.println("唯一成員 C 不能離開");
        }

        try {
            guild.leave(A);
        } catch (Exception e) {
            System.out.println("只有公會成員才能離開");
        }
    }
}
