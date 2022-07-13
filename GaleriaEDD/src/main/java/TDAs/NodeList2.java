/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author USER
 */
public class NodeList2 <E> {
    
    private E content;
    private NodeList2<E> next;
    private NodeList2<E> previus;

    public NodeList2(E content) {
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public NodeList2<E> getNext() {
        return next;
    }

    public void setNext(NodeList2<E> next) {
        this.next = next;
    }

    public NodeList2<E> getPrevius() {
        return previus;
    }

    public void setPrevius(NodeList2<E> previus) {
        this.previus = previus;
    }
    
    


    
    
    
}
