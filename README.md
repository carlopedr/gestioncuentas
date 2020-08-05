# gestioncuentas

Proyecto básico de Gestión de Cuentas - Curso POO TDS USCO 2020A

Como proyecto de finalización del cuso de Programación Orienta a Objetos basada en Java
del Programa de Tecnología en Desarrollo de Software de la Facultad de Ingeniera se realiza 
el siguiente proyecto:

Definir una clase abstracta Cuenta con los siguientes atributos:
•	numerocuenta : entero largo
•	saldo : double
•	cliente : atributo de la clase Persona (que tiene nombre y apellidos, Número de documento de id y tipo de documento de id)
 y con los siguientes métodos:
•	Constructor parametrizado que recibe un cliente y un número de cuenta
•	Setters y getters para los tres atributos
•	ingresar(double): permitirá ingresar una cantidad en la cuenta.
•	abstract retirar(double): permitirá sacar una cantidad de la cuenta (si hay saldo). No se implementa, depende del tipo de cuenta
•	actualizarSaldo(): actualizará el saldo de la cuenta, pero cada cuenta lo hace de una forma diferente

Define las subclases de Cuenta que se describen a continuación:

•	CuentaCorriente: Cuenta normal con un interés fijo del 1.5%. Incluir constructor parametrizado y método toString().
•	CuentaAhorro: Esta cuenta tiene como atributos el interés variable a lo largo del año y un saldo mínimo necesario. 
  Al retirar dinero hay que tener en cuenta que no se sobrepase el saldo mínimo. Incluir constructor parametrizado, método toString() y método para cambiar el interés.

Crea un programa que cree varias cuentas y pruebe sus características.

El ejercicio se extendio para manejar múltiples cuentas asociadas a cuentas y lsas salidas y entradas de dinero se manejan por cencpetos y transacciones.
Se decidió usa los patrones MVC - Modelo Vista Controlador y DAO (Data Access Object) para la persistencia, que para efectos pedagógicos se esta realizando con archivos XML

