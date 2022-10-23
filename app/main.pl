% Arriba
aMovimiento(ar) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoX is X - 1,
    retractall(posicion(_,_)),
    asserta(posicion(NuevoX, Y)).

% Abajo
aMovimiento(ab) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoX is X + 1,
    retractall(posicion(_,_)),
    asserta(posicion(NuevoX, Y)).

% Izquierda
aMovimiento(at) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoY is Y - 1,
    retractall(posicion(_,_)),
    asserta(posicion(X, NuevoY)).

% Derecha
aMovimiento(ad) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoY is Y + 1,
    retractall(posicion(_,_)),
    asserta(posicion(X, NuevoY)).

verificarMovimiento(mov(X,Y)) :-
    X >=0, 
    Y >=0.

main :- retractall(fila(_)), retractall(posicion(_,_)), leerArchivo, buscarInicio.

leerArchivo:-
    write("Ingrese la ubicacion del archivo: "),
    read(M),
    open(M,read,Str),
    obtenerLaberinto(Str,Matriz),
    close(Str),
    asserta(matriz(Matriz)).
   
obtenerLaberinto(Stream,[]) :-
   at_end_of_stream(Stream).
   
obtenerLaberinto(Stream,[X|L]) :-
    read(Stream,X),
    obtenerLaberinto(Stream,L).

movimiento :- write("donde: "), read(M), aMovimiento(M).


buscarInicio :- matriz([A|B]), member(i, A), I is 0, J is 0, asserta(posicion(I, J)).
buscarInicio :- matriz([A|B]), not(member(i, A)), I is 1, J is 0, buscarInicio2(B, I, J).

buscarInicio2([A|B], I, J) :- member(i, A), buscarInicio3(A, I, J).
buscarInicio2([A|B], I, J) :- not(member(i, A)), R is I+1, buscarInicio2(B, R, J).

buscarInicio3([A|B], I, J) :- A == i, asserta(posicion(I, J)).
buscarInicio3([A|B], I, J) :- A =\= i, R is J+1, buscarInicio3(B, I, R).


im :- matriz([A|B]), member(i, A).
im2([A|B]) :- write(A),nl, im2(B).
im2([]).


