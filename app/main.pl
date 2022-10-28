:- style_check(-singleton).
% Arriba
aMovimiento(ar) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoX is X - 1,

    retractall(posV(_, _)),
    asserta(posV(NuevoX, Y)),
    
    retractall(mov(_)),
    asserta(mov(ar)),
    ubicarJugador.

% Abajo
aMovimiento(ab) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoX is X + 1,

    retractall(posV(_, _)),
    asserta(posV(NuevoX, Y)),

    retractall(mov(_)),
    asserta(mov(ab)),
    ubicarJugador.


% Izquierda
aMovimiento(at) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoY is Y - 1,

    retractall(posV(_, _)),
    asserta(posV(X, NuevoY)),

    retractall(mov(_)),
    asserta(mov(at)),
    ubicarJugador.

% Derecha
aMovimiento(ad) :-
    posicion(I, J),
    X is I,
    Y is J,
	NuevoY is Y + 1,

    retractall(posV(_, _)),
    asserta(posV(X, NuevoY)),

    retractall(mov(_)),
    asserta(mov(ad)),
    ubicarJugador.


aMovimientoVerificado(ar) :-
    posV(X, Y),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(mov(ar)),
    asserta(posicion(X, Y)).

aMovimientoVerificado(ab) :-
    posV(X, Y),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(mov(ab)),
    asserta(posicion(X, Y)).

aMovimientoVerificado(at) :-
    posV(X, Y),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(mov(at)),
    asserta(posicion(X, Y)).
    
aMovimientoVerificado(ad) :-
    posV(X, Y),
    retractall(posicion(_,_)),
    retractall(mov(_)),

    asserta(mov(ad)),
    asserta(posicion(X, Y)).

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

movimiento(M) :- aMovimiento(M). %% revisar aMovimiento porque da true, tengo que verificar el movimiento primero

ubicarJugador :- posV(I, J), matriz([A|B]), I =\= 0, R is 1, ubicarJugadorI(R, B).
ubicarJugador :- posV(I, J), matriz([A|B]), I == 0, R is 0, ubicarJugadorJ(R, A).

ubicarJugadorI(I, [A|B]) :- posV(I, J), R is 0, ubicarJugadorJ(R, A).
ubicarJugadorI(X, [A|B]) :- posV(I, J), X =\= I, R is X+1, ubicarJugadorI(R, B).

ubicarJugadorJ(J, [A|B]) :- posV(I, J), write(I), nl , write(J), retractall(valorActual(_)), asserta(valorActual(A)).
ubicarJugadorJ(X, [A|B]) :- posV(I, J), X =\= J, R is X+1, ubicarJugadorJ(R, B). 

verificarPosicion :- valorActual(C), not(C == x),  write("si"), !.
verificarGane :- valorActual(C), C == f, write("termino"), nl, !.


probar(X) :-  X is 1.
p2(R) :- R == 2 , R == 1, write("si"). 
im :- matriz([A|B]), member(i, A).
im2([A|B]) :- write(A),nl, im2(B).
im2([]).



p :- read(M), p3(M).
p3(M) :- read(X), p4(M, X).
p4(M,X) :- Y = inter, Y==X.