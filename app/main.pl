row(N, Matrix, Row) :- nth0(N, Matrix, Row).

get :- row(N, [[1,2],[3,3]], [A|B]), write(A).

col(N,Col) :- X = [[1,2,3],[23,4,5],[1,3,5]],
    maplist(nth1(N), X, Col).



movimiento(X, Y, Direccion).

% Arriba
aMovimiento(mov(X, Y), ar, p(nuevoX, Y)) :-
	nuevoX is X - 1.

% Abajo
aMovimiento(mov(X,Y), ab, p(nuevoX, Y)) :-
	nuevoX is X + 1.

% Izquierda
aMovimiento(mov(X,Y), at, p(X, nuevoY)) :-
	nuevoY is Y - 1.

% Derecha
aMovimiento(  mov(X,Y), ad, p(X, nuevoY)) :-
	nuevoY is Y + 1.

verificarMovimiento(mov(X,Y)) :-
    X >=0, 
    Y >=0.



leerArchivo:-
    retractall(fila(_)),
    write("Ingrese la ubicacion del archivo: "),
    read(M),
    open(M,read,Str),
    obtenerLaberinto(Str,Matriz),
    close(Str),
    asserta(matriz(Matriz)),
    buscarInicio.
   
obtenerLaberinto(Stream,[]) :-
   at_end_of_stream(Stream).
   
obtenerLaberinto(Stream,[X|L]) :-
    read(Stream,X),
    obtenerLaberinto(Stream,L).


buscarInicio :- matriz([A|B]), member(i, A), I is 0, J is 0, asserta(posicion(I, J)).
buscarInicio :- matriz([A|B]), not(member(i, A)), I is 1, J is 0, buscarInicio2(B, I, J).

buscarInicio2([A|B], I, J) :- member(i, A), buscarInicio3(A, I, J).
buscarInicio2([A|B], I, J) :- not(member(i, A)), R is I+1, buscarInicio2(B, R, J).

buscarInicio3([A|B], I, J) :- A == i, asserta(posicion(I, J)).
buscarInicio3([A|B], I, J) :- A =\= i, R is J+1, buscarInicio3(B, I, R).


im :- matriz([A|B]), member(i, A).
im2([A|B]) :- write(A),nl, im2(B).
im2([]).
