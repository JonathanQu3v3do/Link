public class LinkList {
    private Link first;
    private Link last;

    public LinkList() {
        first = null;
        last=null;
        
    }

    public boolean isEmpty()  {
        return (first==null);
    }

    public void insertFirst(double dd) { 
        Link newLink = new Link(dd);
        newLink.setNext(first);
        //newLink.next = first; 
        first = newLink;
    }

    public void insertAfter(double key){
        Link newLink = new Link(key);  
           Link previous = null;  
           Link current = first;  
           while (current != null  ) {  
            // key < current.dData
                previous = current;  
                current=current.getNext();
                //current = current.next;  
           }  
           if (previous == null) {  
                first = newLink;        
           } else {  
                 previous.setNext(newLink);
                //previous.next = newLink;
                last=newLink; 
           }  
           newLink.setNext(current);
           //newLink.next = current; 
    }
    public Link deleteFirst() {
        Link temp=null; 
        if(!isEmpty()){
            temp = first;
            first=first.getNext();
            //first = first.next;
        }
        return temp; 
    }
 
    public Link deleteAfter() {
        Link temp=null; 
        Link current = first;  
        if(!isEmpty()){
           
           while (current.getNext() != last ) {  
            // key < current.dData
                current=current.getNext();
                //current = current.next;  
           }
           temp = last;
            current.setNext(null); 
            last = current;  

        }
        return temp; 
    }
   
    public void displayList() {
        System.out.print("List (first--> ");
        Link current = first;
        
        //Link current = last;
        while(current != null ) {
            current.displayLink(); 
            current=current.getNext();
            //current = current.next; 
        }
        System.out.println("<--last)");
    }

    public Link find(double dato) throws NullPointerException{
        Link current= first;
        while(current.getdData()!=dato){
            if(current.getNext()==null)throw new NullPointerException("No se encontró el dato") ;
            else{
                current=current.getNext();
            }

        }
        return current;
        
        
    }

    public void deleLink(double dato) throws NullPointerException, IsEmptyException {
        int pos= findPosition(dato);
        deleteAt(pos);
    }

    public int findPosition(double value) throws NullPointerException{
        Link current=first;
        int cont=0;
        if(isEmpty())return-1;
        else{
            while(current!= null){
                if(current.getdData()==value)return cont;
                cont++;
                current=current.getNext();
            }
        }
       
        throw new NullPointerException("No se encontró el dato") ;

    }

    public int size(){
        Link current= first;
        int cont=0;
        while(current!=null){
            cont++;
            current=current.getNext();

        }
        return cont;
    }

    public double getElementAt(int index) throws NullPointerException{
        Link current= first;
        int cont=0;
        while(current!=null){
            if(cont==index)return current.getdData();
            cont++;
            current=current.getNext();   
        }
        throw new NullPointerException("limite excedido") ;
    }


    public void deleteAt (int index) throws IsEmptyException, NullPointerException{
        Link current= first;
        if(isEmpty())throw new IsEmptyException("la lista esta vacia");
        if(index==0)first=current.getNext(); 
        for(int i=0; current!=null && i<index-1;){
            current=current.getNext();
        }
        if(current==null|| current.getNext()==null)throw new NullPointerException("No existe el indice");
        Link temp= current.getNext().getNext();//el nuevo siguiente
        current.setNext(temp);

    }
}