# TEST DE FIBONACCI

### Endpoints

* Enesimo Fibonacci {host}/test/api/fibonacci/{enesimo}
* Estadistica de un número enésimo consultado: {host}/test/api/fibonacci/{enesimo}/estadistica

### BD
_La base de datos está en postgreSQL, se creo un respaldo de la misma para ser importada y usada.
Contiene lo siguiente:_

* Tabla Fibonacci:
```
create table fibonacci
(
id serial not null primary key,
numero bigint not null
)
```
* Tabla estadística:
```
create table fibonacci_estadistica
(
id serial not null primary key,
numero_solicitado bigint,
cantidad int
);
```
* Función para cargar datos de fibonacci:

```
CREATE OR REPLACE FUNCTION INSERTAR_FIBONACCI(n bigint) returns INTEGER
 language plpgsql
  as
$$
	DECLARE
      anterior bigint;
      actual bigint;
       swap bigint;
      indice bigint;
      suma bigint;
begin
	 anterior:=0;
	 actual:=1;
	 swap:=0;
	indice:=1;
	insert into fibonacci (numero) values (0);
    insert into fibonacci (numero) values (1);
	while (indice <  (n-2) ) loop
	 begin
	    suma:= anterior + actual;
	    insert into fibonacci(numero) values (suma);
	    swap:=anterior;
	    anterior:=actual;
	    actual:=suma;
	    indice:=indice +1;
	   end;
 	 end loop;
return 1;
end;
$$;

select  INSERTAR_FIBONACCI(50); 
```

