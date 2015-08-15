package com.kojavaee.guava.cache;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

public class GuavaAPI {
    public static void main(String[] args) {
        //[1,2,3]拼接成1 2 3
        String outputStr = Joiner.on(' ').join(1,2,3);
        
        String outputStr1 = Joiner.on(' ').skipNulls().join(1,null,3);
        String outputStr2 = Joiner.on(' ').useForNull("none").join(1,null,3);
        String outputStr3 = Joiner.on("#").withKeyValueSeparator("=").join(ImmutableMap.of(1,2,3,4));
        
        System.out.println(outputStr);
        System.out.println(outputStr1);
        System.out.println(outputStr2);
        System.out.println(outputStr3);
    }
    
    /*
     * 第一个技巧是使用 if 和 while 来实现了比较优雅的分隔符拼接，避免了在末尾插入分隔符的尴尬；
     * 第二个技巧是使用了自定义的 toString 方法而不是 Object#toString 来将对象序列化成字符串，为后续的各种空指针保护开了方便之门。
     * 
    public <A extends Appendable> A appendTo(A appendable, Iterator<?> parts) throws IOException {
        checkNotNull(appendable);
        if (parts.hasNext()) {
          appendable.append(toString(parts.next()));
          while (parts.hasNext()) {
            appendable.append(separator);
            appendable.append(toString(parts.next()));
          }
        }
        return appendable;
      }
     */              
}
