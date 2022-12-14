package Listas.Dinamicas;

public class ListaDoble {
    private NodoDoble start, end, auxiliarBusqueda, auxiliarIntercambio;

    public void input(int dato){
        NodoDoble nodoInput = new NodoDoble(dato);

        if(start == null && end == null){
            start = end = nodoInput;
        }
        else if(start.dato > dato){
            auxiliarIntercambio = start;
            start = nodoInput;
            start.nodoSiguiente = auxiliarIntercambio;
            auxiliarIntercambio.nodoAnterior = start;
        }
        else if(end.dato < dato){
            auxiliarIntercambio = end;
            end = nodoInput;
            end.nodoAnterior = auxiliarIntercambio;
            auxiliarIntercambio.nodoSiguiente = end;
        }
        else{
            buscarPosicion(dato);
            auxiliarIntercambio = auxiliarBusqueda.nodoSiguiente;
            nodoInput.nodoSiguiente = auxiliarIntercambio;
            nodoInput.nodoAnterior = auxiliarBusqueda;
            auxiliarBusqueda.nodoSiguiente = nodoInput;

        }
    }

    public void output(int dato){
        if(start == null && end == null){
            System.out.println("Underflow");
        }
        else if(start.dato == dato){
            System.out.println(start.dato);
            auxiliarIntercambio = start.nodoSiguiente;
            start = auxiliarIntercambio;
        }
        else if(end.dato == dato){
            System.out.println(end.dato);
            auxiliarIntercambio = end.nodoAnterior;
            end = auxiliarIntercambio;
        }
        else{
            buscarPosicion(dato);
            if(auxiliarBusqueda.nodoSiguiente.dato == dato){
                System.out.println(auxiliarBusqueda.nodoSiguiente.dato);

                auxiliarIntercambio = auxiliarBusqueda.nodoSiguiente.nodoSiguiente;
                auxiliarIntercambio.nodoAnterior = auxiliarBusqueda;
                auxiliarBusqueda.nodoSiguiente = auxiliarIntercambio;

            }else{
                System.out.println("El dato no existe en la lista");
            }
        }
        
    }

    private void buscarPosicion(int dato){
        auxiliarBusqueda = start;

        while(auxiliarBusqueda.nodoSiguiente != null && auxiliarBusqueda.nodoSiguiente.dato < dato){
            auxiliarBusqueda = auxiliarBusqueda.nodoSiguiente;
        }
    }

    public void mostrarDatos(){
        auxiliarBusqueda = start;

        System.out.println(auxiliarBusqueda.dato);

        while(auxiliarBusqueda.nodoSiguiente != null){
            auxiliarBusqueda = auxiliarBusqueda.nodoSiguiente;
            System.out.println(auxiliarBusqueda.dato);

        }
    }

    ListaDoble(){
        start = end = auxiliarBusqueda = auxiliarIntercambio = null;
    }
}
