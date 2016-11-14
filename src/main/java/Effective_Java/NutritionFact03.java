package Effective_Java;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/14.
 *         P12 泛型的实现方式
 */
public class NutritionFact03 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class NutritionFact03Builder implements Builder<NutritionFact03> {

        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public NutritionFact03Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionFact03Builder calories(int val) {
            calories = val;
            return this;
        }

        public NutritionFact03Builder fat(int val) {
            fat = val;
            return this;
        }

        public NutritionFact03Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFact03Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        @Override
        public NutritionFact03 build() {
            return new NutritionFact03(this);
        }
    }

    private NutritionFact03(NutritionFact03Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
