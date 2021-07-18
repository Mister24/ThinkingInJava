/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.unsafe;

import lombok.*;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author mr.24
 * @version Id: PutIntTest, v 1.0 2021/7/18 4:04 下午 Exp $$
 */
public class PutIntTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = null;
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.getLocalizedMessage();
        }

        Class<Player> playerClass = Player.class;
        Field ageField = playerClass.getField("age");

        Player player = new Player("kobe",24);

        try {
            long offset = unsafe.objectFieldOffset(ageField);
            System.out.println("age偏移量:" + offset);

            System.out.println("修改前:" + unsafe.getInt(player, offset));
            unsafe.putInt(player, offset, 100);
            System.out.println("修改后:" + unsafe.getInt(player, offset));

            System.out.println(player.getName());
            System.out.println(player.getAge());

        } catch (Exception e) {}
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    static
    class Player {
        private String name;
        public int age;
    }

}
