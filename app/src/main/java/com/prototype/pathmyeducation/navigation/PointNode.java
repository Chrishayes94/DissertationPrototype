package com.prototype.pathmyeducation.navigation;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * PointNode or Point-Of-Interest Object is used to refer to various locations located
 * around the campus. These will hold information regarding: location, description and image.
 * Created by Chris on 28/01/2017.
 */
public class PointNode<T> implements Iterable<PointNode<T>> {

    // Tree-Node Information
    public T data;
    public PointNode<T> parent;
    public List<PointNode<T>> children;
    public List<PointNode<T>> elementsIndex;


    public PointNode(T child) {
        this.data = child;
        this.children = new LinkedList<PointNode<T>>();
        this.elementsIndex = new LinkedList<PointNode<T>>();
        this.elementsIndex.add(this);
    }

    public PointNode<T> add(T child) {
        PointNode<T> childNode = new PointNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    private void register(PointNode<T> node) {
        elementsIndex.add(node);
        if (parent != null) parent.register(node);
    }

    public PointNode<T> find(Comparable<T> cmp) {
        for (PointNode<T> element : this.elementsIndex) {
            T elData = element.data;
            if (cmp.compareTo(elData) == 0) return element;
        }
        return null;
    }

    @Override
    public Iterator<PointNode<T>> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "[data is emtpy]";
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public int getFloor() {
        if (this.isRoot()) return 0;
        else return  parent.getFloor() + 1;
    }

}
