package examen1a.alfonsos;
	
	public class Cordenadas {
	    private int fila;
	    private int columna;

	    public Coordenadas(int fila, int columna) {
	        this.fila = fila;
	        this.columna = columna;
	    }

	    public int getFila() {
	        return fila;
	    }

	    public void setFila(int fila) {
	        this.fila = fila;
	    }

	    public int getColumna() {
	        return columna;
	    }

	    public void setColumna(int columna) {
	        this.columna = columna;
	    }
	}

	public abstract class Pieza {
	    protected Coordenadas posicion;

	    public Pieza(Coordenadas posicion) {
	        this.posicion = posicion;
	    }

	    public abstract List<Coordenadas> calcularMovimientos();

	    protected boolean esPosicionValida(int fila, int columna) {
	        return fila >= 1 && fila <= 8 && columna >= 1 && columna <= 8;
	    }
	}

//peon

	public class Peon extends Pieza {
	    private boolean esUnPrimerMovimiento;

	    public Peon(Coordenadas posicion, boolean esUnPrimerMovimiento) {
	        super(posicion);
	        this.esPrimerMovimiento = esUnPrimerMovimiento;
	    }
	
	    public List<Coordenadas> calcularMovimientos() {
	        List<Coordenadas> movimientos = new ArrayList<>();
	        	
	        int filaActual = posicion.getFila();
	        int columnaActual = posicion.getColumna();
	        
	        if (esUnPrimerMovimiento) {
	            for (int i = 1; i <= 2; i++) {
	                int nuevaFila = filaActual + i;
	                if (esPosicionValida(nuevaFila, columnaActual)) {
	                    movimientos.add(new Coordenadas(nuevaFila, columnaActual));
	                }
	            }
	        } else {
	            int nuevaFila = filaActual + 1;
	            if (esPosicionValida(nuevaFila, columnaActual)) {
	                movimientos.add(new Coordenadas(nuevaFila, columnaActual));
	            }
	        }
	        
	        return movimientos;
	    }
	}

	//Torre
	
	public class Torre extends Pieza {
	    public Torre(Coordenadas posicion) {
	        super(posicion);
	    }

	    public List<Coordenadas> calcularMovimientos() {
	        List<Coordenadas> movimientos = new ArrayList<>();
	        
	        int filaActual = posicion.getFila();
	        int columnaActual = posicion.getColumna();
	        
	        // Movimientos horizontales
	        for (int i = 1; i <= 7; i++) {
	            int nuevaColumna = columnaActual + i;
	            if (esPosicionValida(filaActual, nuevaColumna)) {
	                movimientos.add(new Coordenadas(filaActual, nuevaColumna));
	            }
	            nuevaColumna = columnaActual - i;
	            if (esPosicionValida(filaActual, nuevaColumna)) {
	                movimientos.add(new Coordenadas(filaActual, nuevaColumna));
	            }
	        }
	        
	        // Movimientos verticales
	        for (int i = 1; i <= 7; i++) {
	            int nuevaFila = filaActual + i;
	            if (esPosicionValida(nuevaFila, columnaActual)) {
	                movimientos.add(new Coordenadas(nuevaFila, columnaActual));
	            }
	            nuevaFila = filaActual - i;
	            if (esPosicionValida(nuevaFila, columnaActual)) {
	                movimientos.add(new Coordenadas(nuevaFila, columnaActual));
	            }
	        }
	        
	        return movimientos;
	   
	    }
	

	// Rey

	public class Rey extends Pieza {
	    public Rey(Coordenadas posicion) {
	        super(posicion);
	    }

	    
	    public List<Coordenadas> calcularMovimientos() {
	        List<Coordenadas> movimientos = new ArrayList<>();
	        
	        int filaActual = posicion.getFila();
	        int columnaActual = posicion.getColumna();
	        
	        // Movimientos en todas las direcciones (horizontal, vertical y diagonal)
	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                if (i == 0 && j == 0) continue;
	                
	                int nuevaFila = filaActual + i;
	                int nuevaColumna = columnaActual + j;
	                
	                if (esPosicionValida(nuevaFila, nuevaColumna)) {
	                    movimientos.add(new Coordenadas(nuevaFila, nuevaColumna));
	                }
	            }
	        }
	        
	        return movimientos;
	    }
	}


	// Main
	public class Main {
	    public static void main(String[] args) {
	        Tablero tablero = new Tablero();

	        Coordenadas posicionPeon = new Coordenadas("coordenadas que deseemos x, y"));
	        Peon peon = new Peon(posicionPeon, true); 
	        
	        List<Coordenadas> casillasPeon = tablero.calcularCasillasOcupables(peon);
	        System.out.println("Casillas ocupables por el peón: " + casillasPeon.size());

	        Coordenadas posicionTorre = new Coordenadas("otras coordenadas para ubicar la torre x, y);
	        Torre torre = new Torre(posicionTorre);
	        
	        List<Coordenadas> casillasTorre = tablero.calcularCasillasOcupables(torre);
	        System.out.println("Casillas ocupables por la torre: " + casillasTorre.size());
	    }
	}

