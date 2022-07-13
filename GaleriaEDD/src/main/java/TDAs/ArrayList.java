package TDAs;

import java.util.Comparator;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{
    
    private int capacity = 100;
    private E[] elements = null;
    private int effectiveSize = 0;

    public ArrayList() {
        this.elements = (E[]) (new Object[capacity]);
        this.effectiveSize = 0;
    }
    
    private boolean isFull() {
        return elements.length == effectiveSize;
    }
    
    private void addCapacity () {
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }
    
    
    @Override
    public int size() {
        return effectiveSize;
    }
    
    
    public int sizeCapacidad(){
        return capacity;
    }
    

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        this.elements = (E[]) (new Object[capacity]);
        this.effectiveSize = 0;
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < effectiveSize ; i++) {
            if (i == (effectiveSize -1))
                result += elements[i].toString();
            else 
                result += elements[i].toString() + ", ";
        }
        return result;
    }
    
    @Override
    public boolean addFirst(E element) {
        if(element == null){
            return false;
            
        }else if(isEmpty()){
            elements[effectiveSize ++] = element;
            System.out.println("pilas aqui");
            return true;
            
        }else if (capacity == effectiveSize){
            addCapacity();
        }
        
        for(int i = effectiveSize -1 ; i >= 0; i-- ){
            elements[i+1] = elements[i];
        } 
        elements [0] = element;
        effectiveSize++;
        return true;   
    }

    @Override
    public boolean addLast(E e) {
        if(e == null){
            return false;
            
        }else if(isEmpty()){
            elements[effectiveSize ++] = e;
            return true;
            
        }else if (capacity == effectiveSize){
            addCapacity();
        }        
        
        elements [effectiveSize] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public E removeFirst() {             
        E elementoRemovido = elements[0];
        for(int i = 1 ; i < effectiveSize; i++ ){       //Mueve el nulo de la posicion effectiveSize sin embargo funciona
            elements[i-1] = elements[i];                 
        }
        effectiveSize--;       
        return elementoRemovido;
    }

    @Override
    public E removeLast() {
        elements[effectiveSize - 1] = null; 
        effectiveSize--;       
        return elements[effectiveSize - 1];   
    }
    
    @Override
    public void add(int index, E element) {
        if (index >= 0 && index <= effectiveSize){            
            if(elements[index] == null){           
                elements [index] = element;
            
            }else if(isEmpty()){
                elements[effectiveSize ++] = element;
                
            }else if (capacity == effectiveSize){
                addCapacity();
            }            
            for(int i = effectiveSize -1  ; i >= index; i-- ){
                elements[i+1] = elements[i];
            }
            elements [index] = element;
            effectiveSize++;
        }else
            System.out.println("El indice está fuera de rango");
    }

    
    @Override
    public E remove(int index) { 
        if (index >= 0 && index <= effectiveSize){  
            
            E elementoRemovido = elements[index];
            for(int i = index ; i < effectiveSize; i++ ){ 
                
                elements[i] = elements[i+1];
            }
            elements[this.size()] = null;
            effectiveSize--;
            return elementoRemovido;
        }else
            System.out.println("El indice está fuera de rango");
        return null;
    }
       

    @Override
    public E get(int index) {
        if (index >= 0 && index <= effectiveSize){         
            return elements[index];
        }
        return null;
    }
       

    @Override
    public E set(int index, E element) {
        if (index >= 0 && index <= effectiveSize){         
            elements[index] = element;
            return element;
        }
        return null;
    }

    
    public void concat2(ArrayList<E> array2) {
        if(array2 != null){
            
            if(effectiveSize == capacity)
                this.addCapacity();
            
            for (int i = 0 ; i < array2.effectiveSize ; i++){
                this.elements[effectiveSize] = array2.elements[i];
                effectiveSize++;
            }
        } else {
            
            throw new NullPointerException();
        }
       
    }
    
    
    public static boolean separarParImpar(ArrayList<Integer> array2){
        if (array2 == null || array2.isEmpty()){
            System.out.println("FALLA");
            return false;
        }

        ArrayList<Integer> temporalimpar = new ArrayList<>();
        ArrayList<Integer> temporalpar = new ArrayList<>();
        
        int termina = array2.size();
        for (int i = 0; i < termina; i++){
            
            if(array2.get(i) % 2 == 1){
                temporalimpar.addLast(array2.get(i));      
            } else 
                temporalpar.addLast(array2.get(i));  
        }
        array2.clear();
        System.out.println(array2);
        array2.concat2(temporalpar);
        array2.concat2(temporalimpar);
        return true;   
    }
    
    
    public boolean comparadorArray(E e1, E e2, Comparator<E> cmp){
        if(this.isEmpty() || e1==null || e2 == null)
            return false; 
        
        ArrayList listTemp = new ArrayList<E>();
        for(int i = 0; i < this.size() ; i++){
            
            if(cmp.compare(e1, this.elements[i]) <= 0 && cmp.compare(e2, this.elements[i]) >= 0){
                
                listTemp.addLast(this.elements[i]);
                
            }
        }
        this.clear();
        for(E e : this.elements)
            this.addLast(e);
        
        return true;
    }       

    @Override
    public NodeList2<E> darNodoActual(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean indiceValido(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
