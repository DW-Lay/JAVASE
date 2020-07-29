package com.imooc.reflection;


/**
 * @author Lincoln
 * @classname Test01
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2020/7/9 10:07
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是"+person.getName());

        //方法一 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        System.out.println(c1);
        //方法二 通过forName获得
        Class<?> c2 = Class.forName("com.imooc.reflection.Student");
        System.out.println(c2.hashCode());
        // 方法三 通过类名获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

    }


}

class  Person{
    private String name;
    private int age;
    private int score;

    public Person() {
    }

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.setName("学生");
    }
}

class Teacher extends Person{
    public Teacher() {
        this.setName("老师");
    }
}