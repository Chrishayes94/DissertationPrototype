package com.prototype.pathmyeducation.navigation;

import java.util.Iterator;

/**
 * Created by Chris on 29/01/2017.
 */

public class PointNodeIter<T> implements Iterator<PointNode<T>> {

    enum ProcessStages {
        ProcessParent, ProcessChildCurNode, ProcessChildSubNode
    }

    private PointNode<T> node;
    private ProcessStages doNext;
    private PointNode<T> next;
    private Iterator<PointNode<T>> childrenCurNodeIter;
    private Iterator<PointNode<T>> childrenSubNodeIter;

    public PointNodeIter(PointNode<T> node) {
        this.node = node;
        this.doNext = ProcessStages.ProcessParent;
        this.childrenCurNodeIter = node.children.iterator();
    }

    @Override
    public boolean hasNext() {
        if (this.doNext == ProcessStages.ProcessParent) {
            this.next = this.node;
            this.doNext = ProcessStages.ProcessChildCurNode;
            return true;
        }

        if (this.doNext == ProcessStages.ProcessChildCurNode) {
            if (childrenCurNodeIter.hasNext()) {
                PointNode<T> childDirect = childrenCurNodeIter.next();
                childrenSubNodeIter = childDirect.iterator();
                this.doNext = ProcessStages.ProcessChildSubNode;
                return hasNext();
            } else {
                this.doNext = null;
                return false;
            }
        }

        if (this.doNext == ProcessStages.ProcessChildSubNode) {
            if (childrenSubNodeIter.hasNext()) {
                this.next = childrenSubNodeIter.next();
                return true;
            } else {
                this.next = null;
                this.doNext = ProcessStages.ProcessChildCurNode;
                return hasNext();
            }
        }
        return false;
    }

    @Override
    public PointNode<T> next() {
        return this.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
