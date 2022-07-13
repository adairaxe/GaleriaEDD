package TDAs;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private NodeList2<E> first;
    private NodeList2<E> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.first.setPrevius(last);
        this.last.setNext(first);
    }

    public NodeList2<E> getFirst() {
        return first;
    }

    public void setFirst(NodeList2<E> first) {
        this.first = first;
    }

    public NodeList2<E> getLast() {
        return last;
    }

    public void setLast(NodeList2<E> last) {
        this.last = last;
    }

    
    
    
    @Override
    public boolean addFirst(E e) {
        
        if (e == null) {
            return false;
        }
        
        NodeList2<E> nuevo = new NodeList2<>(e);
        this.getFirst().setPrevius(nuevo);
        nuevo.setNext(this.getFirst());
        nuevo.setPrevius(this.getLast());
        if (this.isEmpty()) 
            
            this.setLast(nuevo);
        
        this.setFirst(nuevo);
        return true;
    }
    
    
    
    
    @Override
    public boolean addLast(E e) {
        
        if (e == null) {
            return false;
        }
        NodeList2<E> nuevo = new NodeList2<>(e);
        if (this.isEmpty()){     
            
            this.setFirst(nuevo);
            this.first.setNext(nuevo);
            this.first.setPrevius(nuevo);
        }else{
            //Esta linea es necesaria sólo por el primer caso, el last seria null y al null no le hace setNext
            this.getLast().setNext(nuevo);
            this.getLast().setNext(this.first);
        }
        this.setLast(nuevo);
        return true;
    }
    
    
    
    
    @Override
    public E removeFirst() {
        
        NodeList2<E> nodoEliminado = this.getFirst();
        this.first = this.getFirst().getNext();
        this.first.setPrevius(this.last);
        this.last.setNext(this.first);
        return nodoEliminado.getContent();
    }
    
    
    
    
    @Override
    public E removeLast() {
        
        E contRemovido = this.getLast().getContent();
        
        if (this.first == this.last){
            System.out.println("La lista sólo tiene 1 elemento");
            this.first.setContent(null);
            return null; 
            
        } else {
            
            NodeList2<E> nodoTemp = this.first;           
            while (nodoTemp.getNext() != this.last){               
                nodoTemp = nodoTemp.getNext();
            }           
            this.last = nodoTemp;
            this.last.setNext(this.first);
            this.first.setPrevius(this.last);
        }
        return contRemovido;
    }
    
    
    
    
    @Override
    public int size() {
        
        int cont = 1;
        NodeList2<E> t;
        for (t = this.getFirst(); t != this.getLast(); t = t.getNext()) {
            
            cont++;
        }
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }
    
    
    
    
    @Override
    public void clear() {
        
        this.setFirst(null);
    }
    
    
    
    
    @Override
    public void add(int index, E element) {
        
        if (indiceValido(index)){
            
            if (this.isEmpty()){
                
                System.out.println("La lista está vacia");
                this.first.setContent(element);
                this.first.setNext(last); 
                this.last.setContent(element);
                this.last.setNext(first);
            }
            
            if(this.first == this.last){
                this.last.setContent(element);
                this.first.setNext(last);
   
            } 
            
            if(index == 0)
                addFirst(element);
            
            if (index == this.size())
                addLast(element);
            
            else {
                
                try {
                    
                NodeList2<E> actual = darNodoActual(index - 1);
                NodeList2<E> nuevo = new NodeList2<>(element);
                nuevo.setNext(actual.getNext().getNext());
                actual.setNext(nuevo);
                

                } catch (Exception e) {
                    System.out.println("Error atrapado");
                }
            }
    
        } else {
            
            System.out.println("Indice fuera de rango");
        }
    }
    
    
    
    
    @Override
    public E remove(int index) {
        
        if (indiceValido(index)){
            
            if (this.isEmpty()){
                
                System.out.println("La lista está vacia");
                return null;  
                
            }
            
            if(this.first == this.last){
                
                E contRemovido = this.first.getContent();
                this.first = null;
                this.last = null;
                return contRemovido;
                
            } else {
                
                try {
                    
                    NodeList2<E> actual,removido;
                    actual = darNodoActual(index - 1);
                    removido = actual;
                    if(actual == this.last){
                        
                        this.last = actual;
                        actual.setNext(null);
                        
                    } else
                        
                        actual.setNext(actual.getNext().getNext());

                    return removido.getContent();
                    
                } catch (Exception e) {
                    
                    return null;
                    
                }
            }
    
        } else {
            
            System.out.println("Indice fuera de rango");
            return null;           
        }          
    }
    
    
    
    
    @Override
    public E get(int index) {
        
        if (indiceValido(index)){
            
            if (this.isEmpty()){
                
                System.out.println("La lista está vacia");
                return null;  
                
            }
            
            if(this.first == this.last){
                
                E contRemovido = this.first.getContent();
                return contRemovido;
                
            } else { 
                
                try {  
                    
                    NodeList2<E> actual = darNodoActual(index);
                    return actual.getContent();
                
                } catch (Exception e) {
                    
                    return null;
                }
            }
            
        } else {
            
            System.out.println("Indice fuera de rango");
            return null;      
        }               
    }
    
    
    
    
    @Override
    public E set(int index, E element) {
        
        if (indiceValido(index)){
            
            if (this.isEmpty()){
                
                System.out.println("La lista está vacia");
                return null; 
                
            }
            
            if(this.first == this.last){
                
                this.first.setContent(element);
                return element;
                
            } else {
                
                try {
                    
                    darNodoActual(index).setContent(element);
                    return element;
                
                } catch (Exception e) {
                    
                    return null;
                    
                }
            }
        } else {
            
            System.out.println("Indice fuera de rango");
            return null;
            
        }          
    }
    
    
    
    
    @Override
    public String toString() {
        
        String s = "";
        NodeList2<E> t;
        for (t = this.getFirst(); t != null; t = t.getNext()) {
            
            s += t.getContent() + " ";
            
        }
        return s;
    }
    
    
    
    
    @Override
    public NodeList2<E> darNodoActual(int index){
        
        NodeList2<E> actual,futuro;
        actual = this.first;
        futuro = actual.getNext();
        for (int i = 0 ; i < index; i++){
            
            actual = actual.getNext();
            futuro = futuro.getNext();
            
        }
        return actual;
    }
    
    
    @Override
    public boolean indiceValido(int index){
        return index >= 0 && index < this.size();               
    }
    
    
    
    
    @Override
    public Iterator<E> iterator() {

        Iterator<E> it = new Iterator<E>() {
            NodeList2<E> cursor = first;

            @Override
            public boolean hasNext() {
                return cursor.getNext() != null;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                return e;
            }
        };
        return it;
    }


}
