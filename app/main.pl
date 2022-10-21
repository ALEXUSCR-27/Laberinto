row(N, Matrix, Row) :- nth0(N, Matrix, Row).

get :- row(N, [[1,2],[3,3]], [A|B]), write(A).

col(N,Col) :- X = [[1,2,3],[23,4,5],[1,3,5]],
    maplist(nth1(N), X, Col).

abrirArchivo :- read(M), open(M, read,Hola), read(Hola, H1), close(Hola), write(H1).

leerArchivo:-
    write("Ingrese la ubicacion del archivo: "),
    read(M),
    open(M,read,Str),
    obtenerLaberinto(Str,Matriz),
    close(Str),
    buscarInicio(Matriz, 0).
   
obtenerLaberinto(Stream,[]) :-
   at_end_of_stream(Stream).
   
obtenerLaberinto(Stream,[X|L]) :-
    \+  at_end_of_stream(Stream),
    read(Stream,X),
    obtenerLaberinto(Stream,L).

buscarInicio([A|B], Cont) :- verificarInicio(A, Cont), write("se encontro "), write(A), write(Cont).
buscarInicio([A|B], Cont) :- not(verificarInicio(A, Cont)),R1 is Cont+1, buscarInicio(B, R1).
buscarInicio([]) :- write("No se encontro el inicio del laberinto").

verificarInicio([A|B], Cont) :- A == i.
verificarInicio([A|B], Cont) :- verificarInicio(B, R1).
verificarInicio([], Cont) :- false.


imprimir1([A|B]) :- imprimir2(A).
imprimir2([A|B]) :- A == x, write("es igual").
imprimir2([A|B]) :- A =\= "x", write("no es igual").