package Lista;
public class Lista<T>{
    private Object[] list;
    private int count;

    public Lista() {
        list = new Object[1];
        count = 0;
    }

    public void add(T element) {
        
        if (count >= list.length) { 
            
            Object[] newList = new Object[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);//metodo copiare il contenuto di un array in un altro array.
            list = newList;
        }

        list[count] = element;
        count++;
    }


    public void remove(int index,T element){
        if (index>=0 && index<list.length){
            if(list[index]!=null && list[index].equals(element)){
                list[index]=null; 
                count--;
            }
            else{
                System.err.println("l'elemento non corrisponde");
            }

                       
        }
       
    }

    public void remove(T element){
        for (int index = 0; index < list.length; index++) {
            if (list[index]!=null && list[index].equals(element)) {
                list[index]=null;   
                count--;
            }
            else{
                System.err.println("l'elemento non corrisponde");
            }
        }
       
    }

    public void clear(){
        for (int i = 0; i< list.length; i++) {
            list[i]=null;
            
        }
        count = 0;
    }
    public int size(){
        return list.length;
    }

    public Object get(int index){
        return list[index];
    }


    public void PrintAllArray(){
        for (Object lista : list) {
            System.out.println(lista);
        }      

    }

    public void isEmpyLista(){
        if (list==null) {
            System.out.println(true); 
        }
        else{
            System.out.println(false); 
        }

    }

    public void isEmpyCella(int index){
        if (list[index]==null) {
            System.out.println(true); 
        }
        else{
            System.out.println(false); 
        }

    }

    public void  contains(T element){
        for (int index = 0; index < list.length; index++) {
            if (list!=null && list[index].equals(element)) 
                System.out.println(true); 
            else
                System.out.println(false); 
            
            
        }

    }

    public void set(int index, T element){
        if (list[index]!=null) {
            list[index]=element;
        }
        else{
            System.out.println("la cella era gia vuota");
        }
        

    }
    




}