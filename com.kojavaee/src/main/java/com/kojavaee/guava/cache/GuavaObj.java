package com.kojavaee.guava.cache;

import com.google.common.base.Objects;

public class GuavaObj {
    public static void main(String[] args) {
        boolean b1 = Objects.equal("a", "a"); // returns true
        boolean b2 = Objects.equal(null, "a"); // returns false
        boolean b3 = Objects.equal("a", null); // returns false
        boolean b4 = Objects.equal(null, null); // returns true
        
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        
        String str1 = Objects.toStringHelper("MyObject").add("x", 1).toString();
        System.out.println(str1);
    }
    

    class Person implements Comparable<Person> {
      private String lastName;
      private String firstName;
      private int zipCode;
     
      public int compareTo(Person other) {
        int cmp = lastName.compareTo(other.lastName);
        if (cmp != 0) {
          return cmp;
        }
        cmp = firstName.compareTo(other.firstName);
        if (cmp != 0) {
          return cmp;
        }
        return Integer.compare(zipCode, other.zipCode);
      }
    }
    /*
    这部分代码太琐碎了，因此很容易搞乱，也很难调试。我们应该能把这种代码变得更优雅，为此，Guava提供了ComparisonChain。
    ComparisonChain执行一种懒比较：它执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略。
    查看源代码打印帮助
    public int compareTo(Foo that) {
        return ComparisonChain.start()
                .compare(this.aString, that.aString)
                .compare(this.anInt, that.anInt)
                .compare(this.anEnum, that.anEnum, Ordering.natural().nullsLast())
                .result();
    }
     */

}
