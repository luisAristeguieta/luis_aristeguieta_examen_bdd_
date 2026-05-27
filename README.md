# luis_aristeguieta_examen_bdd_

# Parte 2:
EL link de la parte 2 es: 
https://institutomovilis-my.sharepoint.com/:v:/g/personal/le_aristeguieta_movilis_edu_ec/IQAt3D8hzDH5Qb-giXnYu61wAQvjhVNE0Tq6PRV2BYTJ5_E?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=62DAqU


# Parte 3: Mantenimiento y Extensibilidad

Se realiza el nuevo requisito que es agregar un nuveo atributo, para esto se agregó en la base de postgresql
ALTER TABLE vuelos ADD COLUMN destino VARCHAR(100); y luego este en el campo `destino` a la entidad Vuelo 
para permitir registrar el destino de cada vuelo.

Cuando en Entidad Vuelo.java:
Se añadió el atributo destino
Se agregó mapeo JPA @Column(name = "destino", length = 100) esto es lo especificado en el examen para posteriormente agregar getters y setters
Controlador y servicio Se ajustaron las operaciones CRUD para incluir el nuevo campo, en actulizar se setea solo en actulizar
y para el caso de postman ya que no es un campo obligatorio se puede dejar null o no enviar pero para hacer referencia se agrego uno con un destino