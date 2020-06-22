package com.nnww.test.java8.option;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 业务场景(op代表Optional对象)	正确用法示例	错误用法示例
 * 如果op中的对象不为空，则进行操作	op.ifPresent(o -> o.setUserName("小明"));
 * if(op.isPresent()){
 * <p>
 *         op.get().setUserName("小明"));
 * <p>
 * }
 * <p>
 * 如果op中的对象不为空，则返回它；否则返回另一个值	op.orElse(initUser);
 * if(op.isPresent()){
 * <p>
 *        return op.get();
 * <p>
 * }
 * <p>
 * else{
 * <p>
 *         return initUser;
 * <p>
 * }
 * <p>
 * 如果op中的对象不为空，则返回它；否则进行操作	op.orElseGet(() -> new User(0, "小明"));	if(op.isPresent()){
 *        return op.get();
 * <p>
 * }
 * <p>
 * else{
 * <p>
 *         return new User(0, "小明");
 * <p>
 * }
 * <p>
 * 如果op中的对象不为空，则返回它；否则抛出异常
 * op.orElseThrow(IllegalArgumentException::new);
 * <p>
 * if(op.isPresent()){
 *        return op.get();
 * <p>
 * }
 * <p>
 * else{
 * <p>
 *         throw new IllegalArgumentException()
 * <p>
 * }
 * ————————————————
 * 原文链接：https://blog.csdn.net/jui121314/article/details/82683249
 */
public class Test1 {

    public User getUser(String name) {
        return new User(name);
    }

    /**
     * get() 如果容器内有该对象则返回, 没有抛异常 (NoSuchElementException)
     */
    @Test
    public void test1() {
        User user = new User("option");
        Optional<User> optional = Optional.ofNullable(user);
        User user1 = optional.get();
    }

    /**
     * orElse() 返回存在对象，否则返回其他对象
     */
    @Test
    public void test2() {
        User user = null;
        Optional<User> optional = Optional.ofNullable(user);
        User user2 = optional.orElse(new Test1().getUser("name"));
        System.out.println(user2.getUsername());
    }

    /**
     * orElseGet() 返回值（如果存在），否则调用 other并返回该调用的结果。
     */
    @Test
    public void test3() {
        User user = null;
        Optional<User> optional = Optional.ofNullable(user);
        User user2 = optional.orElseGet(() -> new Test1().getUser("name"));
        System.out.println(user2.getUsername());
    }

    /**
     * ofNullable 返回包含的值（如果存在），否则抛出由提供的供应商创建的异常。
     */
    @Test
    public void test4() {
        User user = null;
        Optional<User> optional = Optional.ofNullable(user);
        User user2 = optional.orElseThrow(() -> new RuntimeException("出错"));
        System.out.println(user2.getUsername());
    }

    /**
     * map() 如果存在一个值，则应用提供的映射函数，如果结果不为空，则返回一个 Optional结果的 Optional 。
     */
    @Test
    public void test5() {
        User user = new User("name");
        Integer integer = Optional.ofNullable(user)
                .map(User::getUsername)
                .map(String::length)
                .orElse(0);
        System.out.println(integer);
    }

    /**
     * filter() 如果一个值存在，并且该值给定的谓词相匹配时，返回一个 Optional描述的值，否则返回一个空的 Optional 。
     */
    @Test
    public void test6() {
        User user = new User("name");
        Optional<User> optional = Optional.ofNullable(user);
        User haha = optional.filter(u -> u.getUsername().equals("haha"))
                .orElseThrow(RuntimeException::new);
        System.out.println(haha);
    }




    static class User {

        public User(String username) {
            this.username = username;
        }

        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
