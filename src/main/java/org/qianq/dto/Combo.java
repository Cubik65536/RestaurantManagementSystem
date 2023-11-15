package org.qianq.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Combo {
    private static final int MAX_DISH_COUNT = 2;
    private static final int MAX_BEVERAGE_COUNT = 2;
    private static int nextId = 1;

    private String id;
    private String name;
    private double price;
    private Dish[] dishes;
    private Beverage[] beverages;

    public Combo(String name) {
        this.id = String.format("C%03d", nextId++);
        this.name = name;
        this.dishes = new Dish[MAX_DISH_COUNT];
        this.beverages = new Beverage[MAX_BEVERAGE_COUNT];
    }

    public void addDish(Dish dish) {
        if (dishes[0] == null) {
            dishes[0] = dish;
            calcPrice();
        } else if (dishes[1] == null) {
            dishes[1] = dish;
            calcPrice();
        } else {
            System.out.printf("There are %d dishes already. You cannot add more dish.\n", MAX_DISH_COUNT);
        }
    }

    public void addBeverage(Beverage beverage) {
        if (beverages[0] == null) {
            beverages[0] = beverage;
            calcPrice();
        } else if (beverages[1] == null) {
            beverages[1] = beverage;
            calcPrice();
        } else {
            System.out.printf("There are %d beverages already. You cannot add more beverage.\n", MAX_BEVERAGE_COUNT);
        }
    }

    private void calcPrice() {
        double price = 0;

        for (Dish dish: dishes) {
            if (dish != null) {
                price += dish.getPrice();
            }
        }

        for (Beverage beverage: beverages) {
            if (beverage != null) {
                price += beverage.getPrice();
            }
        }

        double discountRatio = 0.8;
        this.price = price * discountRatio;
    }
}
