package LESSON4.LESSON4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class TriangleAreaAllTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Начинаем тест функции для расчёта площади треугольника по трём сторонам");
        System.out.println();
    }


    @Test
    void assertAllTests (){
        Assertions.assertAll(
                () -> Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{-1,1,1})),
                () -> Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,-1,1})),
                () -> Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,1,-1})),
                () -> Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{-2_147_483_648,2_147_483_647,2_147_483_647})),
                () -> Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{2_147_483_647,-2_147_483_648,2_147_483_647})),
                () -> Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_647,-2_147_483_648})),
                () -> Assertions.assertThrows(TriangleArea.ZeroSide.class, ()-> TriangleArea.TriangleArea(new int[]{0,1,1})),
                () -> Assertions.assertThrows(TriangleArea.ZeroSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,0,1})),
                () -> Assertions.assertThrows(TriangleArea.ZeroSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,1,0})),
                () -> Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{3,1,1})),
                () -> Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,3,1})),
                () -> Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,1,3})),
                () -> Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{2_147_483_647,1_073_741_823,1_073_741_823})),
                () -> Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1_073_741_823,2_147_483_647,1_073_741_823})),
                () -> Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1_073_741_823,1_073_741_823,2_147_483_647})),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2,1,1}), 0.0),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{1,2,1}), 0.0),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{1,1,2}), 0.0),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_647,1_073_741_824,1_073_741_823}), 0.0),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{1_073_741_824,2_147_483_647,1_073_741_823}), 0.0),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_647,1_073_741_824,1_073_741_823}), 0.0),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{1,1,1}), 0.4330127018922193),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_647,2_147_483_647}), 1.99691862125803904E18),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{1,2,2}), 0.9682458365518543),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2,1,2}), 0.9682458365518543),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2,2,1}), 0.9682458365518543),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_646,2_147_483_647,2_147_483_647}), 1.99691862063811379E18),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_646,2_147_483_647}), 1.99691862063811379E18),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_647,2_147_483_646}), 1.99691862063811379E18),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2,3,4}), 2.9047375096555625),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{4,2,3}), 2.9047375096555625),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{3,4,2}), 2.9047375096555625),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_645,2_147_483_646,2_147_483_647}), 1.99691861939826355E18),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_645,2_147_483_646}), 1.99691861939826355E18),
                () -> Assertions.assertEquals(TriangleArea.TriangleArea(new int[]{2_147_483_646,2_147_483_647,2_147_483_645}), 1.99691861939826355E18));
    }

    @AfterAll
    static void afterAll(){
        System.out.println();
        System.out.println("Завершился тест функции для расчёта площади треугольника по трём сторонам");
    }
}