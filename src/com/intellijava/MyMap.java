package com.intellijava;

import java.util.ArrayList;

class MyMap {
    private ArrayList<HashNode> hashNodeList = new ArrayList<>();

    private int bucketCount = 10;
    private int size = 0;

    MyMap() {
        for (int i = 0; i < bucketCount; i++)
            hashNodeList.add(new HashNode());
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % bucketCount;
    }

    public Integer getValue(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key should not be null");
        }

        int index = getBucketIndex(key);
        HashNode firstHashNode = hashNodeList.get(index);
        do {
            if (key.equals(firstHashNode.key)) {
                return firstHashNode.value;
            } else
                firstHashNode = firstHashNode.next;
        } while (firstHashNode != null);
        return null;
    }

    private HashNode getLastHashNode(int index) {

//        HashNode lastHashNode = null;
//        if (hashNodeList.get(index).key != null) {
//            lastHashNode = hashNodeList.get(index);
//            while (lastHashNode.next != null)
//                lastHashNode = lastHashNode.next;
//        }
//        return lastHashNode;

        HashNode bucketHead = hashNodeList.get(index);
        if (bucketHead.key == null) {
            return null;
        } else {
            HashNode currentNode = bucketHead;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }

    }

    int getSize() {
        return size;
    }

    void add(String key, int value) {
        int index = getBucketIndex(key);
        HashNode newHashNode = new HashNode(key, value);
        HashNode lastHashNode = getLastHashNode(index);
        if (lastHashNode == null) {
            size++;
            hashNodeList.set(index, newHashNode);
        } else {
            lastHashNode.next = newHashNode;
        }
    }

    Integer remove(String key) {
        int index = getBucketIndex(key);
        HashNode aHashNode;
        aHashNode = hashNodeList.get(index);
        if (aHashNode.key != null && aHashNode.next == null) {
            //1 nodes
            if (aHashNode.key.equals(key)) {
                HashNode nullHashNode = new HashNode();
                hashNodeList.set(index, nullHashNode);
                size--;
                return null;
            } else
                return null;
        } else {
            //2 nodes or more
            if (aHashNode.key.equals(key)) {
                //the head is the one to find
                hashNodeList.set(index, aHashNode.next);
                return aHashNode.next.value;
            } else {
                while (aHashNode.next.next != null) {
                    if (aHashNode.next.key.equals(key)) {
                        aHashNode.next = aHashNode.next.next;
                        return aHashNode.next.value;
                    } else
                        aHashNode = aHashNode.next;

                }
                if (aHashNode.next.key.equals(key))
                    aHashNode.next = null;


            } //3 nodes or more finished
        }

        return null;
    }


    boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }


}
