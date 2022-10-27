:- style_check(-singleton).
% Arriba
aMovimiento(ar) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoX is X - 1,
    verificarMovimiento(NuevoX, Y),

    retractall(posicionAnt(_,_)),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(posicionAnt(X, Y)),
    asserta(mov(ar)),
    asserta(posicion(NuevoX, Y)).

% Abajo
aMovimiento(ab) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoX is X + 1,
    verificarMovimiento(NuevoX, Y),

    retractall(posicionAnt(_,_)),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(posicionAnt(X, Y)),
    asserta(mov(ab)),
    asserta(posicion(NuevoX, Y)).

% Izquierda
aMovimiento(at) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoY is Y - 1,
    verificarMovimiento(X, NuevoY),

    retractall(posicionAnt(_,_)),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(posicionAnt(X, Y)),
    asserta(mov(at)),
    asserta(posicion(X, NuevoY)).

% Derecha
aMovimiento(ad) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoY is Y + 1,
    verificarMovimiento(X, NuevoY),

    retractall(posicionAnt(_,_)),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(posicionAnt(X, Y)),
    asserta(mov(ad)),
    asserta(posicion(X, NuevoY)).

verificarMovimiento(X, Y) :- 
    X >=0, 
    Y >=0.

limpieza :- retractall(fila(_)), retractall(posicion(_,_)).

leerArchivo(M) :-
    open(M,read,Str),
    obtenerLaberinto(Str,Matriz, _),
    close(Str),
    asserta(matriz(Matriz)),
    buscarInicio.
    
devolverMatriz(X) :- matriz(X).
obtenerPosicionActual(X, Y) :- posicion(X, Y).
   
obtenerLaberinto(_,[], R) :-
   R == end_of_file,
   !. % Green Cut at the end of the file
   
obtenerLaberinto(Stream,[X|L], R) :-
    read(Stream,X),
    obtenerLaberinto(Stream,L, X).

buscarInicio :- matriz([A|B]), member(i, A), I is 0, J is 0, asserta(posicion(I, J)), asserta(posicionAnt(I, J)), !.
buscarInicio :- matriz([A|B]), not(member(i, A)), I is 1, J is 0, buscarInicio2(B, I, J).
buscarInicio.

buscarInicio2([A|B], I, J) :- member(i, A), buscarInicio3(A, I, J).
buscarInicio2([A|B], I, J) :- not(member(i, A)), R is I+1, buscarInicio2(B, R, J).
buscarInicio2([],_,_).

buscarInicio3([A|B], I, J) :- A == i, asserta(posicion(I, J)), asserta(posicionAnt(I, J)),!.
buscarInicio3([A|B], I, J) :- not(A == i), R is J+1, buscarInicio3(B, I, R).
buscarInicio3([],_,_).

movimiento(M) :- aMovimiento(M), ubicarJugador. %% revisar aMovimiento porque da true, tengo que verificar el movimiento primero

ubicarJugador :- posicion(I, J), matriz([A|B]), I =\= 0, R is 1, ubicarJugadorI(R, B).
ubicarJugador :- posicion(I, J), matriz([A|B]), I == 0, R is 0, ubicarJugador3(R, A).

ubicarJugadorI(X, [A|B]) :- posicion(I, J), X == I, R is 0, ubicarJugadorJ(R, A).
ubicarJugadorI(X, [A|B]) :- posicion(I, J), X =\= I, R is X+1, ubicarJugadorI(R, B).

ubicarJugadorJ(X, [A|B]) :- posicion(I, J), X == J, write(I), nl , write(J), verificarPosicion(A).
ubicarJugadorJ(X, [A|B]) :- posicion(I, J), X =\= J, R is X+1, ubicarJugadorJ(R, B). 

%%verificarPosicion(C) :- write(C), nl,  mov(T), C == T ; C == inter, write("si"), nl,!.
%%verificarPosicion(C) :- write(C), nl,  C == f, write("termino"), nl.
verificarPosicion(C) :- mov(T), write(C),nl, C == x ; not(C == T), fail, write("no"), nl ,posicionAnt(X_a, Y_a), posicion(X, Y), retractall(posicion(_,_)), asserta(posicion(X_a, Y_a)), fail.


verificarGane :- matriz([A|B]).

probar(X) :-  X is 1.
p2(R) :- R == 2 , R == 1, write("si"). 
im :- matriz([A|B]), member(i, A).
im2([A|B]) :- write(A),nl, im2(B).
im2([]).


