package com.company.link;

/**
 * 单链表
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;               // newLink --> old first
        first = newLink;                    // first --> newLink
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;            // didn't finbd it
            } else {
                previous = current;     // go to next link
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;            //return deleted link
    }

    public void displayList() {
        System.out.println("List (first --> last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
