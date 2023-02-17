public class app {

    public static void main(String[] args) throws NullPointerException {
       LinkList list = new LinkList();
       try{
       list.insertAfter(50.5);
       list.insertAfter(44.2);
       list.insertAfter(7.2);
       list.insertAfter(6.2);

       list.deleLink(20.5);
       //deleteindex
          //list.deleteAt(5);
       //list.deleteAfter();
       list.displayList();

       //find
       Link temp= list.find(44.2);
       System.out.println("value: "+temp.getdData());

       //posicion
       double value=44.2;
       System.out.println("position of: "+ value +" is: " +list.findPosition(value));

      
       list.displayList();

       //size
       System.out.println("size of LinkList is: "+ list.size());
       //getElement
       int index=5;
       System.out.println("value of "+ index + " is: "+ list.getElementAt(index));
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
   }
 
 }

}