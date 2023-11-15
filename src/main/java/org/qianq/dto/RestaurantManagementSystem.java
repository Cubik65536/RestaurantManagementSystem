package org.qianq.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class RestaurantManagementSystem {
    private static final int MAX_COMBO_COUNT = 20;

    private Combo[] combos;
    private int comboCount = 0;

    public RestaurantManagementSystem() {
        this.combos = new Combo[MAX_COMBO_COUNT];
    }

    public void addCombo(Combo combo) {
        if (comboCount < MAX_COMBO_COUNT) {
            combos[comboCount] = combo;
            comboCount++;
        } else {
            System.out.printf("There are %d combos already. You cannot add more combo.\n", MAX_COMBO_COUNT);
        }
    }

    @Override
    public String toString() {
        String comboString = "[";
        for (Combo combo : combos) {
            if (combo != null) {
                comboString += combo + ", ";
            }
        }
        if (!comboString.equals("[")) {
            comboString = comboString.substring(0, comboString.length() - 2);
        }
        comboString += "]";
        return "RestaurantManagementSystem{" +
                "combos=" + comboString + '}';
    }
}
