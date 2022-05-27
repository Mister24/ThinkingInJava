/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package lambdas.java8inaction.chapter4_stream.domain;

import lambdas.java8inaction.chapter4_stream.enums.TypeEnums;

/**
 * 菜品
 *
 * @author mr.24
 * @version Id: Dish, v 1.0 2019-10-26 15:43 Exp $$
 */
public class Dish {
    /**
     * 菜品名称
     */
    private String name;

    /**
     * 是否为素菜
     */
    private boolean vegetarian;

    /**
     * 热量
     */
    private int calories;

    /**
     * 种类
     */
    private TypeEnums type;

    public Dish(String name, boolean vegetarian, int calories, TypeEnums type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>vegetarian</tt>.
     *
     * @return property value of vegetarian
     */
    public boolean isVegetarian() {
        return vegetarian;
    }

    /**
     * Setter method for property <tt>vegetarian</tt>.
     *
     * @param vegetarian value to be assigned to property vegetarian
     */
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    /**
     * Getter method for property <tt>calories</tt>.
     *
     * @return property value of calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Setter method for property <tt>calories</tt>.
     *
     * @param calories value to be assigned to property calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Getter method for property <tt>type</tt>.
     *
     * @return property value of type
     */
    public TypeEnums getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     *
     * @param type value to be assigned to property type
     */
    public void setType(TypeEnums type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
