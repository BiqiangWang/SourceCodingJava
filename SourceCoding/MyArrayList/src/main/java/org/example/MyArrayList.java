package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title MyArrayList
 * @description
 * @create 2023/10/28 20:24
 */
public class MyArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable {

    private static final int DEFAULT_CAPACITY = 10;

    transient Object[] elementData;

    /**
     * 这里定义两个空实例数组，主要是为了区分当添加第一个元素时要膨胀的大小
     */

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    private int size;

    /**
     * 定义三种初始化方法， 指定长度初始化， 空数组初始化， 指定内容初始化
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public MyArrayList() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    /**
     * 这一函数还存在问题尚未解决
     */
    public MyArrayList(@NotNull Collection<? extends E> c) {
        // TODO: debug
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            elementData = EMPTY_ELEMENT_DATA;
        }
    }

    /**
     * 很容易意识到一个问题：当定义了过大的数组后，且确定不会增加长度的情况下，需要进行裁剪以节约空间
     */
    public void trimToSize() {
        if (size < elementData.length) {
            elementData = size == 0 ? EMPTY_ELEMENT_DATA : Arrays.copyOf(elementData, size);
        }
    }

    public void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > elementData.length && !(elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) && requiredCapacity < DEFAULT_CAPACITY) {
            grow(requiredCapacity);
        }
    }

    public Object[] grow(int requiredCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            // 这里表明ArrayList的增长并不是完全增长值要求的值，而是 max(增长值,当前长度的一半)
            int newCapacity = MyArraySupport.newLength(oldCapacity, requiredCapacity - oldCapacity, oldCapacity >> 1);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, requiredCapacity)];
        }
    }

    public Object[] grow() {
        return grow(size + 1);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        return IndexOfRange(o, 0, size);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    /**
     * 添加元素
     */
    public boolean add(E e) {
        elementData = grow();
        elementData[size++] = e;
        return true;
    }



    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public int IndexOfRange(Object o, int start, int end) {
        Object[] ed = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (ed[i] == null) return i;
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(ed[i])) return i;
            }
        }
        return -1;
    }

    public Object clone() {
        try {
            MyArrayList<?> clone = (MyArrayList<?>) super.clone();
            clone.elementData = Arrays.copyOf(elementData, size);
            return clone;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new AssertionError();
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
}
